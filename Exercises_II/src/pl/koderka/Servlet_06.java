package pl.koderka;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_06
 */
@WebServlet("/Servlet_06")
public class Servlet_06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_06() {
        super();
        // TODO Auto-generated constructor stub
    }

	public boolean validate (String number) {
		return number != null && !number.equals("");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String number3 = request.getParameter("number3");
		String number4 = request.getParameter("number4");
		
		if(validate(number1) && validate(number2) && validate(number3) && validate(number4)) {
			
			int num1 = Integer.parseInt(number1);
			int num2 = Integer.parseInt(number2);
			int num3 = Integer.parseInt(number3);
			int num4 = Integer.parseInt(number4);
			
			response.getWriter().append("Operacje na podanych liczbach\n");
			response.getWriter().append("Suma: " + (num1 + num2 + num3 + num4) + "\n");
			response.getWriter().append("Iloczyn: " + (num1 * num2 * num3 * num4) + "\n");
			response.getWriter().append("Srednia: " + ((num1 + num2 + num3 + num4) / 4) + "\n"); 
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
