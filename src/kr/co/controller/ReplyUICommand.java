package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;

public class ReplyUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = -1;
		if(sNum!=null) {
			num = Integer.parseInt(sNum);
		}
		String id = request.getParameter("id");
		
		MemberDAO memberdao = new MemberDAO();
		LoginDTO loginDTO = new LoginDTO(id, null);
		MemberDTO member = memberdao.selectById(loginDTO);
		
		
		request.setAttribute("num", num);
		request.setAttribute("writer", member.getName());
		return new CommandAction(false,"reply.jsp?id="+id);
	}

}
