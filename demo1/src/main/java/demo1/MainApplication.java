package demo1;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import demo1.controller.UserController;

public class MainApplication {
	public static void main(String[] args) {
		XmlBeanFactory container = new XmlBeanFactory(new ClassPathResource("ApplicationContext.xml"));
		UserController controller = (UserController) container.getBean("userController");
		UserController controller1 = (UserController) container.getBean("userController");
		
		System.out.println(controller == controller1);
		System.out.println(controller.getUrl());
		System.out.println(controller.getUserService());
		
	}
}
//JSF