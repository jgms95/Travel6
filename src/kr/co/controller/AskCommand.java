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
	
		// 파일 업로드를 하기 위해서 cos.jar 추가 및 객체 생성
        MultipartRequest multi = null;
 
        // 업로드 될 파일의 최대 사이즈 (10메가)
        int sizeLimit = 10 * 1024 * 1024;
 
        // 파일이 업로드될 실제 tomcat 폴더의 경로 (WebContent 기준)
        ServletContext context = request.getSession().getServletContext();
        String savePath = context.getRealPath("/upload"); 
 
        // 
        try{
            multi=new MultipartRequest(
                    request
                    , savePath
                    , sizeLimit
                    , "UTF-8"
                    , new DefaultFileRenamePolicy()); 
 
         }catch (Exception e) {
                e.printStackTrace();
         } 
         
        //파일 이름 저장
        String filename = multi.getFilesystemName("filename");
      
        
        
		String id = multi.getParameter("id");
		String writer = multi.getParameter("writer");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
	

		
			BoardDAO dao = new BoardDAO();
			dao.insert(new BoardDTO(id, -1, writer, title, content, null, 0, 0, 0, 0,filename));
			
		
			return new CommandAction(true, "qnalist.do?id="+id);
		
	}

}
