package demo1.controller;

import demo1.service.IUserService;

public class UserController {// receive request
	IUserService userService;// dependency, reference
	String url;
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public Integer createUser() {
		// Logic <- testing this
		return userService.saveUser();//need to mock this dependency
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public IUserService getUserService() {
		return userService;
	}
}
