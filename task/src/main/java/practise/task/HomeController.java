package practise.task;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import demo.project.tables.dao.VendorService;
import demo.project.tables.model.Login;
import demo.project.tables.model.Vendor;

@Controller
public class HomeController 
{
	@Autowired
	private Vendor vendor;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping(value= {"index"})
	public ModelAndView indexPage()
	{
		ModelAndView modelAndView=new ModelAndView("index");
	    return modelAndView;
	}
	
	@RequestMapping("/contact")
	public String  contactPage(Model model,HttpSession session)
	{
		session.setAttribute("name","Sudheer");
		model.addAttribute("date", new Date());
		return "contact";
	}
	@RequestMapping("/home")
	public  ModelAndView getDate()
	{
		ModelAndView modelAndView=new ModelAndView("home");
		modelAndView.addObject("date", new Date());
		return modelAndView;
	}

	
	@GetMapping(value= {"/","/signup"})
	public String signup(Model model)
	{
		model.addAttribute("vendor", new Vendor());
		return "signup";
	}
	@PostMapping("/register")
	public String addVendor(@ModelAttribute("vendor")Vendor vendor) 
	{
		if(vendorService.addVendor(vendor)) 
		{
			return "redirect:login";
			
		}
		else 
		{
			return "signup";
		}
	}
	@GetMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("login", new Login());
		return "login";
	}

	@PostMapping
	public String getVendor(@ModelAttribute("login") Login login)
		{
		if((vendorService.login(login.getEmail(),login.getPassword())!=null))
		{
			return "redirect:profile";
		}
		else
		{
			return "login";
		}
		}
	@GetMapping("/profile")
	public String profile()
	{
	return "profile";
	}
}
