package Demo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import Demo.dataAccess.abstracts.UserDao;
import Demo.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	List <User> users = new ArrayList<User>();
	@Override
	public void add(User user) {
		System.out.println("Kay�t ba�ar�l� bir �ekilde tamamlanm��t�r "+user.getName()+" "+user.getSurname());
		users.add(user);
	}

	@Override
	public void update(User user) {
		users.remove(user);
		users.add(user);
		System.out.println("G�ncelleme ba�ar�l� bir �ekilde tamamlanm��t�r "+user.getName()+" "+user.getSurname());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Silme i�lemi ba�ar�l� bir �ekilde tamamlanm��t�r "+user.getName()+" "+user.getSurname());
		users.remove(user);
	}

	@Override
	public boolean checker(String email, String password) {
		for(User user : users) {
			if(user.getE_mail()==email&&user.getPassword()==password) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

	

}
