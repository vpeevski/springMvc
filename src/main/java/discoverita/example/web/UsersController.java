package discoverita.example.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import discoverita.example.repository.UserRepositoryInterface;

@Controller
public class UsersController {
	
private UserRepositoryInterface userRepo;
	
	@Autowired
	public UsersController (UserRepositoryInterface userRepo) {
		this.userRepo = userRepo;
	}
	
	@RequestMapping(value = "/users", method = GET)
	public String usersList (ModelMap model) {
		model.addAttribute("usersList", userRepo.allUsers());
		return "users";
	}
	
	@RequestMapping(value = "/users/{userName}", method = GET)
	public String userProfile (@PathVariable String userName, ModelMap model) {
		model.addAttribute("user", userRepo.findUserByUseName(userName));
		return "user";
	}

}
