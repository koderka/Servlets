package pl.koderka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet03
 */
@WebServlet("/Servlet_03")
public class Servlet_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_03() {
        super();
        // TODO Auto-generated constructor stub
    }

	public String generateResponse(String[] params) {
		
		String header = "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>Insert title here</title>\n" + 
				"</head>";
		String html = header + "<form action=\"Servlet_03\" method=\"post\">" 
				+ "<input type =\"text\" name=\"text1\" value=\""+ params[0] + "\">"
				+ "<input type =\"text\" name=\"text2\" value=\""+ params[1] + "\">"
				+ "<input type =\"text\" name=\"text3\" value=\""+ params[2] + "\">"
				+ "<input type =\"text\" name=\"text4\" value=\""+ params[3] + "\">"
				+ "<input type =\"text\" name=\"text5\" value=\""+ params[4] + "\">"
				+ "<input type =\"submit\" value=\"Wyslij\">"
				+ "</form>"; 
		return html;
	}

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession();
		
		String[] values = new String[5];
		
		values[0] = (String) (sess.getAttribute("text1") != null ? sess.getAttribute("text1") : "");
		values[1] = (String) (sess.getAttribute("text2") != null ? sess.getAttribute("text2") : "");
		values[2] = (String) (sess.getAttribute("text3") != null ? sess.getAttribute("text3") : "");
		values[3] = (String) (sess.getAttribute("text4") != null ? sess.getAttribute("text4") : "");
		values[4] = (String) (sess.getAttribute("text5") != null ? sess.getAttribute("text5") : "");
		
		values[0] = (String) (request.getParameter("text1") != null ? request.getParameter("text1") : values[0]);
		values[1] = (String) (request.getParameter("text2") != null ? request.getParameter("text2") : values[1]);
		values[2] = (String) (request.getParameter("text3") != null ? request.getParameter("text3") : values[2]);
		values[3] = (String) (request.getParameter("text4") != null ? request.getParameter("text4") : values[3]);
		values[4] = (String) (request.getParameter("text5") != null ? request.getParameter("text5") : values[4]);
		
		response.getWriter().append(generateResponse(values));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();
		HttpSession sess = request.getSession();
		for(Map.Entry<String, String[]> entry:map.entrySet()) {
		 	sess.setAttribute(entry.getKey(), entry.getValue()[0]);
		}
		doGet(request, response);
	}

}
