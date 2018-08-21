package News;

public class News {
    private String newsid;
    private String newsitem;
    private String newsauthor;
    private String newsdate;
    private String newsfile;
    private int newsreadnum;
    public News(){}
    public News(String newsid,String newsitem,String newsauthor,String newsdate,String newsfile,int newsreadnum){
        this.newsid=newsid;
        this.newsitem=newsitem;
        this.newsauthor=newsauthor;
        this.newsdate=newsdate;
        this.newsfile=newsfile;
        this.newsreadnum=newsreadnum;
    }

    public String getNewsauthor() {
        return newsauthor;
    }

    public void setNewsauthor(String newsauthor) {
        this.newsauthor = newsauthor;
    }

    public String getNewsdate() {
        return newsdate;
    }

    public String getNewsfile() {
        return newsfile;
    }

    public String getNewsid() {
        return newsid;
    }

    public String getNewsitem() {
        return newsitem;
    }

    public int getNewsreadnum() {
        return newsreadnum;
    }

    public void setNewsdate(String newsdate) {
        this.newsdate = newsdate;
    }

    public void setNewsfile(String newsfile) {
        this.newsfile = newsfile;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public void setNewsitem(String newsitem) {
        this.newsitem = newsitem;
    }

    public void setNewsreadnum(int newsreadnum) {
        this.newsreadnum = newsreadnum;
    }
}
