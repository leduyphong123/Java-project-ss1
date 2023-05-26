package entity;

public class User {
    private int id;
    private String userName;
    private String passWord;
    public User(){};
    public User(int id, String userName, String passWord){
        this.id=id;
        this.userName = userName;
        this.passWord = passWord;
    }
    public int getId(){
        return this.id;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
    public String getPassWord(){
        return this.passWord;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                ", password='" + passWord + '\'' +
                '}';
    }
}
