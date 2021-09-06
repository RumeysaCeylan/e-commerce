package Demo.business.concretes;


import java.util.regex.Pattern;

import Demo.business.abstracts.EmailService;
import Demo.entities.concretes.User;

public class EmailManager implements EmailService{
	
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	@Override
	public boolean emailChecker(User user) {
		if(user.getE_mail().isEmpty()) {
			System.out.println("Boþ býrakamazsýnýz");
			return false;
		}
		System.out.println("E posta : "+user.getE_mail());
		Pattern pattern =Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);
		return pattern.matcher(user.getE_mail()).find();
	}

}
