package tpe_imb_03.pflichtuebung_03.aufgabe_01;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeListImpl;

public class Node<T> {

	private String name;
	private T wert;
	private NodeListImpl<T> child;

	public Node(String name, T wert, NodeListImpl<T> n) {
		this(name, wert);
		this.child = n;
	}

	public Node(String name, T wert) {
		this.name = name;
		this.wert = wert;
		this.child = new NodeListImpl<T>();
	}

	public void addChild(String name, T wert) {
		child.add(new Node<T>(name, wert));
	}

	public void addChild(Node<T> n) {
		child.add(n);
	}

	public NodeListImpl<T> getChildren() {
		return child;
	}

	public String getName() {
		return name;
	}

	public T getValue() {
		return wert;
	}

	@Override
	public String toString() {
		return this.getName();
	}
}