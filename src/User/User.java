package User;

public class User {
    private String userid;
    private String username;
    private String userpwd;
    private String usertel;
    private String usersex;
    private String userlevel;
    public User(){}
    public User(String userid,String username,String userpwd,String usertel,String usersex,String userlevel){
        this.userid=userid;
        this.username=username;
        this.userpwd=userpwd;
        this.usertel=usertel;
        this.usersex=usersex;
        this.userlevel=userlevel;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public String getUsersex() {
        return usersex;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public String getUsername() {
        return username;
    }

}
