package kr.co.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class MyReplyListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		BoardDAO dao = new BoardDAO();

		List<BoardDTO> list = dao.getReplyRepRoots(id);// repRoot 리스트
	
		request.setAttribute("list", list);

		return new CommandAction(false, "replylist.jsp");
	}

	
}
