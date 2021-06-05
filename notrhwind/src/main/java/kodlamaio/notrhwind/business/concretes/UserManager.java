package kodlamaio.notrhwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.notrhwind.business.abstracts.UserService;
import kodlamaio.notrhwind.core.Utilities.result.DataResult;
import kodlamaio.notrhwind.core.Utilities.result.Result;
import kodlamaio.notrhwind.core.Utilities.result.SuccessDataResult;
import kodlamaio.notrhwind.core.Utilities.result.SuccessResult;
import kodlamaio.notrhwind.core.dateAccess.UserDao;
import kodlamaio.notrhwind.core.entities.User;

public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEMail(email),"Kullanıcı bulundu");
	}

}
