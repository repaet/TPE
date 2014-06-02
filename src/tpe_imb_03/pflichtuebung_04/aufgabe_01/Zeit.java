package tpe_imb_03.pflichtuebung_04.aufgabe_01;

public class Zeit {

	public static int parse(String zeit) throws IllegalTimeException {
		String[] split = zeit.split(":");
		int std = Integer.parseInt(split[0]);
		int min = Integer.parseInt(split[1]);
		int zeitInMin = 0;

		try {

			if (std > 23 || std < 0) {
				throw new IllegalTimeException("Fehler: Stundenangabe falsch!");
			}

			if (min > 59 || min < 0) {
				throw new IllegalTimeException("Fehler: Minutenangabe falsch!");
			}

			zeitInMin = (std * 60) + min;

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return zeitInMin;
	}

	public static String toString(int startzeit) {
		int std = startzeit / 60;
		int min = startzeit - (std * 60);
		String output = std + ":";

		if (std < 10) {
			output = "0" + output;
		}
		
		if (min < 10) {
			output += "0" + min;
		} else {
			output += min;
		}
		
		return output;
	}

}
