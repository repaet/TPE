package tpe_imb_03.pflichtuebung_03.aufgabe_01.search;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.Node;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeList;

/**
 * Interface zur Implementierung von Suchstrategien.
 * 
 * @param <T>
 *            Typ des zu suchenden Elements.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 24/05/2014
 */
public interface SearchStrategy<T> {

	/**
	 * Sucht den gesuchten Wert ab dem festgelegten Startknoten.
	 * 
	 * @param wert
	 *            Wert nach dem gesucht werden soll.
	 * @param node
	 *            Startknoten des Graphen.
	 * @return Liste der Knotennamen.
	 */
	public NodeList<T> search(T wert, Node<T> node);

	/**
	 * Gibt den Pfad der letzten Suche zurück.
	 * 
	 * @return Liste der Knotennamen.
	 */
	public NodeList<T> getPath();

}
