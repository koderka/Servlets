package pl.koderka;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_05_02
 */
@WebServlet("/Servlet_05_02")
public class Servlet_05_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_05_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String header = "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>Insert title here</title>\n" + 
				"</head>";
		response.getWriter().append(header);
		
		HttpSession sess = request.getSession();
		
		if(sess.getAttribute("basket") != null) {
			List<Product> products = (List<Product>) sess.getAttribute("basket");
			float sum = 0;
			for(Product product: products) {
				double partialSum = product.getQuantity() * product.getPrice();
				
				response.getWriter().append(product.getName() + " - " 
				+ round(product.getQuantity(), 2) + " x " + round(product.getPrice(), 2) + " PLN = " 
				+ round(partialSum, 2) + "<br>");
				sum += partialSum;
			}
			response.getWriter().append("SUMA:" + round(sum, 2) + " PLN");
		}
		String link = "<br><br><a href=\"http://localhost:8080/Homework_02/Servlet_05_1\">Dodaj kolejny produkt do koszyka</a>";
		response.getWriter().append(link);
	}

	public float round(float f, int decimalPlace) {
	    return BigDecimal.valueOf(f).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).floatValue();
	}
	
	public double round(double d, int decimalPlace) {
	    return BigDecimal.valueOf(d).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
