package kr.co.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.LoginDTO;
import kr.co.domain.MemberDTO;
import kr.co.domain.PageTO;

public class ListPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String scurPage = request.getParameter("curPage");
		int curPage = 1;
		if(scurPage!=null) {
			curPage = Integer.parseInt(scurPage);
		}
		String id = request.getParameter("id");
		
		MemberDAO memberdao = new MemberDAO();
		LoginDTO loginDTO = new LoginDTO(id, null);
		MemberDTO member = memberdao.selectById(loginDTO);
				
		BoardDAO dao = new BoardDAO();
		PageTO to = dao.page(curPage);
		
		request.setAttribute("to", to);
		request.setAttribute("list", to.getList());
		request.setAttribute("writer", member.getName());
		return new CommandAction(false, "qnalist.jsp");
	}

}
