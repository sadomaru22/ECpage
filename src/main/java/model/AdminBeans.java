package model;

import java.io.Serializable;

public class AdminBeans implements Serializable {
    private static final long serialVersionUID = 1L;

    private String loginId;
    private String password;
    
    public AdminBeans() {}
    
    public AdminBeans(String loginId, String password) {
    	this.loginId = loginId;
    	this.password = password;
    }
    
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
