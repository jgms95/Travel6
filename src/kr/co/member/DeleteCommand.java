package kr.co.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kr.co.command.Command;
import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;



public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		HttpSession session = request.getSession(false);
		if (session != null) {
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			if (login != null) {
				
				MemberDAO dao = new MemberDAO();
				MemberDTO dto = dao.selectById(login); //기존 회원 테이블에서 탈퇴시키려는 회원 정보를 가져온다.
				dao.insertLeaveInfo(dto); // 탈퇴회원 테이블에 해당 정보를 넣어준다.
				
				dao.delete(new LoginDTO(id, null));
				
				session.invalidate();
				return new CommandAction(true, "main.jsp");
			}

		}
		return new CommandAction(true, "loginui.do");
	}

}
