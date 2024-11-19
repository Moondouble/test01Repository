package jspMVCMisoShopping.service.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.EmployeeDTO;

public class EmployeeDetailService {
	public void execute(HttpServletRequest request) {
		String employeeNum = request.getParameter("employeeNum");
		EmployeeDAO dao = new EmployeeDAO();
		if(employeeNum == null) {
			HttpSession session = request.getSession();
			AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
			String employeeId = auth.getUserId();
			employeeNum = dao.employeeNumSelect(employeeId);
		}
		EmployeeDTO dto = dao.selectOne(employeeNum);
		request.setAttribute("dto", dto);
	}
}

