package kr.co.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.command.Command;
import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.domain.leaveMemberDTO;


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
		String overlap; //아이디 중복되는가
		
		MemberDAO dao = new MemberDAO();
		List<leaveMemberDTO> leaveinfos = dao.selectLeaveMembers();
		List<String> memberids = dao.selectId();
		
		for(leaveMemberDTO dto : leaveinfos) {
			if(id.equals(dto.getId())) {
				if(name.equals(dto.getName())&&(age==dto.getAge())) {
					dao.deleteLeaveMember(id);
				}else {
					//다시 회원가입 페이지로 이동 후 "가입 불가능한 ID입니다. 다시 입력해주세요" 출력
					overlap = "true";
					return new CommandAction(true, "insertui.do?overlap=" + overlap);
				}
			}
		}
		
		for(String i : memberids) {
			if(id.equals(i)) {
			  // 다시 회원가입 페이지로 이동 후 "가입 불가능한 ID입니다. 다시 입력해주세요" 출력
				overlap = "true";
				return new CommandAction(true, "insertui.do?overlap=" + overlap);
			}
			
		}
		
		
		dao.insert(new MemberDTO(id, name, age, pw));
		
		return new CommandAction(true, "main.jsp");
	}

}
