package Demo.business.abstracts;

import Demo.entities.concretes.User;

public interface EmailService {
	boolean emailChecker(User user);
}
