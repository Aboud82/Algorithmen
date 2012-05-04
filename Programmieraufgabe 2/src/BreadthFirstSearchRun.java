import graph.Edge;
import graph.Graph;
import graph.GraphLesen;
import graph.Vertex;

public class BreadthFirstSearchRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Graph<Vertex, Edge<Vertex>> graph8Directed = GraphLesen.FileToGraph("/home/martin/workspace/Algorithmen/Programmieraufgabe 2/src/graphBeispiele/graph8.txt",true);
		Graph<Vertex, Edge<Vertex>> graph9Directed = GraphLesen.FileToGraph("/home/martin/workspace/Algorithmen/Programmieraufgabe 2/src/graphBeispiele/graph9.txt",true);
		Graph<Vertex, Edge<Vertex>> graph20Directed = GraphLesen.FileToGraph("/home/martin/workspace/Algorithmen/Programmieraufgabe 2/src/graphBeispiele/graph20.txt",true);
		Graph<Vertex, Edge<Vertex>> graph20Undirected = GraphLesen.FileToGraph("/home/martin/workspace/Algorithmen/Programmieraufgabe 2/src/graphBeispiele/graph20.txt",false);

		System.out.println(graph8Directed.toString());
	}

}
