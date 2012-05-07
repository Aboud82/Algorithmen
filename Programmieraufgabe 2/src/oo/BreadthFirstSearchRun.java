package oo;
import graph.Edge;
import graph.Graph;
import graph.GraphLesen;
import graph.Vertex;

/**
 * This class runs the program
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 * @author Johannes Dirr
 *
 */
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

        System.out.println(graph20Directed.toString());
		System.out.println(BreadthFirstSearch.breadthFirstSearch(5, graph8Directed).toString());
		
		BreadthFirstSearch.getShortestDistancesFor(graph8Directed, 5);
		BreadthFirstSearch.getShortestPathBetween(graph8Directed, 5, 7);
		
	}

}
