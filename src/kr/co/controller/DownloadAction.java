package kr.co.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.command.Command;
import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
public class DownloadAction implements Command{

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        int num = Integer.parseInt(request.getParameter("num"));
 
        BoardDAO dao = new BoardDAO();
        BoardDTO article = dao.read(num);

        // 파일 이름을 받아서
        String filename = article.getFilename();

        // 실제 파일이 들어있는 경로에 설정한 
        // upload폴더와 파일 이름을 붙여서
        ServletContext context = request.getSession().getServletContext();
        String uploadFileName = context.getRealPath("/upload")+ "/" + filename; 
 
 
        // 해당 스트링에서 파일을 가져온 후
        File downFile = new File(uploadFileName);
 
        // 다운로드
        if (downFile.exists() && downFile.isFile()) {
 
            try {
                // 파일 사이즈 조사하고
                long filesize = downFile.length();

                // content타입과 해더를 셋팅하여 파일을 출력
                response.setContentType("application/x-msdownload");
                response.setContentLength((int) filesize);
                String strClient = request.getHeader("user-agent");
 
                if (strClient.indexOf("MSIE 5.5") != -1) {
                    response.setHeader("Content-Disposition", "filename="
                            + filename + ";");
                } else {
                    response.setHeader("Content-Disposition",
                            "attachment; filename=" + filename + ";");
                }
                response.setHeader("Content-Length", String.valueOf(filesize));
                response.setHeader("Content-Transfer-Encoding", "binary;");
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "private");
 
                byte b[] = new byte[1024];
 
                BufferedInputStream fin = new BufferedInputStream(
                        new FileInputStream(downFile));
 
                BufferedOutputStream outs = new BufferedOutputStream(
                        response.getOutputStream());
 
                int read = 0;
 
                while ((read = fin.read(b)) != -1) {
                    outs.write(b, 0, read);
                }
                outs.flush();
                outs.close();
                fin.close();
            } catch (Exception e) {
                System.out.println("Download Exception : " + e.getMessage());
            }
        } else {
            System.out.println("Download Error : downFile Error [" + downFile
                    + "]");
        }
        return new CommandAction(false, null);

	}

}
