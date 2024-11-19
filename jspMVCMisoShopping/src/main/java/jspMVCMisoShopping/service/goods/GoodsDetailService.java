package jspMVCMisoShopping.service.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.GoodsDAO;
import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.GoodsDTO;

public class GoodsDetailService {
public void execute(HttpServletRequest request) {
	String goodsNum = request.getParameter("goodsNum");
	GoodsDAO dao = new GoodsDAO();
	GoodsDTO dto = dao.goodsSelectOne(goodsNum);
	request.setAttribute("dto", dto);
	
	HttpSession session = request.getSession();
	AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
	if(auth != null) {
		MemberDAO memdao = new MemberDAO();
		String memberNum = memdao.memberNumSelect(auth.getUserId());
		ItemDAO itemdao = new ItemDAO();
		int i = itemdao.wishSelectOne(memberNum, goodsNum);
		if( i == 1 ) {
			request.setAttribute("isTrue", "true");
		}
	}
	
}
}
