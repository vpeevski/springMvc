package discoverita.example.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		if (!model.containsAttribute("user")) { //if present use it otherwise get it from db by username
			User user = userRepo.findUserByUseName(userName);
			model.addAttribute("user", user);
		}
		return "user";
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView handleUserNotFoundException(UserNotFoundException unfe) {
		ModelAndView model = new ModelAndView();
		model.addObject(new User());
		model.addObject("userNotFoundMessage", unfe.getMessage());
		model.setViewName("user");
		return model;
	}

}
