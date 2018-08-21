package Servlet;

import User.User;
import User.UserDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoadFilterServlet")
public class LoadFilterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String userpwd=request.getParameter("password1");
        ServletContext application=request.getServletContext();
//        System.out.println(userpwd);
        HttpSession session=request.getSession();
        UserDemo userDemo=new UserDemo();
        try {
            userDemo.select();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean state=true;
        List<User> userList=null;
        userList=userDemo.getUserList();
        if (username.equals("")){
            response.sendRedirect("load.jsp");
        }
        else {
            for (User user:userList){
                if (user.getUsername().equals(username)&&user.getUserpwd().equals(userpwd)) {
                    session.setAttribute("username", username);
                    application.setAttribute("level",user.getUserlevel());
                    response.sendRedirect("index.jsp");
                    state=false;
                }
            }
            if (state==true){
                response.sendRedirect("load.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
