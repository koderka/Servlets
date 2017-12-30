package pl.koderka;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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
	private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss a";
       
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
		
		request.setAttribute("airports", AirportDao.getList());
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/form_Airport.jsp")
		.forward(request, response);

	}

	public boolean validate(String parameter) {
		return parameter != null && !parameter.equals("");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depAirport = request.getParameter("departureAirport");
		String arrAirport = request.getParameter("arrivalAirport");
		String depTime = request.getParameter("depTime");
		String duration = request.getParameter("duration");
		String price = request.getParameter("price");
		
		if(validate(depAirport) && validate(arrAirport) && validate(depTime)
		&& validate(duration) && validate(price) && !depAirport.equals(arrAirport)
		&& Double.parseDouble(price) > 0) {
			
			Airport departureAirport = AirportDao.findAirportByCode(depAirport);
			Airport arrivalAirport = AirportDao.findAirportByCode(arrAirport);
			response.getWriter().append("Lotnisko odlotu :" + departureAirport.getName()
			+ "\n" + "Lotnisko przylotu: " + arrivalAirport.getName() + "\n" 
			+ "Godzina odlotu: " + depTime + "\n" + "Czas trwania lotu: " + duration + "\n" 
			+ "Cena biletu: " + price);
			
			LocalDateTime ldtDepTime = LocalDateTime.parse(depTime, DateTimeFormatter.ofPattern(DATE_FORMAT));
			ZoneId zoneDepAirport = ZoneId.of(departureAirport.getZone().getID());
			ZonedDateTime depZonedDateTime = ldtDepTime.atZone(zoneDepAirport);
			
			
			ldtDepTime.plusHours(Integer.parseInt(duration));
			ZoneId zoneArrAirport = ZoneId.of(arrivalAirport.getZone().getID());
			ZonedDateTime arrZonedDateTime = ldtDepTime.atZone(zoneArrAirport);
			
			request.setAttribute("flight", new Flight(departureAirport, arrivalAirport, 
			arrZonedDateTime, Double.parseDouble(price)));
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/view_Flight.jsp")
			.forward(request, response);
		}
	}

}
