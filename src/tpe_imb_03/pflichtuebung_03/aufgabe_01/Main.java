package tpe_imb_03.pflichtuebung_03.aufgabe_01;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.Breitensuche;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.SearchStrategy;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.Tiefensuche;

public class Main {
	public static void main(String args[]) {
		Node<Integer> a = new Node<Integer>("A", 1);
		Node<Integer> b = new Node<Integer>("B", 2);
		Node<Integer> c = new Node<Integer>("C", 3);
		Node<Integer> d = new Node<Integer>("D", 4);
		Node<Integer> e = new Node<Integer>("E", 5);
		Node<Integer> f = new Node<Integer>("F", 6);
		Node<Integer> g = new Node<Integer>("G", 7);
		Node<Integer> h = new Node<Integer>("H", 8);
		Node<Integer> i = new Node<Integer>("I", 9);
		Node<Integer> j = new Node<Integer>("J", 10);
		Node<Integer> k = new Node<Integer>("K", 11);
		Node<Integer> l = new Node<Integer>("L", 12);
		Node<Integer> m = new Node<Integer>("M", 13);
		Node<Integer> n = new Node<Integer>("N", 14);
		Node<Integer> o = new Node<Integer>("O", 15);
		Node<Integer> p = new Node<Integer>("P", 16);

		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(a);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);
		e.addChild(h);
		e.addChild(i);
		f.addChild(j);
		f.addChild(k);
		c.addChild(l);
		c.addChild(m);
		m.addChild(n);
		d.addChild(o);
		d.addChild(p);
		
		Graph<Integer> graph = new Graph<Integer>(a);
		SearchStrategy<Integer> tief = new Breitensuche<Integer>();
		System.out.println(graph.search(tief, 11));
		
		SearchStrategy<Integer> breit = new Tiefensuche<Integer>();
		System.out.println(graph.search(breit, 11));
		
		System.out.println(tief.getPath());
		System.out.println(breit.getPath());
	}
}
