package kr.co.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.Command;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;

public class FindIdCommand implements Command{

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}
		Boolean noInfo = false; //없는 정보인가
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.findId(name,age);
		
		if(dto.getId()!=null) {
			request.setAttribute("dto", dto);
			return new CommandAction(false, "IdResult.jsp");
			
		}else {
			noInfo = true;
			request.setAttribute("noInfo", noInfo);
			return new CommandAction(false, "findId.jsp");
		}
		
		
	}

}
