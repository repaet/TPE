package tpe_imb_03.pflichtuebung_03.aufgabe_01;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeList;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeListImpl;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.SearchStrategy;

/**
 * Der <code>Graph</code> bestet aus beliebig vielen Knoten. Einer dieser Knoten
 * muss als Startknoten gesetzt werden - alle Knoten sind vom Startknoten aus
 * erreichbar.
 * 
 * @param <T>
 *            Typ der zu speichernden Knoten.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 24/05/2014
 */
public class Graph<T> {

	private Node<T> head;

	/**
	 * Konstruktor der Klasse <code>Graph</code>.
	 * 
	 * @param head
	 *            Startknoten.
	 */
	public Graph(Node<T> head) {
		this.head = head;
	}

	/**
	 * Durchsucht den Graphen mit gewählter Suchstrategie nach gewähltem Wert
	 * eines Knoten.
	 * 
	 * @param s
	 *            Verwendete Suchstrategie.
	 * @param suchWert
	 *            Zu suchender Wert eines Knoten.
	 * @return Liste mit allen Knoten des gesuchten Knotenwertes.
	 */
	public NodeList<T> search(SearchStrategy<T> s, T suchWert) {
		NodeList<T> result = new NodeListImpl<T>();
		result = s.search(suchWert, this.head);
		return result;
	}

	/**
	 * Kopiert alle Knoten einer Liste in eine übergebene Liste.
	 * 
	 * @param liste
	 *            Liste, in welche die Knoten kopiert werden.
	 */
	public void copyInto(NodeList<T> liste) {
		if (!liste.contains(head)) {
			liste.add(head);
			for (Node<T> n : head.getChildren()) {
				this.head = n;
				copyInto(liste);
			}
		}
	}

	/**
	 * Setzt den Startknoten des Graphen.
	 * 
	 * @param head
	 *            Startknoten.
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}

	/**
	 * Gibt den Startknoten des Graphen zurück.
	 * 
	 * @return Startknoten.
	 */
	public Node<T> getHead() {
		return head;
	}

}
