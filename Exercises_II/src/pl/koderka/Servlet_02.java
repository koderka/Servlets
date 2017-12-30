package pl.koderka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_02
 */
@WebServlet("/Servlet_02")
public class Servlet_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramNumber = request.getParameter("number");
		char[] binaries = paramNumber.toCharArray();
		boolean isBinary = true;
		for(char binary: binaries) {
			if(binary != '0' && binary != '1') {
				response.getWriter().append("To nie jest liczba binarna");
				isBinary = false;
				break;
			}
		}
		if(isBinary) {
			int sum = 0;
			List<Integer> tempBin = new ArrayList<>();
			for(int i = 0; i <binaries.length; i++) {
				String binSeq = "";
				binSeq += binaries[binaries.length - 1 - i];
				int temp = Integer.parseInt(binSeq) * (int)Math.pow(2, i);
				sum += temp;
				System.out.println(sum);
			}
			response.getWriter().append("Liczba binarna: " + paramNumber 
					+ " to liczba dziesiętna: " + sum);
		}
	}
}
