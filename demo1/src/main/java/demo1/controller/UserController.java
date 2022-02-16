package demo1.controller;

import demo1.service.IUserService;

public class UserController {// receive request

	IUserService userService ;//dependency, reference

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public Integer createUser() {
		//Logic
		return userService.saveUser();
		
	}
}
