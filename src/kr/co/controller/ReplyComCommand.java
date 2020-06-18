package kr.co.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.QnaCommandDTO;

public class ReplyComCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String sNum = request.getParameter("num");
		int orgnum = -1;
		if (sNum != null) {
			orgnum = Integer.parseInt(sNum);
		}
		
		
		String sQnanum = request.getParameter("qnanum");
		int qnanum = -1;
		if (sQnanum != null) {
			qnanum = Integer.parseInt(sQnanum);
		}
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		BoardDAO dao = new BoardDAO();
		QnaCommandDTO dto = new QnaCommandDTO(id, qnanum, -1, writer, content, null, -1, -1, -1);
		dao.replycomment(orgnum, dto);
		return new CommandAction(true, "read.do?num=" + qnanum + "&id=" + id);
	}

}
