package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.command.Command;
import kr.co.domain.CommandAction;




@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FrontController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());
		
		Command com = null;
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("/loginui.do", "kr.co.member.LoginUICommand");
		map.put("/login.do", "kr.co.member.LoginCommand");
		map.put("/logout.do", "kr.co.member.LogoutCommand");
		map.put("/memberinfo.do", "kr.co.member.MemberinfoCommand");
		map.put("/qnaUpdateui.do", "kr.co.controller.QnaUpdateUICommand");
		map.put("/qnaUpdate.do", "kr.co.controller.QnaUpdateCommand");
		map.put("/qnalist.do", "kr.co.controller.ListPageCommand");
		map.put("/askui.do","kr.co.controller.AskUICommand");
		map.put("/ask.do","kr.co.controller.AskCommand");
		map.put("/read.do","kr.co.controller.ReadCommand");
		map.put("/qnaDelete.do","kr.co.controller.QnaDeleteCommand");
		map.put("/replyui.do","kr.co.controller.ReplyUICommand");
		map.put("/reply.do","kr.co.controller.ReplyCommand");
		map.put("/asklist.do","kr.co.controller.MyAskListCommand");
		map.put("/replylist.do","kr.co.controller.MyReplyListCommand");
		map.put("/insertui.do", "kr.co.member.InsertUICommand");
		map.put("/insert.do", "kr.co.member.InsertCommand");
		map.put("/updateui.do", "kr.co.member.UpdateUICommand");
		map.put("/update.do", "kr.co.member.UpdateCommand");
		map.put("/delete.do", "kr.co.member.DeleteCommand");
		map.put("/insertQnaComment.do","kr.co.controller.PutQnaCommentCommand");
		map.put("/replyComment.do","kr.co.controller.ReplyComCommand");
		map.put("/updateComment.do", "kr.co.controller.UpdateComCommand");
		map.put("/deleteComment.do", "kr.co.controller.DeleteComCommand");
		
		try {
			com = (Command) Class.forName(map.get(sp)).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (com != null) {
			CommandAction action = com.execute(request, response);
			if (action.isReDirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
