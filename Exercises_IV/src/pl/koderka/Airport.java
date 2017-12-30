package pl.koderka;

import java.util.TimeZone;

public class Airport {
	private String name;
	private String code;
	private TimeZone zone;
	 
	public Airport () {
		
	}
	public Airport(String name, String code, TimeZone zone) {
		this.name = name;
		this.code = code;
		this.zone = zone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public TimeZone getZone() {
		return zone;
	}
	public void setZone(TimeZone zone) {
		this.zone = zone;
	}
}
