package demo1;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserControllerTest {

	@Test
	public void testCreateUser() {
		UserController controller = new UserController();
		controller.setUserService(new MockUserService());
		controller.createUser();
	}

}
