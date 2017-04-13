package discoverita.example.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import discoverita.example.repository.UserRepositoryInterface;
import discoverita.example.user.User;

@Controller
public class RegController {

	private UserRepositoryInterface userRepo;

	@Autowired
	public RegController(UserRepositoryInterface userRepo) {
		this.userRepo = userRepo;
	}

	@RequestMapping(value = "/register", method = GET)
	public String registerForm() {
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = POST)
	public String register(@Valid User user, Errors errors, ModelMap model) {
		if (errors.hasErrors()) {
			if (errors.getFieldError("firstName") != null) {
				model.addAttribute("firstNameError", errors.getFieldError("firstName").getDefaultMessage());
			}
			return "registerForm";
		}
		userRepo.addUser(user);
		return "redirect:/users/" + user.getUserName();
	}

}
