package serializable;

import java.io.*;

public class SerializableTest{

    public static void main(String[] args) throws Exception {
        //1.将对象序列化到文件中
        User user = new User();
        user.setAge("10");
        user.setSex("1");
        user.setUserName("abc");
        user.setUserNo("10000000");
        File file = new File("E:\\IdeaProjects\\javapracticeFile\\serializabletest\\serializabletest.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(user);

        //2.将文件中的字节数据反序列化到对象
        File inFile = new File("E:\\IdeaProjects\\javapracticeFile\\serializabletest\\serializabletest.txt");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(inFile));
        User inUser = (User)in.readObject();
        System.out.println(inUser.toString());
    }

}

class User implements Serializable{

    private final static long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userNo='" + userNo + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
