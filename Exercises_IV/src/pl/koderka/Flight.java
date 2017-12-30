package pl.koderka;

import java.time.ZonedDateTime;

public class Flight {
	private Airport departure;
	private Airport arrival;
	private ZonedDateTime arrivalTime;
	private double price;
	
	public Flight(Airport departure, Airport arrival, ZonedDateTime arrivalTime, double price) {
		this.departure = departure;
		this.arrival = arrival;
		this.arrivalTime = arrivalTime;
		this.price = price;
	}
	public Airport getDeparture() {
		return departure;
	}
	public void setDeparture(Airport departure) {
		this.departure = departure;
	}
	public Airport getArrival() {
		return arrival;
	}
	public void setArrival(Airport arrival) {
		this.arrival = arrival;
	}
	public ZonedDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(ZonedDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}	
}
