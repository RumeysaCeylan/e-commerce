package Demo.business.abstracts;

import Demo.entities.concretes.User;

public interface UserService {
	void add(User user);
	void enter(User user,String email,String password);
	void enterWGoogle(String email);
}
