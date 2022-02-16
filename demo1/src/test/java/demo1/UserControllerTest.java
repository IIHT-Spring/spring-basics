package demo1;

import org.junit.Test;

import demo1.controller.UserController;

public class UserControllerTest {

	@Test
	public void testCreateUser() {
		UserController controller = new UserController();
		controller.setUserService(new MockUserService());
		controller.createUser(); //ABC234
	}

}
