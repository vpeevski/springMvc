package discoverita.example.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = GET)
	public String home(ModelMap model) {
		System.out.println("########################  HomeController executed ###################");
		return "home";
	}
}
