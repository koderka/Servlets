package pl.koderka.collection;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_02_1
 */
@WebServlet("/Servlet_02_1")
public class Servlet_02_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_02_1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		
		if(paramId != null && !paramId.equals("")) {
			String html = "<!DOCTYPE html>\n" + 
					"<html>\n" + 
					"<head>\n" + 
					"<meta charset=\"UTF-8\">\n" + 
					"<title>Insert title here</title>\n" + 
					"</head>\n" + 
					"<body>" +
					"<a href=\"http://localhost:8080/Homework_01/Servlet_03_2?id=" + paramId + "\"> Wyszukiwanie produktu po id" + "</a>"
					+ "</body>";
		
		response.getWriter().append(html);
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
