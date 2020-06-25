package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.Command;
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
		map.put("/findIdUi.do", "kr.co.member.FindIdUICommand");
		map.put("/findPwUi.do", "kr.co.member.FindPwUICommand");
		map.put("/findId.do", "kr.co.member.FindIdCommand");
		map.put("/findPw.do", "kr.co.member.FindPwCommand");
		map.put("/insertui.do", "kr.co.member.InsertUICommand");
		map.put("/insert.do", "kr.co.member.InsertCommand");
		map.put("/updateui.do", "kr.co.member.UpdateUICommand");
		map.put("/update.do", "kr.co.member.UpdateCommand");
		map.put("/delete.do", "kr.co.member.DeleteCommand");
		
		map.put("/board6qnaUpdateui.do", "kr.co.board6.command.QnaUpdateUICommand");
		map.put("/board6qnaUpdate.do", "kr.co.board6.command.QnaUpdateCommand");
		map.put("/board6qnalist.do", "kr.co.board6.command.ListPageCommand");
		map.put("/board6askui.do","kr.co.board6.command.AskUICommand");
		map.put("/board6ask.do","kr.co.board6.command.AskCommand");
		map.put("/board6read.do","kr.co.board6.command.ReadCommand");
		map.put("/board6qnaDelete.do","kr.co.board6.command.QnaDeleteCommand");
		map.put("/board6replyui.do","kr.co.board6.command.ReplyUICommand");
		map.put("/board6reply.do","kr.co.board6.command.ReplyCommand");
		map.put("/board6asklist.do","kr.co.board6.command.MyAskListCommand");
		map.put("/board6replylist.do","kr.co.board6.command.MyReplyListCommand");
		map.put("/board6insertQnaComment.do","kr.co.board6.command.PutQnaCommentCommand");
		map.put("/board6replyComment.do","kr.co.board6.command.ReplyComCommand");
		map.put("/board6updateComment.do", "kr.co.board6.command.UpdateComCommand");
		map.put("/board6deleteComment.do", "kr.co.board6.command.DeleteComCommand");
		map.put("/board6download.do", "kr.co.board6.command.DownloadAction");
		
		try {
			com = (Command) Class.forName(map.get(sp)).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (com != null) {
			CommandAction action = com.execute(request, response);
			if (action.isReDirect()) {
				response.sendRedirect(action.getWhere());
			} else if(action.getWhere()!=null){
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
