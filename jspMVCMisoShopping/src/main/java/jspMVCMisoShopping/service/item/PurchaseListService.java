package jspMVCMisoShopping.service.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.ItemDAO;
import jspMVCMisoShopping.model.dto.PurchaseInfoDTO;
import jspMVCMisoShopping.service.MemberAuthService;

public class PurchaseListService extends MemberAuthService{

	public PurchaseListService(HttpServletRequest request) {
		super(request);
	}
	public void execute(HttpServletRequest request) {
		ItemDAO dao = new ItemDAO();
		System.out.println(memberNum);
		List<PurchaseInfoDTO> list = dao.purchaseItemSelect(memberNum);
		request.setAttribute("list", list);
	}
}
