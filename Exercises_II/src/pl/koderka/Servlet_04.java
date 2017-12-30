package pl.koderka;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_04
 */
@WebServlet("/Servlet_04")
public class Servlet_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_04() {
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
		Cookie visits = getCookie("visits", cookies);
		if(visits != null) {
			Integer value = Integer.parseInt(URLDecoder.decode(visits.getValue(), "UTF-8")) + 1;
			response.getWriter().append("Witaj, odwiedziles nas juz " + value + " razy!");
			visits.setValue(URLEncoder.encode(value.toString(), "UTF-8"));
			response.addCookie(visits);
		}
		else {
			response.getWriter().append("Witaj pierwszy raz na naszej stronie!");
			Cookie cookie = new Cookie("visits", URLEncoder.encode("1", "UTF-8"));
			cookie.setMaxAge(60 * 60 * 24 * 365);
			response.addCookie(cookie);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
