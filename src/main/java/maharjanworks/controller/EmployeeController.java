package maharjanworks.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import maharjanworks.dto.EmployeeDTO;
import maharjanworks.dto.LoginDTO;
import maharjanworks.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping({"/index","/"})
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/signupEmployee")
	public String getSignup(){
		return "employee-signup";
	}
	
	@PostMapping("/signupEmployee")
	public String postSignup(
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String email,
			@RequestParam String password,
			MultipartFile profileImage,
			Model model) throws IOException {
		
		byte[] imageContent = profileImage.getBytes();
		EmployeeDTO dto= new EmployeeDTO(firstName,lastName,email,password,imageContent);
		this.employeeService.insertEmployee(dto);
		model.addAttribute("message", "Signup Done Successfully!");
		return "employee-signup";
	}
	

	@GetMapping("/updateEmployee")
	public String getUpdateEmployee() {
		return "employee-update";
	}
	
	
	@PostMapping("/updateEmployee")
	public String postUpdateEmployee(
			@RequestParam int employeeId,
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String email,
			@RequestParam String password,
			MultipartFile profileImage,
			Model model) throws IOException {
		byte[] imageContent = profileImage.getBytes();
		EmployeeDTO dto= new EmployeeDTO(employeeId,firstName,lastName,email,password,imageContent);
		this.employeeService.updateEmployee(dto);
		model.addAttribute("message", "Update Done Successfully!");
		return "employee-update";
	}
	

	@GetMapping("/findEmployeeById")
	public String getFindEmployeeById() {
		return "employee-by-id";
	}
	
	@PostMapping("/findEmployeeById")
	public String findEmployeeById(@RequestParam int employeeId, Model model) {
		System.out.println("controller: "+ employeeId);
		EmployeeDTO dto = this.employeeService.findEmployeeById(employeeId);
		if(dto!=null) {
			model.addAttribute("message","Found");
			model.addAttribute("dto", dto);
			byte[] imageContent = dto.getProfileImage();
			String profileImage = Base64.getEncoder().encodeToString(imageContent);
			model.addAttribute("profileImage",profileImage);
			return "employee-by-id";
		}else {
			model.addAttribute("message","Not Found.");
			return "employee-by-id";
		}
	}
	
	
	@GetMapping("/viewAll")
	public String viewAll(Model model) {
		List<EmployeeDTO> dtoList =this.employeeService.getAllEmployees();
		model.addAttribute("dtoList", dtoList);
		return"employee-all";
	}
	
	//getting login page
	@GetMapping("/loginEmployee")
	public String getLogin() {
		return "employee-login";
	}
	
	//posting or authenticating 
	@PostMapping("/loginEmployee")
	public String authenticateEmployee(@ModelAttribute LoginDTO dto, Model model) {
		
		EmployeeDTO employeeDTO = this.employeeService.authenticateEmployee(dto);
		
		if (employeeDTO != null) {
			String profileImage = Base64.getEncoder().encodeToString(employeeDTO.getProfileImage());
			model.addAttribute("dto", employeeDTO);
			model.addAttribute("profileImage", profileImage);
			return "employee-dashboard";
		}else {
			model.addAttribute("message", "Invalid email or password!");
			return "employee-login";
		}
	}
	
	
	

}
