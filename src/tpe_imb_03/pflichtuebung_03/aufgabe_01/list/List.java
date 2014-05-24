package tpe_imb_03.pflichtuebung_03.aufgabe_01.list;

/**
 * Einfache Datenstruktur zur Verwaltung einer Reihe von Elementen.
 * 
 * @param <T>
 *            Typ der gespeicherten Elemente.
 */
public interface List<T> extends Iterable<T> {
	/**
	 * Überprüft, ob ein Element bereits vorhanden ist.
	 * 
	 * @param e
	 *            Element auf das geprüft werden soll
	 * @return true wenn vorhanden, andernfalls false
	 */
	public abstract boolean contains(Object e);

	/**
	 * Fügt am Ende ein Element hinzu.
	 * 
	 * @param e
	 *            Element, das hinzugefügt werden soll.
	 * @return ist immer true
	 */
	public abstract boolean add(T e);

	/**
	 * Fügt am Anfang ein Element hinzu.
	 * 
	 * @param e
	 *            Element, das angefügt werden soll.
	 */
	public abstract void addFirst(T e);

	/**
	 * Liefert das erste Element zurück, ohne es zu entfernen.
	 * 
	 * @return das erste Element.
	 */
	public abstract T peekFirst();

	/**
	 * Überprüft, ob Elemente vorhanden sind.
	 * 
	 * @return true wenn die Datenstruktur leer ist, andernlass false
	 */
	public abstract boolean isEmpty();

	/**
	 * Entfernt das erste Element und liefert es zurück.
	 * 
	 * @return das erste Element
	 */
	public abstract T pollFirst();

	/**
	 * Löscht den Inhalt der List.
	 */
	public abstract void clear();
}
