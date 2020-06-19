package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class AskCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		MultipartRequest multi = null;

		int sizeLimit = 10 * 1024 * 1024;

		ServletContext context = request.getSession().getServletContext();
		String savePath = context.getRealPath("/upload");

		//
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
		}

		String filename = multi.getFilesystemName("filename");

		String id = multi.getParameter("id");
		String writer = multi.getParameter("writer");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");

		BoardDAO dao = new BoardDAO();
		dao.insert(new BoardDTO(id, -1, writer, title, content, null, 0, 0, 0, 0, filename));

		return new CommandAction(true, "qnalist.do?id=" + id);

	}

}
