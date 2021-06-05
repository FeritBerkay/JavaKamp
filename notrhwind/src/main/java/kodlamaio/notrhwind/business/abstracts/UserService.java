package kodlamaio.notrhwind.business.abstracts;

import org.springframework.stereotype.Service;

import kodlamaio.notrhwind.core.Utilities.result.DataResult;
import kodlamaio.notrhwind.core.Utilities.result.Result;
import kodlamaio.notrhwind.core.entities.User;

@Service
public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);
}
