package pl.koderka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_05_1
 */
@WebServlet("/Servlet_05_1")
public class Servlet_05_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_05_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String header = "<!DOCTYPE html>\n" 
				+ "<html>\n"
				+ "<head>\n" 
				+ "<meta charset=\"UTF-8\">\n" 
				+ "<title>Insert title here</title>\n" 
				+ "</head>";
		String html = header 
				+ "<form action=\"\" method=\"post\">" 
				+ "<input type=\"text\" name=\"name\" placeholder=\"Nazwa produktu\">"
				+ "<input type=\"number\" step=\"0.01\" name=\"price\" placeholder=\"Cena produktu\">"
				+ "<input type=\"number\" step=\"0.01\" name=\"quantity\" placeholder=\"Ilosc produktu\">"
				+ "<input type=\"submit\" value=\"Dodaj do koszyka\">"
				+ "</form>";
		response.getWriter().append(html);
		String link = "<br><br><a href=\"http://localhost:8080/Homework_02/Servlet_05_02\">Zobacz zawartosc koszyka</a>";
		response.getWriter().append(link);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		if(sess.getAttribute("basket")== null) {
			sess.setAttribute("basket", new ArrayList<Product>());
		}
		
		String paramName = request.getParameter("name");
		String paramPrice = request.getParameter("price");
		String paramQuantity = request.getParameter("quantity");

		List<Product> products = (List<Product>)sess.getAttribute("basket");

		if(validate(paramName) && validate(paramPrice) && validate(paramQuantity)) {
			float price = Float.parseFloat(paramPrice);
			float quantity = Float.parseFloat(paramQuantity);
			Product product = new Product(paramName, price, quantity);
			products.add(product);
			sess.setAttribute("basket", products);
			response.getWriter().append("Produkt dodany");
		}
		response.sendRedirect("Servlet_05_1");
		
	}
	
	public boolean validate(String param) {
		return param != null & !param.equals("");
	}
}
