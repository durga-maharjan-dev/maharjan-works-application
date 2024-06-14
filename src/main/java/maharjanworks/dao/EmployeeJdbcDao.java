package maharjanworks.dao;

import java.util.List;

import maharjanworks.model.Employee;

public interface EmployeeJdbcDao {
	
	Employee createEmployeee(Employee employee);
	Employee udpateEmployee(Employee employee);
	Employee getEmployee(int id);
//	void deleteEmployee(int id);
	List<Employee> getEmployees();
	int getNewPrimaryKey();

	Employee authEmployee(String email, String password);
	

}
