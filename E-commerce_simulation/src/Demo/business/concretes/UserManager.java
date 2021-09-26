package Demo.business.concretes;
import Demo.business.abstracts.CheckService;
import Demo.business.abstracts.UserService;
import Demo.core.GoogleService;
import Demo.dataAccess.abstracts.UserDao;
import Demo.entities.concretes.User;

public class UserManager implements UserService{
  private UserDao userDao;
  private CheckService checkService;
  private GoogleService googleService;
  
	public UserManager(UserDao userDao,CheckService checkService,GoogleService googleService) {
	super();
	this.userDao = userDao;
	this.checkService=checkService;
	this.googleService=googleService;
}

	@Override
	public void add(User user) {

		if(!checkService.emailChecker(user)) {
			System.out.println("hatalý mail adresi");
		}
		else if(checkService.fullNameChecker(user)&&checkService.passwordChecker(user)) {
				System.out.println("Doðrulama linki gönderilmiþtir "+user.getE_mail());
				this.userDao.add(user);
			
			
		}
	 	
	
		
	}

	@Override
	public void enter(User user,String email,String password) {
	if(checkService.verifiedEmail(user, email, password)) {
		this.userDao.enter(user, email, password);
	}
	else {
		System.out.println("Hatalý giriþ !!!");
		return;
	}
			
		
		
	}

	@Override
	public void enterWGoogle(String email) {
		if(checkService.checkGoogle(email)) {
		this.googleService.LoginwGoogle(email);
		}
		else {
			System.out.println("Lütfen geçerli bir mail adresi girin hatalý mail adresi :"+email);
		}
	}
	

	

}
