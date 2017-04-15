package discoverita.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import discoverita.example.user.User;
import discoverita.example.web.UserNotFoundException;

@Component
public class UserRepositoryMock implements UserRepositoryInterface {

	private final List<User> usersList = createUserList();

	public List<User> allUsers() {
		return usersList;
	}

	public User findUserByUseName(String userName) {
		User tempUser = new User ("", "", userName, "");
		int index = usersList.indexOf(tempUser);
		if (index < 0) {
			return null;
		}
		return usersList.get(usersList.indexOf(tempUser));
	}

	public void addUser(User user) {
		usersList.add(user);
	}

	private List<User> createUserList () {
		List<User> usersList = new ArrayList<User>();
		usersList.add(new User("Ivan", "Kirov", "ikirov", "ikirovpass"));
		usersList.add(new User("Gergana", "Simova", "gsimova", "aaa"));
		usersList.add(new User("Georgi", "Dimitrov", "gd", "fff"));
		usersList.add(new User("ggg", "ddd", "bbb", "ppp"));
		return usersList;
	}

}
