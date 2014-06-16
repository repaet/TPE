package tpe_imb_03.pflichtuebung_04.aufgabe_01.film;

/**
 * Enumeration, die die erlaubten Altersfreigaben (USK's) enthält.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 15/06/2014
 */
public enum USK {

	OHNE(0, "ohne Altersbeschränkung"), AB6(6, "ab 6 Jahre"), AB12(12,
			"ab 12 Jahre"), AB16(16, "ab 16 Jahre"), AB18(18,
			"keine Jugendfreigabe");

	private final int USK;
	private final String USKINTEXT;

	/**
	 * Konstruktor der Enumeration <code>USK</code>.
	 * 
	 * @param usk
	 * @param uskInText
	 */
	private USK(int usk, String uskInText) {
		this.USK = usk;
		this.USKINTEXT = uskInText;
	}

	/**
	 * Auslesen der Altersfreigabe (USK) zur internen Verarbeitung.
	 * 
	 * @return Altersfreigabe (USK)
	 */
	public int getUSK() {
		return this.USK;
	}

	/**
	 * Auslesen der Altersfreigabe (USK).
	 * 
	 * <pre>
	 * ohne Altersbeschränkung
	 * </pre>
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.USKINTEXT;
	}

}
