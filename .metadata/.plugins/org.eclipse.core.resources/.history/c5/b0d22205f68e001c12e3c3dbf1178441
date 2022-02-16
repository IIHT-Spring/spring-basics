package demo1;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainApplication {
	public static void main(String[] args) {
		XmlBeanFactory container = new XmlBeanFactory(new ClassPathResource("ApplicationContext.xml"));
		UserController controller = (UserController) container.getBean("userController");
		
		System.out.println(controller);
		System.out.println(controller.getUserService());
		
	}
}
