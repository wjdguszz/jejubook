package com.map.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import com.map.biz.mapBizImpl;
import com.map.dao.mapDaoImpl;
import com.map.dto.mapDto;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet("/controller.do")
public class mapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public mapController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		mapBizImpl bizImpl = new mapBizImpl();
		
		String command = request.getParameter("command");
		
		if(command.equals("map")) {
			response.sendRedirect("map.jsp");
		}else if(command.equals("search")) {
			System.out.println("controller 왔다");
			int temaNo = Integer.parseInt(request.getParameter("tema"));
			String title = request.getParameter("title");
			System.out.println(temaNo);
			System.out.println(title);
			List<mapDto> list = bizImpl.select(temaNo,title);
			JSONObject res = new JSONObject();
			JSONArray ja = new JSONArray();
			
			for(int i=0; i<list.size(); i++) {
				JSONObject temp = new JSONObject();
				
				temp.put("temaNo", list.get(i).getTemaNo());
				temp.put("title", list.get(i).getTitle());
				temp.put("xMap", list.get(i).getxMap());
				temp.put("yMap", list.get(i).getyMap());
				temp.put("sortName", list.get(i).getSortName());
				temp.put("addr", list.get(i).getAddr());
				temp.put("phone", list.get(i).getPhone());
				temp.put("homePage", list.get(i).getHomePage());
				temp.put("description", list.get(i).getDescription());
				
				ja.add(temp);
			}
			res.put("list", ja);
			
			PrintWriter out = response.getWriter();
			
			if(list.size()>0) {
				out.println(res.toJSONString());
				System.out.println("controller 나간다");
			}else {
				jsResponse("검색결과가 없습니다.","map.jsp", response);
			}
		}else if(command.equals("asTema")) {
			response.sendRedirect("jejubook_var_03/asTema.jsp");
		}
	}
	
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		
		dispatch.forward(request, response);
	}
	
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String s = "<script type='text/javascript'> alert('"+msg+"'); location.href='"+url+"'; </script>";
		PrintWriter out = response.getWriter();
		out.print(s);
	}
}
