package hibernatemvc.dao;

import java.util.List;

import hibernatemvc.model.Employee;

public interface EmployeeDao {
	public String saveEmployee(Employee empl);
	public String updateEmployee(Employee empl);
	public List<Employee> showAllEmployees();
	public List<Employee> showEmployeesHighSal();
	public List<Employee> showEmployeesLowSal();
	List<Employee> showEmployeesHighSalCriteria();
	List<Employee> showEmployeesLowSalCriteria();
}
