package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class QnaUpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");//로그인된 아이디
		String sNumber = request.getParameter("num");
		
		int number = -1;
		if (sNumber != null) {
			number = Integer.parseInt(sNumber);
		}
		String writer = request.getParameter("writer");
		
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.updateUI(number);

		request.setAttribute("dto", dto);
		request.setAttribute("id", id);

		request.setAttribute("writer", writer);
		return new CommandAction(false, "qnaUpdate.jsp");
	}

}
