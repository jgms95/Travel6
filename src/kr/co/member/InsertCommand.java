package kr.co.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.Command;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;



public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}
		boolean exist = false; // 탈퇴한 회원인가 여부
		
		MemberDAO dao = new MemberDAO();
		List<String> alreadyId = dao.selectId(); //이미 가입된 회원인가 여부
		for(String i : alreadyId) {
			if(id.equals(i)) {
				exist = true;
				request.setAttribute("exist", exist);
				return new CommandAction(false, "insertui.jsp");
			}
		}
		
		
		
		List<MemberDTO> existId = dao.selectDeletedId(); //탈퇴한 회원 목록
		
		for(MemberDTO i : existId) {
			if(id.equals(i.getId())) {
				if(name.equals(i.getName())&&(age==i.getAge())){
					dao.chanegeAuthority(id); //탈퇴 해제
					return new CommandAction(true, "loginui.jsp");
				}else {
					exist = true;
					request.setAttribute("exist", exist);
					return new CommandAction(false, "insertui.jsp");
				}
			}
		}
		
		
		dao.insert(new MemberDTO(id, name, age, pw));
		return new CommandAction(true, "loginui.jsp");
	}

}
