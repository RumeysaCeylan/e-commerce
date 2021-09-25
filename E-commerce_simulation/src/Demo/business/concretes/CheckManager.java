package Demo.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import Demo.business.abstracts.CheckService;
import Demo.entities.concretes.User;

public class CheckManager implements CheckService{
	List <String> mail = new ArrayList<String>();
	List <String> password_ = new ArrayList<String>();
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	@Override
	public boolean emailChecker(User user) {
		if(user.getE_mail().isEmpty()) {
			System.out.println("Boþ býrakamazsýnýz");
			return false;
		}
		for(String mail_:mail) {
			if(user.getE_mail()==mail_) {
				System.out.println("Ayný mail adresi kullanýlamaz");
				return false;
			}
		}
		Pattern pattern =Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);
		mail.add(user.getE_mail());
		return pattern.matcher(user.getE_mail()).find();   
	}
	@Override
	public boolean fullNameChecker(User user) {
		if(user.getName().length()<2) {
			System.out.println("Ýsim en az 2 harften oluþmalýdýr Daha az olamaz");
		return false;
		
		}
		else if(user.getSurname().length()<2) {
			System.out.println("Soyisim en az 2 harften oluþmalýdýr Daha az olamaz");
			return false;
			
			}
		return true;
	}
	@Override
	public boolean passwordChecker(User user) {
		if(user.getPassword().length()<6) {
			System.out.println("Þifre en az 6 harften oluþmalýdýr!!!");
		return false;
		}
		password_.add(user.getPassword());
		return true;
	}
	@Override
	public boolean verifiedEmail(User user, String email, String password) {
		//for(String mail:mail) { //ayný index olmasa bile iki þifre ayný olursa giriþ yapýyor!!!
		//	for(String password_:password_) {
			if(user.getE_mail()==email&&user.getPassword()==password) {
				return true;
			}
			
			
			//}
		//}
	return false;
		
	}
	@Override
	public boolean Link(User user) {
	if(emailChecker(user)&&fullNameChecker(user)&&passwordChecker(user)) {
		System.out.println("Doðrulama linki tamamlanmýþtýr");
		return true;
	}
	else {
	System.out.println("Doðrulama hatalý üyeliðiniz tamamlanmamýþtýr ");
		return false;
	}
	}
}
