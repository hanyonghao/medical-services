package com.hyh.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.collections.MappingChange.Map;
import com.hyh.annotation.Autowired;
import com.hyh.config.Global;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BaseController {

	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected HttpServletResponse response;
	
	@Autowired
	protected HttpSession session;

	/**
	 * 显示页面
	 * @param page
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void display(String page) throws ServletException, IOException {
		request.getRequestDispatcher(Global.getConfig("app.view") + "/" + page).forward(request, response);
	}
	
	/**
	 * 重定向
	 * @param controller
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void redirect(String controller) throws ServletException, IOException {
		response.sendRedirect(Global.getConfig("appRoot") + "/" + controller);
	}
	
	/**
	 * 对象转JSONObject
	 * @param obj
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void returnJSON(Object obj) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		JSONObject jsonObject = JSONObject.fromObject(obj);
		PrintWriter out = response.getWriter();
		out.print(jsonObject.toString());
		out.close();
	}
	
	/**
	 * Map转JSONObject
	 * @param map
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void returnJSON(Map<String, Object> map) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().print(jsonObject.toString());
	}
	
	/**
	 * List转JSONArray
	 * @param list
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void returnJSON(List<Object> list) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		JSONArray jsonArray = JSONArray.fromObject(list);
		response.getWriter().print(jsonArray.toString());
	}
	
	/**
	 * 数组转JSONArray
	 * @param str
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void returnJSON(String... str) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		JSONArray jsonArray = JSONArray.fromObject(str);
		response.getWriter().print(jsonArray.toString());
	}
	
}
