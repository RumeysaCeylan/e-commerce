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
			System.out.println("Bo� b�rakamazs�n�z");
			return false;
		}
		for(String mail_:mail) {
			if(user.getE_mail()==mail_) {
				System.out.println("Ayn� mail adresi kullan�lamaz");
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
			System.out.println("�sim en az 2 harften olu�mal�d�r Daha az olamaz");
		return false;
		
		}
		else if(user.getSurname().length()<2) {
			System.out.println("Soyisim en az 2 harften olu�mal�d�r Daha az olamaz");
			return false;
			
			}
		return true;
	}
	@Override
	public boolean passwordChecker(User user) {
		if(user.getPassword().length()<6) {
			System.out.println("�ifre en az 6 harften olu�mal�d�r!!!");
		return false;
		}
		password_.add(user.getPassword());
		return true;
	}
	@Override
	public boolean verifiedEmail(User user, String email, String password) {
		//for(String mail:mail) { //ayn� index olmasa bile iki �ifre ayn� olursa giri� yap�yor!!!
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
		System.out.println("Do�rulama linki tamamlanm��t�r");
		return true;
	}
	else {
	System.out.println("Do�rulama hatal� �yeli�iniz tamamlanmam��t�r ");
		return false;
	}
	}
}
