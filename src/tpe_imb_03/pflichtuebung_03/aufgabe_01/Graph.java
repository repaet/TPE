package tpe_imb_03.pflichtuebung_03.aufgabe_01;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeList;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeListImpl;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.SearchStrategy;

public class Graph<T> {

	private Node<T> head;

	public Graph(Node<T> head) {
		this.head = head;
	}

	public NodeList<T> search(SearchStrategy<T> s, T suchWert) {
		NodeList<T> result = new NodeListImpl<T>();
		result = s.search(suchWert, this.head);
		return result;
	}

	public void copyInto(NodeList<T> liste) {
		if (!liste.contains(head)) {
			liste.add(head);
			for (Node<T> n : head.getChildren()) {
				this.head = n; 
				copyInto(liste);
			}
		}
	}

	public void setHead(Node<T> node) {
		this.head = node;
	}

	public Node<T> getHead() {
		return head;
	}

}
