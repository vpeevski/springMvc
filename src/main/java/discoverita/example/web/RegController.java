package discoverita.example.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	public String registerForm(Locale locale, Model model) {
		model.addAttribute(new User());
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = POST)
	public String register(@RequestPart("profilePicture") MultipartFile profilePicture, @Valid User user, Errors errors, ModelMap model) {
		if (errors.hasErrors()) {
			return "registerForm";
		}
		String fileName = profilePicture.getOriginalFilename();
		try {
			profilePicture.transferTo(new File("/" + fileName));
		} catch (IOException ioe) {
			throw new FileUploadException("Profile picture upload failed : " + fileName);
		}
		userRepo.addUser(user);
		return "redirect:/users/" + user.getUserName();
	}
	
	@ExceptionHandler(FileUploadException.class)
	public ModelAndView  fileUploadException (FileUploadException fue) {
		ModelAndView model = new ModelAndView();
		model.addObject(new User());
		model.addObject("uploadFailedMessage", fue.getMessage());
		model.setViewName("registerForm");
		return model;
	}

}
