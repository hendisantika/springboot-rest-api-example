package com.hendisantika.hendisantikaauth.controller;

import com.hendisantika.hendisantikaauth.model.User;
import com.hendisantika.hendisantikaauth.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-25
 * Time: 06:41
 */

@Slf4j
@Controller
public class RegisterController {
    private final RegistrationService registrationService;

    public RegisterController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    // Return registration form template
    @GetMapping("/register")
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");

        return modelAndView;
    }

    // Process form input data
    @PostMapping("/register")
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user,
                                                BindingResult bindingResult, HttpServletRequest request) {
        log.debug("User registration - POST");

        if (registrationService.isUserRegistered(user)) {
            log.warn("This user already exists: {}", user);

            modelAndView.addObject("alreadyRegisteredMessage",
                    "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else { // new user so we create user and send confirmation e-mail
            registrationService.registerUser(user);

            modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }


}
