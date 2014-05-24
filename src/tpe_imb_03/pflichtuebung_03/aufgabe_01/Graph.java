package tpe_imb_03.pflichtuebung_03.aufgabe_01;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.List;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeList;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeListImpl;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.SearchStrategy;

public class Graph<T> {

	private Node<T> head;

	public Graph(Node<T> n) {
		this.head = n;
	}

	public NodeList<T> search(SearchStrategy<T> suche, T wert, Node<T> node) {
		NodeList<T> result = new NodeListImpl<T>();
		result = suche.search(wert, node);
		return result;
	}

	public void copyInto(List<T> liste) {

	}

	public void setHead(Node<T> node) {

	}

	public Node<T> getHead() {
		return head;
	}

}
