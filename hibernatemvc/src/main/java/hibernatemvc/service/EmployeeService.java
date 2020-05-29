package hibernatemvc.service;

import java.util.List;
import hibernatemvc.model.Employee;

public interface EmployeeService {

	public String registerEmployee(Employee emp);
	public String updateEmployee(Employee emp, int id);  
	public List<Employee> listOfEmployees();
	public List<Employee> listOfEmployeesWithHighSal();
	public List<Employee> listOfEmployeesWithHighSalCriteria();
	public List<Employee> listOfEmployeesWithLowSal();
	public List<Employee> listOfEmployeesWithLowSalCriteria();

	
}
