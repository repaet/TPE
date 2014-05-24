package tpe_imb_03.pflichtuebung_03.aufgabe_01.search;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.Node;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeList;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeListImpl;

/**
 * Implementierung der Suchstrategie Breitensuche.
 * 
 * @param <T>
 *            Typ des zu suchenden Elements.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 24/05/2014
 */
public class Breitensuche<T> implements SearchStrategy<T> {

	private NodeList<T> path;

	/**
	 * Konstruktor der Klasse <code>Breitensuche</code>.
	 */
	public Breitensuche() {
		this.path = new NodeListImpl<T>();
	}

	@Override
	public NodeList<T> search(T suchWert, Node<T> head) {
		NodeList<T> result = new NodeListImpl<T>();
		NodeListImpl<T> queue = new NodeListImpl<T>();
		queue.add(head);
		while (!queue.isEmpty()) {
			Node<T> node = queue.pollFirst();
			boolean exist = path.contains(node);
			if (exist == false) {
				path.add(node);
				queue.addAll(node.getChildren());
				if (node.getValue() == suchWert) {
					result.add(node);
				}
			}
		}

		return result;
	}

	@Override
	public NodeList<T> getPath() {
		return this.path;
	}

}
