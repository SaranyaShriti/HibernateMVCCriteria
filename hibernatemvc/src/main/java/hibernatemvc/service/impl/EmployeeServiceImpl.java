package hibernatemvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hibernatemvc.dao.EmployeeDao;
import hibernatemvc.model.Employee;
import hibernatemvc.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public String registerEmployee(Employee emp) {
		
		return employeeDao.saveEmployee(emp);
	}

	@Override
	public String updateEmployee(Employee emp, int id) {
		
		Employee employee = new Employee();
		employee.setEmployeeId(id);
		employee.setEname(emp.getEname());
		employee.setSalary(emp.getSalary());
		employee.setAge(emp.getAge());
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public List<Employee> listOfEmployees() {
		
		return employeeDao.showAllEmployees();
	}

	@Override
	public List<Employee> listOfEmployeesWithHighSal() {
		
		return employeeDao.showEmployeesHighSal();
	}

	@Override
	public List<Employee> listOfEmployeesWithLowSal() {
		
		return employeeDao.showEmployeesLowSal();
	}

	@Override
	public List<Employee> listOfEmployeesWithHighSalCriteria() {
		
		return employeeDao.showEmployeesHighSalCriteria();
	}

	@Override
	public List<Employee> listOfEmployeesWithLowSalCriteria() {
		
		return employeeDao.showEmployeesLowSalCriteria();
	}

}
