package discoverita.example.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import discoverita.example.repository.UserRepositoryInterface;
import discoverita.example.user.User;

@Controller
public class UsersController {

	private UserRepositoryInterface userRepo;

	@Autowired
	public UsersController(UserRepositoryInterface userRepo) {
		this.userRepo = userRepo;
	}

	@RequestMapping(value = "/users", method = GET)
	public String usersList(ModelMap model) {
		model.addAttribute("usersList", userRepo.allUsers());
		return "users";
	}

	@RequestMapping(value = "/users/{userName}", method = GET)
	public String userProfile(@PathVariable String userName, ModelMap model) {
		User user = userRepo.findUserByUseName(userName);
		if (user == null) {
			throw new UserNotFoundException("User with username : " + userName + " not found ");
		}
		model.addAttribute("user", user);
		return "user";
	}

	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException() {
		return "error/userNotFound";
	}

}
