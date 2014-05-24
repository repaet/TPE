package tpe_imb_03.pflichtuebung_03.aufgabe_01;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.Breitensuche;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.Tiefensuche;

public class Simulation {
	public static void main(String args[]) {

		Node<Integer> a1 = new Node<Integer>("A", 2);
		Node<Integer> a2 = new Node<Integer>("B", 4);
		Node<Integer> a3 = new Node<Integer>("C", 3);
		Node<Integer> a4 = new Node<Integer>("D", 5);
		Node<Integer> a5 = new Node<Integer>("E", 3);
		Node<Integer> a6 = new Node<Integer>("F", 2);
		Node<Integer> a7 = new Node<Integer>("G", 5);
		Node<Integer> a8 = new Node<Integer>("H", 7);
		Node<Integer> a9 = new Node<Integer>("I", 9);
		Node<Integer> a10 = new Node<Integer>("J", 7);
		Node<Integer> a11 = new Node<Integer>("K", 11);

		a1.addChild(a2);
		a1.addChild(a3);
		a1.addChild(a4);
		a2.addChild(a1);
		a2.addChild(a6);
		a2.addChild(a7);
		a2.addChild(a5);
		a5.addChild(a8);
		a7.addChild(a4);
		a8.addChild(a2);
		a6.addChild(a10);
		a6.addChild(a11);
		a5.addChild(a9);
		a10.addChild(a9);
		a11.addChild(a4);
		Graph<Integer> graph = new Graph<Integer>(a1);
		Breitensuche b = new Breitensuche();
		System.out.println(graph.search(b, 11, a1));
		Tiefensuche c = new Tiefensuche<>();
		System.out.println(graph.search(c, 11, a1));

	}
}
