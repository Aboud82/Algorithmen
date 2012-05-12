import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.Collection;

public class ResultsDisplay {
	static public void printResults(Graph<Vertex, Edge<Vertex>> graph) {
		Collection<Vertex> allNodes = graph.getVertices();
		for (Vertex vertex : allNodes) {
			System.out.println("node id: " + vertex.getId() + ", " + "pred: "
					+ vertex.getPredecessor() + ", " + "distance: "
					+ vertex.getDistance() + ", " + "state: "
					+ vertex.getState());
		}
	}

	static public void printTheShortestWay(Graph<Vertex, Edge<Vertex>> graph,
			int startVertexID, int destinationVertexID) {
		ShortestWayBetweenTwoNodes shortestWay = new ShortestWayBetweenTwoNodes(
				graph, startVertexID, destinationVertexID);
		System.out.println(shortestWay.toString());
	}

}
