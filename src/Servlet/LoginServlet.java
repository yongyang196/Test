package Servlet;



import User.User;
import User.UserDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String userpwd1=request.getParameter("password1");
        String userpwd2=request.getParameter("password3");
        String usertel=request.getParameter("tel");
        String usersex=request.getParameter("sex");
        String userid;
        String userlevel;
        List<User> userList=null;
        UserDemo userDemo=new UserDemo();
        try {
            userDemo.select();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        userList=userDemo.getUserList();
        int size=userList.size();
//        System.out.println(username);
//        System.out.println(userpwd1);
//        System.out.println(userpwd2);
//        System.out.println(usertel);
//        System.out.println(usersex);
        if (!username.equals("")&&!userpwd1.equals("")&&userpwd1.equals(userpwd2)&&!usertel.equals("")&&!usersex.equals("")){
            userid="00"+(size+1);
//            System.out.println(userid);
            userlevel="1";
            User user=new User(userid,username,userpwd1,usertel,usersex,userlevel);
            try {
                userDemo.insert(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
