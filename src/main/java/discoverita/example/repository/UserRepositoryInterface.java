package discoverita.example.repository;

import java.util.List;

import discoverita.example.user.User;

public interface UserRepositoryInterface {

	List<User> allUsers();

	User findUserByUseName(String userName);

	void addUser(User user);

}
