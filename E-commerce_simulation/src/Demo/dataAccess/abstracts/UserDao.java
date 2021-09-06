package Demo.dataAccess.abstracts;
import java.util.List;

import Demo.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	boolean checker(String email,String password);
	List <User> getAll();
}
