package demo1;

public class UserController {// receive request

	IUserService userService ;//dependency, reference

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void createUser() {
		userService.saveUser();
	}
}