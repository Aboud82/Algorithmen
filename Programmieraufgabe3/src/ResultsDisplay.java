import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.Collection;

/**
 * a class to print out results of Dijekstra
 * 
 * @author Aboud Chamoun
 * @author Martin Fleischer
 * @author Johannis Dirr
 *
 */
public class ResultsDisplay {
	/**
	 * prints out the properties of all vertices
	 * @param graph
	 */
	static public void printResults(Graph<Vertex, Edge<Vertex>> graph) {
		Collection<Vertex> allNodes = graph.getVertices();
		for (Vertex vertex : allNodes) {
			System.out.println("node id: " + vertex.getId() + ", " + "pred: "
					+ vertex.getPredecessor() + ", " + "distance: "
					+ vertex.getDistance() + ", " + "state: "
					+ vertex.getState());
		}
	}

	/**
	 * prints out the shortest way between the two vertices in parameter 
	 * @param graph graph of vertices
	 * @param startVertexID start vertice
	 * @param destinationVertexID end vertice
	 */
	static public void printTheShortestWay(Graph<Vertex, Edge<Vertex>> graph,
			int startVertexID, int destinationVertexID) {
		WayBetweenTwoNodes shortestWay = new WayBetweenTwoNodes(
				graph, startVertexID, destinationVertexID);
		System.out.println(shortestWay.toString());
	}

}
