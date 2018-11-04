package com.Apple.EmployeeFacade.EmployeeFacade.Controller;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Apple.EmployeeFacade.EmployeeFacade.Model.Employee;

@RequestMapping("/EmpFacade")
@Controller
public class EmployeeFacadeController {

	@RequestMapping("/index")
	public String indexPage(Model model) {
		//System.out.println("Inside index");
		model.addAttribute("message", "Employee UI");	
		return "start";
	}
	
	@RequestMapping("/AddDetails")
	public ModelAndView addPage()
	{
		return new ModelAndView("addDetails");
	}
	@RequestMapping("/empSearch")
	public ModelAndView searchPage()
	{
		return new ModelAndView("empSearch");
	}
	
	@RequestMapping(value="/getEmployee/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable("id") String id)
	{
		System.out.println("inside get"+id);
		return new Employee("E01","p","l",21,"cs","10","male");
	}
	
	
	
}
