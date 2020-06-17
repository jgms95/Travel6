package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;


public class ReplyCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String sNum = request.getParameter("num");
		int orgnum = -1; //원글의 num
		if(sNum!=null) {
			orgnum = Integer.parseInt(sNum);
		}
		String writer = request.getParameter("writer");
		String title = "Re: " + request.getParameter("title") ;
		String content = request.getParameter("content");
	
		
		
		

		
			BoardDAO dao = new BoardDAO();
			BoardDTO dto = new BoardDTO(id, -1, writer, title, content, null, 0, -1, -1, -1);
			dao.reply(orgnum,dto);
			
			return new CommandAction(true, "qnalist.do?id="+id);
		
	
		
		
		
	}

}
