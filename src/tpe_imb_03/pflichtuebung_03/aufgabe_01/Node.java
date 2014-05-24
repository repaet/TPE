package tpe_imb_03.pflichtuebung_03.aufgabe_01;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeListImpl;

/**
 * Der <code>Knoten</code> kann jeden beliebigen Typ annehmen. Jeder
 * <code>Knoten</code> besitzt einen Namen, einen Wert (beliebigen Typs) und
 * beliebig viele Kinder (Kindsknoten).
 * 
 * @param <T>
 *            Typ des zu speichernden Knoten.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 24/05/2014
 */
public class Node<T> {

	private String name;
	private T wert;
	private NodeListImpl<T> child;

	/**
	 * Konstruktor der Klasse <code>Node</code>.
	 * 
	 * @param name
	 *            Name des Knoten.
	 * @param wert
	 *            Wert des Knoten.
	 */
	public Node(String name, T wert) {
		this(name, wert, new NodeListImpl<T>());
	}

	/**
	 * Konstruktor der Klasse <code>Node</code>.
	 * 
	 * @param name
	 *            Name des Knoten.
	 * @param wert
	 *            Wert des Knoten.
	 * @param n
	 */
	public Node(String name, T wert, NodeListImpl<T> n) {
		this.name = name;
		this.wert = wert;
		this.child = n;
	}

	/**
	 * Hinzufügen eines Kindnoten.
	 * 
	 * @param name
	 *            Name des Knoten.
	 * @param wert
	 *            Wert des Knoten.
	 */
	public void addChild(String name, T wert) {
		child.add(new Node<T>(name, wert));
	}

	/**
	 * Hinzufügen eines Kindnoten.
	 * 
	 * @param node
	 *            Knoten, welcher hinzugefügt wird.
	 */
	public void addChild(Node<T> node) {
		child.add(node);
	}

	/**
	 * Auslesen der Kindknoten des Knoten.
	 * 
	 * @return Liste der Kindknoten des Knoten.
	 */
	public NodeListImpl<T> getChildren() {
		return child;
	}

	/**
	 * Auslesen des Namen des Knoten.
	 * 
	 * @return Name des Knoten.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Auslesen des Wertes des Knoten.
	 * 
	 * @return Wert des Knoten.
	 */
	public T getValue() {
		return wert;
	}

	/**
	 * Ausgabe des Knoten.
	 */
	@Override
	public String toString() {
		return getName();
	}
}