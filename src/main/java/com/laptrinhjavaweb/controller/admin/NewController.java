package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.utils.FormUtil;


@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet{	
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewService newService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* bình thường phải getParameter về sau đó thì phải ép kiểu về cho đúng với kiểu của field trong model
		Integer offset = new Integer(request.getParameter("offset"));
		Integer limit = new Integer(request.getParameter("limit"));
		 */
		
		// làm như trên lâu -> tạo ra một util FormUtil có chức năng thực hiện việc như trên thông qua 1 thư viện BeanUtils
		NewModel newModel = FormUtil.toModel(NewModel.class, request);
		int totalItem = newService.getTotalItem();
		int totalPage = (int) Math.ceil((double) totalItem/newModel.getLimitPaging());
		newModel.setTotalPage(totalPage);
		newModel.setOffsetPaging(newModel.getOffsetPaging());
		newModel.setListResult(newService.findAll((newModel.getOffsetPaging() - 1)*newModel.getLimitPaging(), newModel.getLimitPaging()));
		request.setAttribute(SystemConstant.MODEL, newModel);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

