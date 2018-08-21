package User;

import Mysql.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDemo {
    public List<User> userList=new ArrayList<>();
    public void select() throws SQLException {
        Connection conn=Mysql.getConnection();
        String sql="SELECT * FROM user";
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try {
            psmt=conn.prepareStatement(sql);
            rs=psmt.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setUserid(rs.getString("userid"));
                user.setUsername(rs.getString("username"));
                user.setUserpwd(rs.getString("userpwd"));
                user.setUsertel(rs.getString("usertel"));
                user.setUsersex(rs.getString("usersex"));
                user.setUserlevel(rs.getString("userlevel"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rs!=null){
            rs.close();
        }
        if (psmt!=null){
            psmt.close();
        }
        if (conn!=null){
            conn.close();
        }
    }
    public void insert(User user) throws SQLException {
        Connection conn=Mysql.getConnection();
        String sql="INSERT INTO user(userid, username, userpwd, usertel, usersex,userlevel) VALUES (?,?,?,?,?,?)";
        PreparedStatement psmt=null;
        try {
            psmt=conn.prepareStatement(sql);
            psmt.setString(1,user.getUserid());
            psmt.setString(2,user.getUsername());
            psmt.setString(3,user.getUserpwd());
            psmt.setString(4,user.getUsertel());
            psmt.setString(5,user.getUsersex());
            psmt.setString(6,user.getUserlevel());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (psmt!=null){
            psmt.close();
        }
        if (conn!=null){
            conn.close();
        }
    }

    public int update(User user) throws SQLException {
        Connection conn=Mysql.getConnection();
        String sql="UPDATE user SET username=?, userpwd=?, usertel=?, usersex=?, userlevel=? WHERE userid=?";
        PreparedStatement psmt=null;
        int i=0;
        try {
            psmt=conn.prepareStatement(sql);
            psmt.setString(1,user.getUsername());
            psmt.setString(2,user.getUserpwd());
            psmt.setString(3,user.getUsertel());
            psmt.setString(4,user.getUsersex());
            psmt.setString(5,user.getUserlevel());
            psmt.setString(6,user.getUserid());
            i=psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (psmt!=null){
            psmt.close();
        }
        if (conn!=null){
            conn.close();
        }
        return i;
    }

    public int delete(String userid) throws SQLException {
        Connection conn=Mysql.getConnection();
        String sql="DELETE FROM user WHERE userid=?";
        PreparedStatement psmt=null;
        int i=0;
        try {
            psmt=conn.prepareStatement(sql);
            psmt.setString(1,userid);
            i=psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (psmt!=null){
            psmt.close();
        }
        if (conn!=null){
            conn.close();
        }
        return i;
    }
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
