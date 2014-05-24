package tpe_imb_03.pflichtuebung_03.aufgabe_01.search;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.Node;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeList;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeListImpl;

public class Tiefensuche<T> implements SearchStrategy<T> {

	private NodeList<T> path;
	private NodeList<T> result = new NodeListImpl<T>();

	public Tiefensuche() {
		this.path = new NodeListImpl<T>();
	}

	@Override
	public NodeList<T> search(T wert, Node<T> head) {
		boolean exist = path.contains(head);
		if (exist == false) {
			path.add(head);
			if (head.getValue() == wert) {
				result.add(head);
			}
			NodeList<T> allChildren = head.getChildren();
			for (Node<T> a : allChildren) {
				search(wert, a);
			}
		}
		return result;
	}

	@Override
	public NodeList<T> getPath() {
		return this.path;
	}

}
