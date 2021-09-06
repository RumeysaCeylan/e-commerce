package Demo;

import Demo.business.abstracts.UserService;
import Demo.business.concretes.EmailManager;
import Demo.business.concretes.UserManager;
import Demo.dataAccess.concretes.HibernateUserDao;
import Demo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao(),new EmailManager());
			
			
		
		User user = new User("R�meysa","Ceylan","rumeydcc@gmail.com.tr","1234567");
		userService.add(user);
		
	}

}
