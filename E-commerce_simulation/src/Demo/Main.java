package Demo;

import Demo.business.abstracts.UserService;
import Demo.business.concretes.CheckManager;
import Demo.business.concretes.UserManager;
import Demo.core.GoogleManager;
import Demo.dataAccess.concretes.HibernateUserDao;
import Demo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao(),new CheckManager(),new GoogleManager());
			
			
		
		User user = new User("kkkk","Cdfsdsn","rumeydcc@gmail.com.tr","12345678");
		userService.add(user);   
		System.out.println("\n");
		User user2= new User("fvxvvdf","Cdfsdsn","rumeyd444cc@gmail.com.tr","111111");
		userService.add(user2);
		System.out.println("\n");
		userService.enter(user2, "rumeyd444cc@gmail.com.tr", "111111");
		System.out.println("\n");
		userService.enterWGoogle("sdass@gmail.com");
	}

}
