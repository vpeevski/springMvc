package discoverita.example.repository;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import discoverita.example.user.User;

@Repository
@Primary
public class JdbcDiscoveritaRepository implements UserRepositoryInterface {
	
	private static final String SQL_INSERT_USER =
			"insert into User (FirstName, LastName, UserName, Password) values (?, ?, ?, ?)";

	private JdbcOperations jdbcOperations;

	@Inject
	public JdbcDiscoveritaRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	public List<User> allUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUserByUseName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(User user) {
		jdbcOperations.update(SQL_INSERT_USER,
				user.getFirstName(),
				user.getLastName(),
				user.getUserName(),
				user.getPassword()
				);

	}

}
