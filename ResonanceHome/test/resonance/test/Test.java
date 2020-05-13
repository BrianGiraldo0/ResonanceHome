package resonance.test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import com.resonance.model.util.Fecha;

public class Test {

	public static void main(String[] args) {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		int month = localDate.getMonthValue();
		int year = localDate.getYear();
//		int day = localDate.getDayOfMonth();
		Fecha fecha = new Fecha(1, 6, year);
		fecha.anadirDia();
		System.out.println(fecha.isMayor(date));

	}

}
