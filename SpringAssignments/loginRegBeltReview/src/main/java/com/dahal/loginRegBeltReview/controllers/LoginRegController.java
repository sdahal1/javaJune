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
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/menu/new")
    public String newMenuItem(@ModelAttribute("menu")Menu menu) {
    	return "newMenu.jsp";
    }
    
    @PostMapping("/menu/create")
    public String createMenuItem(@Valid @ModelAttribute("menu") Menu menu, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "newMenu.jsp";
    	}else {
    		//get the logged in user using session so that we can assign the logged in user as the uploader of the menu item
    		Long idOfLoggedinUser = (Long)session.getAttribute("user_id");
    		User loggedInUserObj = this.userServ.findOneUser(idOfLoggedinUser);
    		
    		//assign the menu's uploader to be the logged in user object
    		menu.setUploader(loggedInUserObj);
    		this.userServ.createMenuItem(menu);
    		return "redirect:/home";
    	}
    }
    
    @GetMapping("/menu/{id}/info")
    public String showMenuItem(@PathVariable("id") Long id, Model model) {
    	
    	//retrieve a menu object using this id variable
    	Menu menuObj = this.userServ.findOneMenuItem(id);
    	
    	//pass the menuObj variable to the templates 
    	model.addAttribute("menuObj", menuObj);
    	return "oneItem.jsp";
    }
    
    @GetMapping("/menu/{id}/edit")
    public String editMenuItem(@PathVariable("id")Long id, Model model) {
    	
    	//retrieve a menu object using this id variable
    	Menu menuObj = this.userServ.findOneMenuItem(id);
    	//pass this menuObj to the edit page so the form can prepopulate with this menu objects information
    	model.addAttribute("menuObj", menuObj);
    	
    	return "edit.jsp";
    	
    }
    
    @PostMapping("/menu/{id}/update")
    public String updateMenuItem(@PathVariable("id")Long id, @Valid @ModelAttribute("menuObj") Menu menu, BindingResult result ) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	}else {
    		//get the orignial menu object from the database using the id from the PathVariable
    		Menu oGMenuObj = this.userServ.findOneMenuItem(id);
//    		System.out.println("*********");
//    		System.out.println("Original menu objects uploader is this: " + oGMenuObj.getUploader());
//    		System.out.println(menu.getUploader());
//    		System.out.println(menu.getDescription());
//    		System.out.println("*********");
    		
    		//set the menu object that came from the form's uploader to be the original uploader from the original meenu object from the db
    		menu.setUploader(oGMenuObj.getUploader());
    		this.userServ.updateOneMenuItem(menu);
    		
    		return "redirect:/home";
    	}
    }
    
    
    @GetMapping("/menu/{id}/delete")
    public String deleteMenuItem(@PathVariable("id")Long id) {
    	this.userServ.deleteOneMenuItem(id);
    	return "redirect:/home";
    }
    
    

}
