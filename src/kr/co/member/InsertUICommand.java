package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.command.Command;
import kr.co.domain.CommandAction;

public class InsertUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sOverlap = request.getParameter("overlap")!=null ? request.getParameter("overlap") : "false"; //아이디 중복여부
		boolean overlap = sOverlap.equals("true") ? true : false;
		
		request.setAttribute("overlap", overlap);
		return new CommandAction(false, "insertui.jsp");
	}

}
