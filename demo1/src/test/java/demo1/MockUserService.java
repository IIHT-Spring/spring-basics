package demo1;

import demo1.service.IUserService;

public class MockUserService implements IUserService{//for testing
	public  Integer saveUser() {
		System.out.println("testing");
		//logic
		return 1;
	}
}
