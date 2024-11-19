package jspMVCMisoShopping.service.inquire;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.InquireDAO;

public class InquireDetailService {
public void execute(HttpServletRequest request) {
	String inquireNum = request.getParameter("inquireNum");
	InquireDAO dao = new InquireDAO();
	InquireDTO dto = dao.inquireSelectOne(inquireNum);
	request.setAttribute("dto", dto);
}
}
