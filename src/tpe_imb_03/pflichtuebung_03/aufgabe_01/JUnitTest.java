package tpe_imb_03.pflichtuebung_03.aufgabe_01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeList;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeListImpl;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.Breitensuche;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.Tiefensuche;

public class JUnitTest {
	Node<Integer> a = new Node<Integer>("A", 2);
	Node<Integer> b = new Node<Integer>("B", 4);
	Node<Integer> c = new Node<Integer>("C", 3);
	Node<Integer> d = new Node<Integer>("D", 5);
	Node<Integer> e = new Node<Integer>("E", 3);
	Node<Integer> f = new Node<Integer>("F", 2);
	Node<Integer> g = new Node<Integer>("G", 5);
	Node<Integer> h = new Node<Integer>("H", 7);
	Node<Integer> i = new Node<Integer>("I", 9);
	Node<Integer> j = new Node<Integer>("J", 7);
	Node<Integer> k = new Node<Integer>("K", 11);
	Node<Integer> l = new Node<Integer>("L", 4);
	Node<Integer> m = new Node<Integer>("M", 7);
	Node<Integer> n = new Node<Integer>("N", 0);
	Node<Integer> o = new Node<Integer>("O", 8);
	Node<Integer> p = new Node<Integer>("P", 5);

	@Test
	public void testBreitensuche() {
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
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
		NodeList<Integer> list = new NodeListImpl<Integer>();
		Breitensuche breit = new Breitensuche();
		NodeList<Integer> liste2 = graph.search(breit, 11, a);
		NodeList<Integer> liste3 = breit.getPath();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(f);
		list.add(g);
		list.add(l);
		list.add(m);
		list.add(o);
		list.add(p);
		list.add(h);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(n);
		assertEquals(list.equals(liste3), true);
	}

	@Test
	public void testBreitensuche2() {
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
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
		NodeList<Integer> list = new NodeListImpl<Integer>();
		Breitensuche breit = new Breitensuche();
		NodeList<Integer> liste2 = graph.search(breit, 3, a);
		list.add(c);
		list.add(e);
		assertEquals(list.equals(liste2), true);
	}

	@Test
	public void testTiefenSuche() {
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
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
		NodeList<Integer> list = new NodeListImpl<Integer>();
		Tiefensuche tief = new Tiefensuche();
		NodeList<Integer> liste2 = graph.search(tief, 11, a);
		NodeList<Integer> liste3 = tief.getPath();
		list.add(a);
		list.add(b);
		list.add(e);
		list.add(h);
		list.add(i);
		list.add(f);
		list.add(j);
		list.add(k);
		list.add(g);
		list.add(c);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(d);
		list.add(o);
		list.add(p);
		assertEquals(list.equals(liste3), true);
	}

	@Test
	public void testTiefenSuche2() {
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
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
		NodeList<Integer> list = new NodeListImpl<Integer>();
		Tiefensuche tief = new Tiefensuche();
		NodeList<Integer> liste2 = graph.search(tief, 3, a);
		list.add(e);
		list.add(c);
		assertEquals(list.equals(liste2), true);
	}

}