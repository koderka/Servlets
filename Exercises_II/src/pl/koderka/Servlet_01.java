package pl.koderka;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_01
 */
@WebServlet("/Servlet_01")
public class Servlet_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public boolean validate(String parameter) {
		return parameter != null && !parameter.equals("");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramCurrency = request.getParameter("currency");
		String paramExchange = request.getParameter("exchange");
		System.out.println(paramCurrency + ":" + paramExchange);
		double result = 0;
		
		if(validate(paramCurrency)) {
			if(paramExchange.equals("EUR_USD")) {
				result = EURtoUSD(Double.parseDouble(paramCurrency));
				response.getWriter().append(paramCurrency + " EUR to " + result + " USD"); 
			}
			else if(paramExchange.equals("USD_EUR")) {
				result = USDtoEUR(Double.parseDouble(paramCurrency));
				response.getWriter().append(paramCurrency + " USD to " + result + " EUR"); 
			}
			else if(paramExchange.equals("PLN_EUR")) {
				result = PLNtoEUR(Double.parseDouble(paramCurrency));
				response.getWriter().append(paramCurrency + " PLN to " + result + " EUR"); 
			}
			else if(paramExchange.equals("EUR_PLN")) {
				result = EURtoPLN(Double.parseDouble(paramCurrency));
				response.getWriter().append(paramCurrency + " EUR to " + result + " PLN"); 
			}
			else if(paramExchange.equals("PLN_USD")) {
				result = PLNtoUSD(Double.parseDouble(paramCurrency));
				response.getWriter().append(paramCurrency + " PLN to " + result + " USD"); 
			}
			else if(paramExchange.equals("USD_PLN")) {
				result = USDtoPLN(Double.parseDouble(paramCurrency));
				response.getWriter().append(paramCurrency + " USD to " + result + " PLN"); 
			}
		}
		else {
			response.getWriter().append("Podana kwota nie jest prawidlowa");
		}
	}
	
	public double EURtoUSD (double EUR) {
		return EUR * 1.178;
	}
	
	public double USDtoEUR (double USD) {
		return USD / 1.178;
	}
	
	public double PLNtoEUR (double PLN) {
		return PLN / 4.229;
	}
	
	public double EURtoPLN (double EUR) {
		return EUR * 4.229;
	}
	
	public double PLNtoUSD (double PLN) {
		return PLN / 3.606;
	}
	public double USDtoPLN (double USD) {
		return USD * 3.606;
	}
}
