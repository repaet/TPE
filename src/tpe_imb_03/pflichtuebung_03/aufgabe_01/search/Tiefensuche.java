package tpe_imb_03.pflichtuebung_03.aufgabe_01.search;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.Node;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeList;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeListImpl;

/**
 * Implementierung der Suchstrategie Tiefensuche.
 * 
 * @param <T>
 *            Typ des zu suchenden Elements.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1.1 26/05/2014
 */
public class Tiefensuche<T> implements SearchStrategy<T> {

	private NodeList<T> path;
	private NodeList<T> result = new NodeListImpl<T>();

	/**
	 * Konstruktor der Klasse <code>Tiefensuche</code>.
	 */
	public Tiefensuche() {
		this.path = new NodeListImpl<T>();
	}

	/**
	 * @see tpe_imb_03.pflichtuebung_03.aufgabe_01.search.SearchStrategy#search(java.lang.Object, tpe_imb_03.pflichtuebung_03.aufgabe_01.Node)
	 */
	@Override
	public NodeList<T> search(T suchWert, Node<T> head) {
		boolean exist = path.contains(head);
		if (!exist) {
			path.add(head);
			if (head.getValue() == suchWert) {
				result.add(head);
			}
			NodeList<T> allChildren = head.getChildren();
			for (Node<T> a : allChildren) {
				search(suchWert, a);
			}
		}

		return result;
	}

	/**
	 * @see tpe_imb_03.pflichtuebung_03.aufgabe_01.search.SearchStrategy#getPath()
	 */
	@Override
	public NodeList<T> getPath() {
		return this.path;
	}

}
