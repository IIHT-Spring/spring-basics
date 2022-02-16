package demo1.controller;

import demo1.service.IUserService;

public class UserController {// receive request
	IUserService userService ;//dependency, reference
	String url;
	public Integer createUser() {
		//Logic
		return userService.saveUser();
		
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

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
