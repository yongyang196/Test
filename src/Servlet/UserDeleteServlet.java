package Servlet;

import User.UserDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        int i=0;
        String userid=request.getParameter("userid");
        UserDemo userDemo=new UserDemo();
        try {
            i=userDemo.delete(userid);
            System.out.println(i);
            if (i>0){
                out.print("true");
            }
            else {
                out.print("false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
