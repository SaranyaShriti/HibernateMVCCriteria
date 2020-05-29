package hibernatemvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hibernatemvc.dao.EmployeeDao;
import hibernatemvc.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public String saveEmployee(Employee empl) {
		Session session = sessionFactory.getCurrentSession();
		session.save(empl);
		return "New Employee added Successfully!";
	}

	@Override
	public String updateEmployee(Employee empl) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(empl);
		return "Employee details updated Successfully!";
	}

	@Override
	public List<Employee> showAllEmployees() {
		Session session = sessionFactory.getCurrentSession();
		Query<Employee> query = session.createQuery("from Employee order by salary asc");
		return query.list();
	}

	@Override
	public List<Employee> showEmployeesHighSal() {
		Session session = sessionFactory.getCurrentSession();
		Query<Employee> query = session.createQuery("from Employee where salary > 50000");
		
		return query.list();
	}

	@Override
	public List<Employee> showEmployeesLowSal() {
		Session session = sessionFactory.getCurrentSession();
		Query<Employee> query = session.createQuery("from Employee where salary < 20000");
		return query.list();
	}
	
	@Override
	public List<Employee> showEmployeesHighSalCriteria() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary", 50000.0));
				
		return criteria.list();
	}
	
	@Override
	public List<Employee> showEmployeesLowSalCriteria() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.lt("salary", 20000.0));
				
		return criteria.list();
	}

}
