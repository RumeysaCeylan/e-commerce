package Demo.business.concretes;

import java.util.ArrayList;
import java.util.List;
import Demo.business.abstracts.EmailService;
import Demo.business.abstracts.UserService;
import Demo.dataAccess.abstracts.UserDao;
import Demo.entities.concretes.User;

public class UserManager implements UserService{
  private UserDao userDao;
  private EmailService emailService;
  List<String> mail =new ArrayList<String>();
  
	public UserManager(UserDao userDao,EmailService emailService) {
	super();
	this.userDao = userDao;
	this.emailService=emailService;
}

	@Override
	public void add(User user) {
		if(user.getPassword().length()<6) {
			System.out.println("parola en az 6 karakterli olmalýdýr");
			return;
		}
		else if(user.getName().length()<2||user.getSurname().length()<2) {
			System.out.println("Ýsim ve soy isim en az 2 karakterli olmalýdýr");
			return;
		}
		else if(!emailService.emailChecker(user)) {
			System.out.println("Geçersiz email adresi");
			return;
		}
		
		this.userDao.add(user);
		
	}

	@Override
	public void enter(User user) {
		// TODO Auto-generated method stub
		
	}

	

}
