package kr.co.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.CommandAction;

public class DeleteComCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}
		String sQnanum = request.getParameter("qnanum");
		int qnanum = -1;
		if (sQnanum != null) {
			qnanum = Integer.parseInt(sQnanum);
		}
		String id = request.getParameter("id"); // 로그인된 id
		
		
		
		BoardDAO dao = new BoardDAO();
		dao.deleteComment(num);
		
		
		
		return new CommandAction(true, "read.do?num=" + qnanum + "&id=" + id);
	}

}
