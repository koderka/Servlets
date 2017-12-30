package pl.koderka;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class AirportDao {
	
	public static List <Airport> getList() {
		Path path = Paths.get("/home/magdalena/Servlets/Exercises_IV/src/pl/koderka/airports.txt");
		List <Airport> list = new ArrayList<>();
		try {
			for(String line: Files.readAllLines(path)) {
				StringTokenizer tok = new StringTokenizer(line, ";");
				list.add(new Airport(tok.nextToken(), tok.nextToken(), TimeZone.getTimeZone(tok.nextToken())));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Airport findAirportByCode(String code) {
		for(Airport airport: getList()) {
			if(code.equals(airport.getCode())) {
				return airport;
			}
		}
		return null;
	}
}
