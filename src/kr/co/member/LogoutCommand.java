package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kr.co.command.Command;
import kr.co.domain.CommandAction;
import kr.co.domain.LoginDTO;


public class LogoutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			if (login != null) {
				session.invalidate();
				return new CommandAction(true, "main.jsp");
			}
		}
		session.invalidate();
		return new CommandAction(true, "login.do");
	}
}
