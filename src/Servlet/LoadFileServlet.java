package Servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@WebServlet(name = "LoadFileServlet")
public class LoadFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.reset();
        String filename=request.getParameter("newsfile");
        String filepath="F:\\NewsReleaseSystem\\upload\\";
        File file=new File(filepath+filename);
        if (!file.exists()){
            request.setAttribute("msg","你下载的文件已被删除！");
            request.getRequestDispatcher("message.jsp").forward(request,response);
            return;
        }
        String realname=filename.substring(filename.indexOf("_")+1);
        response.addHeader("Content-type", "appllication/octet-stream");
        response.setHeader("content-disposition","attachment;filename="+  URLEncoder.encode(realname, "UTF-8"));
        FileInputStream in=new FileInputStream(file);
        OutputStream out=response.getOutputStream();
        byte buffer[] = new byte[1024];
        int len=0;
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }
}
