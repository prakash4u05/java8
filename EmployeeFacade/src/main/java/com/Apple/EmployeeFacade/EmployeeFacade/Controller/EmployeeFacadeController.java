package com.Apple.EmployeeFacade.EmployeeFacade.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.Apple.EmployeeFacade.EmployeeFacade.Model.Employee;
import com.Apple.EmployeeFacade.EmployeeFacade.Service.EmployeeFacadeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/EmpFacade")
@Controller
public class EmployeeFacadeController {
	
	@Autowired
	EmployeeFacadeService employeeFacadeService;

	
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
	@RequestMapping("/Update")
	public ModelAndView UpdatePage()
	{
		return new ModelAndView("Update");
	}
	@ResponseBody
	@RequestMapping(value="searchEmployee/Search",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployeeBynameordept(@QueryParam("dept") String dept,@QueryParam("name") String name) throws IOException
	{
		
		List<Employee> returnVal=employeeFacadeService.Getemployeebynameanddept(dept, name);
		return returnVal;
	}
	
	@ResponseBody
	@RequestMapping(value="addEmployees",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void createEmploye(@RequestBody Employee employee)
	{
		employeeFacadeService.createEmployee(employee);
	}
	
	
	@ResponseBody
	@RequestMapping(value="updateEmployees",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void UpadteEmploye(@RequestBody Employee employee)
	{
		System.out.println("in put");
		employeeFacadeService.updateEmployee(employee);
	}
	@ResponseBody
	@RequestMapping(value="/getEmployee/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable("id") String id) throws IOException
	{
		System.out.println("inside get"+id);
		Employee returnVal=employeeFacadeService.Getemployee(id);
		//ResteasyClient client = new ResteasyClientBuilder().build();
		//ResteasyWebTarget target = client.target("http://localhost:8888/SpringMongoREST/Employees/"+id);
		  //ClientRequest - Hits our REST Service
		//ResteasyProviderFactory instance=ResteasyProviderFactory.getInstance();
		// RegisterBuiltin.register(instance);
		 //instance.registerProvider(ResteasyJackson2Provider.class);
       // ClientRequest request = new ClientRequest("http://localhost:8888/SpringMongoREST/Employees/"+id);
		//Response response = target.request().get();	
		//System.out.println("entity"+response.readEntity(Employee.class));
        //Setting the accepted response format
      //  request.accept("application/json");
         
        //Obtaining the client response
      //  try {
			//ClientResponse<Employee> response = request.get(Employee.class);
			
			//System.out.println("entity"+response.getEntity());
			//return response.getEntity();
		//} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
		/*RestTemplate restTemplate = new RestTemplate();
		List<Map<String, Object>> mList=new ArrayList<>();
		//Movies[] movieObj=new Movies[4];
       // movieObj =restTemplate.getForObject("http://localhost:8080/Movies/Matrix", Movies.class);
		System.out.println("id" + id);
		Employee response = restTemplate.getForObject("http://localhost:8888/SpringMongoREST/Employees/"+id,Employee.class);*/
		
        //System.out.println("of"+returnVal.getAge());//+movieObj.getMovieTitle());
       /*ObjectMapper mapper = new ObjectMapper();
        
        try{
        JsonNode root = mapper.readTree(response.getBody());
       JsonNode name = root.path("entity");//.path("dateIssued");
       for (JsonNode jsonNode : name) {
		
    	  // mList.add(new Movies(jsonNode.get("movieTitle"),jsonNode.get("moviePrice")));
    	   Map<String, Object> result = mapper.convertValue(jsonNode, Map.class);
    	   mList.add(result);
     
        System.out.println("Me"+jsonNode.get("movieTitle")+mList);
        }	}
       catch(JsonProcessingException j){}*/
		
		return returnVal;
	}
	@RequestMapping("/getemp")
	public String search(Model model) {
		
		//ResteasyWebTarget target = employeeFacadeService.GetClientProxy();
		return "index";
	}
	
	
}
