package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.Command;
import kr.co.domain.CommandAction;


public class LoginUICommand implements Command {
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return new CommandAction(false, "loginui.jsp");
	}
}
