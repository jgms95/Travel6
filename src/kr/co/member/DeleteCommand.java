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
				dao.delete(new LoginDTO(id, null));
				
				session.invalidate();
				return new CommandAction(true, "main.jsp");
			}

		}
		return new CommandAction(true, "loginui.do");
	}

}
