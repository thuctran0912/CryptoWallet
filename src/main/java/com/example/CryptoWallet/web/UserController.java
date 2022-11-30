package com.example.CryptoWallet.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.CryptoWallet.model.Signup_Form;
import com.example.CryptoWallet.model.User;
import com.example.CryptoWallet.model.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;

	// Create new User object
	@GetMapping("/signup")
	public String showRegistrationForm(Model model) {
		model.addAttribute("signupform", new Signup_Form());
		return "signup";
	}

	// Save new User into db
	@PostMapping("/signup_process")
	public String save(@Valid @ModelAttribute("signupform") Signup_Form signupForm, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check password match
				String pwd = signupForm.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);
				
				User newUser = new User();
				newUser.setPassword(hashPwd);
				newUser.setEmail(signupForm.getEmail());
				newUser.setUsername(signupForm.getUsername());
				newUser.setRole("USER");
				newUser.setFirstName(signupForm.getFirstName());
				newUser.setLastName(signupForm.getLastName());
				if (userRepo.findByUsername(signupForm.getUsername()) == null) {
					userRepo.save(newUser);
				}
				else {
					bindingResult.rejectValue("username", "err.username", "Username already exists");
					return "signup";
				}
			}
			else {
				bindingResult.rejectValue("passwordCheck", "err.passwordCheck", "Passwords do not match");
				return "signup";
			}
		}
		else {
			return "signup";
		}
		return "/signup_success";

	}

}
