package tpe_imb_03.pflichtuebung_04.aufgabe_01.system;

/**
 * IllegalTimeException wirft eine Fehlermeldung aus, falls eine falsche
 * Zeiteingabe getätigt wurde.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 15/06/2014
 */
public class IllegalTimeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Weitergabe der Fehlermeldung.
	 * 
	 * @param message
	 */
	public IllegalTimeException(String message) {
		super(message);
	}

}
