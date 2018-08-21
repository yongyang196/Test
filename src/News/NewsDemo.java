package News;

import Mysql.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDemo {
    private List<News> newsList=new ArrayList<>();
    public int insert(News news) throws SQLException {
        Connection conn=Mysql.getConnection();
        String sql="INSERT INTO news(newsid, newsitem,newsauthor, newsdate, newsfile, newsreadnum) VALUES (?,?,?,?,?,?)";
        PreparedStatement psmt=null;
        int i=0;

        try {
            psmt=conn.prepareStatement(sql);
            psmt.setString(1,news.getNewsid());
            psmt.setString(2,news.getNewsitem());
            psmt.setString(3,news.getNewsauthor());
            psmt.setString(4,news.getNewsdate());
            psmt.setString(5,news.getNewsfile());
            psmt.setInt(6,news.getNewsreadnum());
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

    public void select() throws SQLException {
        Connection conn=Mysql.getConnection();
        String sql="SELECT * FROM news";
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try {
            psmt=conn.prepareStatement(sql);
            rs=psmt.executeQuery();
            while (rs.next()){
                News news=new News();
                news.setNewsid(rs.getString("newsid"));
                news.setNewsitem(rs.getString("newsitem"));
                news.setNewsauthor(rs.getString("newsauthor"));
                news.setNewsdate(rs.getString("newsdate"));
                news.setNewsfile(rs.getString("newsfile"));
                news.setNewsreadnum(rs.getInt("newsreadnum"));
                newsList.add(news);
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

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
