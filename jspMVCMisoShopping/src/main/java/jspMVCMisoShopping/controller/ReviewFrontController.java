package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCMisoShopping.service.review.ReviewDeleteService;
import jspMVCMisoShopping.service.review.ReviewDetailService;
import jspMVCMisoShopping.service.review.ReviewListService;
import jspMVCMisoShopping.service.review.ReviewWriteService;

public class ReviewFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/reviewRegist.review")) {
			ReviewDetailService action = new ReviewDetailService();
			action.execute(request);
			
			request.setAttribute("purchaseNum", request.getParameter("purchaseNum"));
			request.setAttribute("goodsNum", request.getParameter("goodsNum"));
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("review/reviewForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/reviewWrite.review")) {
			ReviewWriteService action = new ReviewWriteService(request);
			action.execute(request);
			
			response.sendRedirect("purchaseList.item");
		}else if(command.equals("/reviewDelete.review")) {
			ReviewDeleteService action = new ReviewDeleteService();
			action.execute(request);
			
			response.sendRedirect("purchaseList.item");
		}else if(command.equals("/reviewList.review")) {
			ReviewListService action = new ReviewListService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("review/reviewList.jsp");
			dispatcher.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}