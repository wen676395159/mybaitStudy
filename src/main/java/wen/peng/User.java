package wen.peng;

public class User {

    public  User (){

    }

    public User(int userId, String name, String mydepart, boolean sex) {
        id = userId;
        this.name = name;
        this.mydepart = mydepart;
        this.sex = sex;
    }

    private  int id;
    private  String name;
    private  String mydepart;
    private  boolean sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMydepart() {
        return mydepart;
    }

    public void setMydepart(String mydepart) {
        this.mydepart = mydepart;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return this.getId()+"-"+this.getName()+"-"+this.getMydepart()+"-"+this.getSex();
    }
}
