package optional;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		String s = "ok";
		String shit = Optional.ofNullable(s).orElse("hello");
		System.out.println(shit);

		String userName = Optional.ofNullable(s).orElseGet(() -> new User("12", "程程").getUserName());
		System.out.println(userName);
		Optional.ofNullable(s).orElseThrow(()->new RuntimeException("不能为空"));
	}
}

class User{
	private String userNo;
	private String userName;


	public User(String userNo,String userName) {
		this.userNo = userNo;
		this.userName = userName;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}