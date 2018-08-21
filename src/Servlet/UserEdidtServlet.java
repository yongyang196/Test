package Servlet;

import User.User;
import User.UserDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UserEdidtServlet")
public class UserEdidtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        PrintWriter out=response.getWriter();
        String userid= request.getParameter("userid");
        String username=request.getParameter("username");
        String userpwd=request.getParameter("userpwd");
        String usersex=request.getParameter("usersex");
        String userlevel=request.getParameter("userlevel");
        String usertel=request.getParameter("usertel");
        User user=new User(userid,username,userpwd,usertel,usersex,userlevel);
        UserDemo userDemo=new UserDemo();
        try {
            int i=userDemo.update(user);
            if (i>0){
                out.print("true");
            }
            else {
                out.print("false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
