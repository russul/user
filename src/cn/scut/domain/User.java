package cn.scut.domain;

public class User {
	private String username;
	private String password;
	private String vertifycode;
	public String getVertifycode() {
		return vertifycode;
	}
	public void setVertifycode(String vertifycode) {
		this.vertifycode = vertifycode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", vertifycode=" + vertifycode + "]";
	}

}
