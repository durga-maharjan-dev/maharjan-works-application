package maharjanworks.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import maharjanworks.model.Employee;
import maharjanworks.rowmapper.EmployeeRowMapper;

@Repository
public class EmployeeJdbcDaoImpl implements EmployeeJdbcDao {
	
	private static final String INSERT_EMPLOYEE_SQL= "INSERT INTO employee_tbl(employee_id,first_name,last_name,email,password,profile_image) VALUES(?,?,?,?,?,?)";
	private static final String UPDATE_EMPLOYEE_SQL = "UPDATE employee_tbl SET first_name=?,last_name=?,email=?,password=?,profile_image=? where employee_id=?";
	private static final String GET_EMPLOYEE_BY_ID_SQL ="SELECT * FROM employee_tbl WHERE employee_id=?";
	private static final String DELETE_EMPLOYEE_BY_ID_SQL = "DELETE FROM employee_tbl WHERE employee_id=?";
	private static final String GET_ALL_EMPLOYEE_SQL = "SELECT * FROM employee_tbl";
	
	
	private static final String AUTHENTICATE_EMPLOYEE_SQL = "SELECT * FROM employee_tbl WHERE email=? and password=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Employee createEmployeee(Employee employee) {
		this.jdbcTemplate.update(INSERT_EMPLOYEE_SQL,employee.getEmployeeId(),employee.getFirstName(),employee.getLastName(), employee.getEmail(),employee.getPassword(),employee.getProfileImage());
		return employee;
	}

	@Override
	public Employee udpateEmployee(Employee employee) {
		this.jdbcTemplate.update(UPDATE_EMPLOYEE_SQL,employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getPassword(),employee.getProfileImage(),employee.getEmployeeId());
		return employee;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		return this.jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID_SQL,new EmployeeRowMapper(), employeeId);
	}
	
	
	@Override
	public List<Employee> getEmployees() {
		return this.jdbcTemplate.query(GET_ALL_EMPLOYEE_SQL,new EmployeeRowMapper());
		
	}

	public int getNewPrimaryKey() {
		String sql = "SELECT * FROM employee_tbl ORDER BY employee_id DESC LIMIT 1";
		Employee employee = this.jdbcTemplate.queryForObject(sql, new EmployeeRowMapper());
		int newPrimaryKey = employee.getEmployeeId()+1;
		return newPrimaryKey;
	}
	
//
//	@Override
//	public void deleteEmployee(int id) {
//		// TODO Auto-generated method stub
//		
//	}


	@Override
	public Employee authEmployee(String email, String password) {
		return this.jdbcTemplate.queryForObject(AUTHENTICATE_EMPLOYEE_SQL,new EmployeeRowMapper(), email,password);

	}



}
