package kodlamaio.notrhwind.core.dateAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.notrhwind.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEMail(String Email);
}
