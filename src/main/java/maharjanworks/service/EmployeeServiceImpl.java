package maharjanworks.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import maharjanworks.dao.EmployeeJdbcDao;
import maharjanworks.dto.EmployeeDTO;
import maharjanworks.dto.LoginDTO;
import maharjanworks.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService  {
	
	@Autowired
	private EmployeeJdbcDao employeeJdbcDao;

	@Override
	public EmployeeDTO insertEmployee(EmployeeDTO dto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(dto, employee);
		employee.setEmployeeId(this.employeeJdbcDao.getNewPrimaryKey());
		this.employeeJdbcDao.createEmployeee(employee);
		return dto;
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO dto) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(dto, emp);
		this.employeeJdbcDao.udpateEmployee(emp);
		return dto;
	}
	

	@Override
	public EmployeeDTO findEmployeeById(int employeeId) {
		System.out.println("Service: "+ employeeId);
		Employee employee = this.employeeJdbcDao.getEmployee(employeeId);
		
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(employee, dto);
		return dto;
	}
	

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = this.employeeJdbcDao.getEmployees();
		
		List<EmployeeDTO> dtos = new ArrayList<EmployeeDTO>();
		for(Employee employee: employees) {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(employee, dto);
			dtos.add(dto);
		}
		
		return dtos;
	}








	@Override
	public EmployeeDTO authenticateEmployee(LoginDTO dto) {
		Employee employee = this.employeeJdbcDao.authEmployee(dto.getEmail(),dto.getPassword());
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employee, employeeDTO);
		
		return employeeDTO;
	}









}
