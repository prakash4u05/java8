package com.Apple.employeeREST.EmployeeRESTproj.controller;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Apple.employeeREST.EmployeeRESTproj.Model.Employee;
import com.Apple.employeeREST.EmployeeRESTproj.Service.EmployeeService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private EmployeeService  employeeService;
	

	
	@Before
	public void setUp() throws Exception {
		
		Employee mockemp = new Employee("E02", "Spring", "kumar",21,"CS","2100","male");
		
		Mockito.when(
				employeeService.readEmployee(Mockito.anyString()
					)).thenReturn(mockemp);

		
		
	}

	@Test
	public void readEmployeetest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/SpringMongoREST/Employees/E02").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{'empid':'E02','fname':'Spring','lname':'kumar','age':21,'department':'CS','salary':'2100','gender':'male'}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), true);
	}

}
