package tpe_imb_03.pflichtuebung_03.aufgabe_01;

public class Main {

	public static void main(String args[]) {

		Node<String> first = new Node<String>("firstNode", "Hallo?");
		first.addChild("second", "aaaa!");
		System.out.println(first.getChildren());
		first.addChild("third", "Hi!");
		first.addChild("fourth", "HALT STOP!");
		Graph<String> graph1 = new Graph<String>(first);
		System.out.println(graph1.getHead().getChildren());
		Node<Integer> newNode = new Node<Integer>("zahl1", 7);
		graph1.getHead().getChildren().add(first);

		// System.out
		// .println(graph1.getHead().getChildren().getChildren());
		// System.out.println(graph1.getHead().getValue());
		// NodeList liste1 = new NodeListImpl();
		// graph1.copyInto(liste1);
		// System.out.println(graph1);
		// System.out.println(liste1);
		// System.out.println(graph1.getFirst());
		// BreadthFirstSearch<String> breadthFirstSearch = new
		// BreadthFirstSearch<String>();
		// System.out
		// .println(breadthFirstSearch.search("Doch!", graph1.getFirst()));
		// System.out.println("Weg Breitensuche:" +
		// breadthFirstSearch.getPath());
		// DeepSearch<String> deepSearch = new DeepSearch<String>();
		// System.out
		// .println(deepSearch.search("Neeeiiiiinnn!", graph1.getFirst()));
		// System.out.println("Weg Tiefensuche:" + deepSearch.getPath());
		// System.out.println(deepSearch.search("Stirb!", graph1.getFirst()));
		// System.out.println(breadthFirstSearch.search("Hallo?",
		// graph1.getFirst()));
		// System.out.println(deepSearch.search("Hallo?", graph1.getFirst()));
		// // BUGGGGYYYYY
		// System.out.println("Weg Tiefensuche:" + deepSearch.getPath());

	}

}
