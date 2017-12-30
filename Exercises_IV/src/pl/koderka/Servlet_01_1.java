package pl.koderka;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_01_1
 */
@WebServlet("/Servlet_01_1")
public class Servlet_01_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_01_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    public static Cookie getCookie(String key, Cookie[] cookies) {
		if(cookies != null) {
			for(Cookie cookie: cookies) {
				if(key.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie language = getCookie("language", cookies);
		
		if(language == null) {
			String header = "<!DOCTYPE html>\n" + 
					"<html>\n" + 
					"<head>\n" + 
					"<meta charset=\"UTF-8\">\n" + 
					"<title>Insert title here</title>\n" + 
					"</head>";
			String html = header + "<form action=\"Servlet_01_1\" method=\"post\">" 
					+ "<select name=\"language\">"
					+ "<option value =\"en\"> EN </option>"
					+ "<option value =\"pl\"> PL </option>"
					+ "<option value =\"de\"> DE </option>"
					+ "<option value =\"es\"> ES </option>"
					+ "<option value =\"fr\"> FR </option>"
					+ "</select>"
					+ "<input type=\"submit\" value=\"Wybierz jezek\">"
					+ "</form>"; 
			response.getWriter().append(html);
		}
		else {
			
			Map<String, String> lang = new HashMap<>();
			   lang.put("en", "Hello");
			   lang.put("pl", "Cześć");
			   lang.put("de", "Hallo");
			   lang.put("es", "Hola");
			   lang.put("fr", "Bienvenue");
			
			request.setAttribute("lang", lang.get(language.getValue()));
			
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/view_Servlet_01.jsp")
			.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramLanguage = request.getParameter("language");
		HttpSession sess = request.getSession();
		sess.setAttribute("language", paramLanguage);
		response.sendRedirect("Servlet_01_2");
	}

}
