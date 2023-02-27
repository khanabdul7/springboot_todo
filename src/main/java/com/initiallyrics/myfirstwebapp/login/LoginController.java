package com.initiallyrics.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // name attribute will be added to session, NOTE: this annotation needs to add
							// to all controllers in which we want to use the specified attribute i.e:name
public class LoginController {

	private AuthenticationService authenticateService; // why Autowired is not added?, bcos we used constructor based DI
														// and @autowired isn't required on constructor.

	public LoginController(AuthenticationService authenticateService) {
		super();
		this.authenticateService = authenticateService;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET) // Handling only GET
	public String login() {
		return "loginJSP";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST) // Handling only POST
	public String welcome(@RequestParam String name, @RequestParam String password, ModelMap model) {

		if (authenticateService.authenticate(name, password)) {

			model.put("name", name); //adding value of name to attribute "name"
			return "welcomeJSP";
		}

		model.put("err", "Please use correct credentials!");
		return "loginJSP";

	}
}
