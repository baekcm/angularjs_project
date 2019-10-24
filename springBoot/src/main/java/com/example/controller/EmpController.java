package com.example.emp;

import com.example.model.Emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.repositories.EmpRepository;

@RestController
public class EmpController {
	
	@Autowired
	private EmpRepository empRepository;
	
	// emp table allData return => List
	@RequestMapping(value = "/empData", method = RequestMethod.GET, headers = "Accept=application/json")
	//public List empList(Model model, @PageableDefault(size = 5) Pageable pageable) throws Exception 
	public List empList() throws Exception
	{
		List<Emp> empList = empRepository.findAll();
		return empList;
	}
	
	// emp table oneData search return => Emp class
	@RequestMapping(value = "/empData/{empno}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Emp getEmpById(@PathVariable int empno) {
		return empRepository.getOne(empno);
	}
	
	// emp table oneData insert return => Emp class
	@RequestMapping(value = "/empData", method = RequestMethod.POST, headers = "Accept=application/json")
	public Emp createEmp(@RequestBody Emp emp) throws Exception {
		return empRepository.save(emp);
	}

	// emp table oneData update return => Emp class
	@RequestMapping(value = "/empData", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Emp updateEmp(@RequestBody Emp emp) {
		return empRepository.save(emp);
	}

	// emp table oneData delete no return
	@RequestMapping(value = "/empData/{empno}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteEmp(@PathVariable("empno") int empno) {
		empRepository.delete(empno);
	}
	
}