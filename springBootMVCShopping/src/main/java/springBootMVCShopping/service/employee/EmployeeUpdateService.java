package springBootMVCShopping.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBootMVCShopping.command.EmployeeCommand;
import springBootMVCShopping.domain.EmployeeDTO;
import springBootMVCShopping.mapper.EmployeeMapper;

@Service
public class EmployeeUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpAddr(employeeCommand.getEmpAddr());
		dto.setEmpAddrDetail(employeeCommand.getEmpAddrDetail());
		dto.setEmpJumin(employeeCommand.getEmpJumin());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpNum(employeeCommand.getEmpNum());
		dto.setEmpPhone(employeeCommand.getEmpPhone());
		dto.setEmpPost(employeeCommand.getEmpPost());
		dto.setEmpHireDate(employeeCommand.getEmpHireDate());
		// dto에 저장한 값을 디비에 저장합니다.
		employeeMapper.employeeUpdate(dto);
	}
}
