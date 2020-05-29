package hibernatemvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hibernatemvc.model.Employee;
import hibernatemvc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	
	@RequestMapping(value="/registerEmployee", method = RequestMethod.POST)
	@ResponseBody
	public String registerEmp(@RequestBody Employee emp)
	{
		return empService.registerEmployee(emp);
		
	}
	
	@RequestMapping(value="/updateEmployee/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String updateEmp(@PathVariable("id") int id, @RequestBody Employee emp)
	{
		return empService.updateEmployee(emp,id);
		
	}

	@RequestMapping(value="/", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> listEmp()
	{
		return empService.listOfEmployees();
		
	}

	@RequestMapping(value="/highSalEmp", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> listEmpgtSal()
	{
		return empService.listOfEmployeesWithHighSal();
		
	}
	
	@RequestMapping(value="/lowSalEmp", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> listEmpltSal()
	{
		return empService.listOfEmployeesWithLowSal();
		
	}
	
	@RequestMapping(value="/highSalCriteria", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> listEmpgtSalCriteria()
	{
		return empService.listOfEmployeesWithHighSalCriteria();
		
	}
	
	@RequestMapping(value="/lowSalCriteria", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> listEmpltSalCriteria()
	{
		return empService.listOfEmployeesWithLowSalCriteria();
		
	}

}
