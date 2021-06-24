package com.dahal.loginRegBeltReview.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dahal.loginRegBeltReview.models.LoginUser;
import com.dahal.loginRegBeltReview.models.Menu;
import com.dahal.loginRegBeltReview.models.User;
import com.dahal.loginRegBeltReview.services.UserService;

@Controller
public class LoginRegController {
	
	@Autowired
    private UserService userServ;

    
    @GetMapping("/")
    public String index(Model model, @ModelAttribute("newUser") User user, @ModelAttribute("newLogin") LoginUser loginUser ) {
//        model.addAttribute("newUser", new User());
//        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    	
        this.userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        //if the form was filled out successfully, then create a cookie to keep track of this users id in session
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = this.userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        
        //if there are no errors, and the form info is all valid, then we use sesssion to store the users information to log them in
        session.setAttribute("user_id", user.getId());
        return "redirect:/home";
    }
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
    	System.out.println("**************");
    	System.out.println(session.getAttribute("user_id"));
    	System.out.println("**************");
    	if(session.getAttribute("user_id") == null) {
    		
    		return "redirect:/";
    	}
    	//use session to retrieve the id of the logged in user or newly registered user 
    	Long loggedInId = (Long)session.getAttribute("user_id");
    	//use the retrieved id to find a user from the database who has that id, so we can send that user's information to the template
    	User loggedInUserObj = this.userServ.findOneUser(loggedInId);
    	model.addAttribute("loggedInUser", loggedInUserObj);
    	
    	
    	//passing all the menu items to the template. first we need to get the menu items by using the service
    	List<Menu> allMenuItems = this.userServ.findAllMenuItems();
    	model.addAttribute("allMenuItems", allMenuItems);
    	
    	return "dashboard.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	
    	session.removeAttribute("user_id");
    	return "redirect:/";
    }
    

}
