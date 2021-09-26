package Demo.business.abstracts;

import Demo.entities.concretes.User;

public interface CheckService {
	boolean emailChecker(User user);
	boolean fullNameChecker(User user);
	boolean passwordChecker(User user);
	boolean verifiedEmail(User user,String email,String password);
	boolean checkGoogle(String mail);
}
