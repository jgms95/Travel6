package kr.co.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.CommandAction;

public class QnaDeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id"); // 로그인되어있는 id
		String sNum = request.getParameter("num");
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}

		
		BoardDAO dao = new BoardDAO();
		String filename = dao.read(num).getFilename();
		

		ServletContext context = request.getSession().getServletContext();
		String uploadFileName = context.getRealPath("/upload") + "/" + filename;

		File uploadfile = new File(uploadFileName);
		if (uploadfile.exists() && uploadfile.isFile()) {
			uploadfile.delete(); // 파일 삭제
		}
		
		
		dao.delete(num);
		dao.deleteRelatedcom(num);
		return new CommandAction(true, "qnalist.do?id=" + id);
	}

}
