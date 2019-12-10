package serializable;

import java.io.Serializable;

public class SerializableTest{

    public static void main(String[] args) {

    }

}

class User implements Serializable{

    private static long serialVersionUID = 1L;

    private String userName;
    private String userNo;
    private String age;
    private String sex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
