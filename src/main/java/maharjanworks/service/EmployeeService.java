package maharjanworks.service;

import java.util.List;

import maharjanworks.dto.EmployeeDTO;
import maharjanworks.dto.LoginDTO;

public interface EmployeeService {

	EmployeeDTO insertEmployee(EmployeeDTO dto);
	
	EmployeeDTO authenticateEmployee(LoginDTO dto);

	EmployeeDTO findEmployeeById(int employeeId);

	EmployeeDTO updateEmployee(EmployeeDTO dto);
	
	List<EmployeeDTO> getAllEmployees();

}
