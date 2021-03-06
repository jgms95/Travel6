package kr.co.member;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kr.co.dao.MemberDAO;
import kr.co.domain.Command;
import kr.co.domain.CommandAction;
import kr.co.dto.LoginDTO;
import kr.co.dto.MemberDTO;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		int count = dao.countMemberStatus();
		if(count==0) {
			dao.insertStatus("01","가입된 상태");
			dao.insertStatus("02","탈퇴 상태");
		}
		
		
		
		List<MemberDTO> existId = dao.selectDeletedId(); //탈퇴한 회원 목록
		for(MemberDTO i : existId) {
			if(id.equals(i.getId())) {
				request.setAttribute("error", "ID와 Password가 일치하지 않습니다.");
				return new CommandAction(false, "loginui.do");
			}
		}
		boolean isLogin = dao.login(new LoginDTO(id, pw));
		
		if (isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("login", new LoginDTO(id, null));
			return new CommandAction(false, "main.jsp");
		} else {
			request.setAttribute("error", "ID와 Password가 일치하지 않습니다.");
			return new CommandAction(false, "loginui.do");
		}
	}

}
