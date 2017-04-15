package discoverita.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import discoverita.example.user.User;
import discoverita.example.web.UserNotFoundException;

@Repository
@Primary
public class JdbcDiscoveritaRepository implements UserRepositoryInterface {

	private static final String SQL_INSERT_USER = "insert into User (FirstName, LastName, UserName, Password) values (?, ?, ?, ?)";

	private static final String SQL_SELECT_USER = "select *  from user where username = ?";
	
	private static final String SQL_SELECT_USER_ALL = "select *  from user";

	private JdbcOperations jdbcOperations;

	@Inject
	public JdbcDiscoveritaRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	public List<User> allUsers() {
		return jdbcOperations.query(SQL_SELECT_USER_ALL, new UserRowMapper());
	}

	public User findUserByUseName(String userName) {
		User user = null;
		try {
			user = jdbcOperations.queryForObject(SQL_SELECT_USER, new UserRowMapper(), userName);
		} catch (EmptyResultDataAccessException ersae) {
			UserNotFoundException unfe = new UserNotFoundException("User with username : " + userName + " not found ");
			throw unfe;
		}
		
		return user;
	}

	private static final class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getString("firstname"), rs.getString("lastName"), rs.getString("username"), rs.getString("password"));
		}
	}

	public void addUser(User user) {
		jdbcOperations.update(SQL_INSERT_USER, user.getFirstName(), user.getLastName(), user.getUserName(),
				user.getPassword());

	}

}
