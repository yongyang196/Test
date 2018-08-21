package Servlet;

import News.News;
import News.NewsDemo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseTraversers;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "NewsUploadServlet")
public class NewsUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        PrintWriter out=response.getWriter();
        String newsid=null;
        String newsitem=null;
        String newsdate=null;
        String newsauthor=null;
        List<News> newsList=null;
        String newsfile=null;
        int newsreadnum=0;
        if (isMultipart){
            FileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);

            try {
                List<FileItem> items=upload.parseRequest(request);
                Iterator<FileItem> iter=items.iterator();
                Map<String,String> params=new HashMap<>();
                String filename=null;
                while (iter.hasNext()){
                    FileItem item=iter.next();
                    if (item.isFormField()){
                        String name=item.getFieldName();
                        String value=item.getString("utf-8");
                        params.put(name,value.trim());
                        response.setContentType("text/html;charset=utf-8");
                        newsitem=params.get("newsitem");
                        newsauthor=params.get("newsauthor");
                        newsdate=params.get("newsdate");
                    }
                    else {
                        filename=item.getName();
                        filename= FilenameUtils.getName(filename);
                        filename=newsdate+"-"+filename;
                        String extension=FilenameUtils.getExtension(filename);
                        String filepath="F:\\NewsReleaseSystem\\upload/"+filename;
                        item.write(new File(filepath));
                        newsfile=filename;
                    }
                }


            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (!newsitem.equals("")&&!newsauthor.equals("")&&!newsdate.equals("")&&!newsfile.equals("")){
            NewsDemo newsDemo=new NewsDemo();
            try {
                newsDemo.select();
                newsList=newsDemo.getNewsList();
                int size=newsList.size();
                if (size==0){
                    newsid="000";
                }
                else {
                    newsid="00"+(size);
                }

                News news=new News(newsid,newsitem,newsauthor,newsdate,newsfile,newsreadnum);
                int i=newsDemo.insert(news);
                if (i>0){
                    response.sendRedirect("newslist.jsp");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            request.getRequestDispatcher("newsupload.jsp").forward(request,response);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
