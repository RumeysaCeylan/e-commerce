package Demo.core;

import Demo.google.googleLogger;

public class GoogleManager implements GoogleService{

	@Override
	public void LoginwGoogle(String email) {
		googleLogger logger = new googleLogger();
		logger.login(email);
	}


}
