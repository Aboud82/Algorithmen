import graph.Edge;
import graph.EndStateOfPoint;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.Collection;

/**
 * a class to performe the Dijkstra algorithm
 * 
 * @author Aboud Chamoun
 * @author Martin Fleischer
 * @author Johannis Dirr
 * 
 */
public class Dijkstra {

	/**
	 * initializes the Dijkstra algorithm by setting the start vertex, setting a
	 * queue to help performing Dijkstra
	 * 
	 * @param graph
	 *            the graph in which the Dijkstra algorithm should be performed
	 * @param startVertexID
	 *            the start vertex
	 * @param destinationVertexID
	 *            the end vertex
	 */
	public static void initializeDijkstra(Graph<Vertex, Edge<Vertex>> graph,
			int startVertexID, int destinationVertexID) {

		for (int i = 0; i < graph.getVertices().size(); i++) {
			graph.getVertex(i).setDistance(Integer.MAX_VALUE);
			graph.getVertex(i).setPredecessor(null);
		}

		Vertex startVertex = graph.getVertex(startVertexID);
		startVertex.setDistance(0);
		startVertex.setPredecessor(startVertex);
		startVertex.setState(EndStateOfPoint.STARTPOINT);

		ArrayList<Vertex> queue = new ArrayList<Vertex>();

		for (int i = 0; i < graph.getVertices().size(); i++) {
			queue.add(graph.getVertex(i));
		}

		performeDijkstra(graph, queue, startVertexID, destinationVertexID);

	}

	/**
	 * performs the Dijkstra algorithm
	 * 
	 * @param graph
	 *            a graph, in which the Dijkstra will be performed
	 * @param queue
	 *            a queue of vertices to help perform Dijkstra
	 * @param startVertexID
	 *            a start vertices id
	 * @param destinationVertexID
	 *            an end vertices id
	 */
	static private void performeDijkstra(Graph<Vertex, Edge<Vertex>> graph,
			ArrayList<Vertex> queue, int startVertexID, int destinationVertexID) {

		while (queue.size() != 0) {

			int lowest = 0;
			for (int i = 0; i < queue.size(); i++) {
				if (queue.get(i).getDistance() < queue.get(lowest)
						.getDistance()) {
					lowest = i;
				}
			}

			Vertex lowestElementInQueue = queue.get(lowest);
            
			//stop the loop id the destinatiopn is reached
			if ( lowestElementInQueue.getId() == destinationVertexID)break;
			
			queue.remove(lowestElementInQueue);

			Collection<Edge<Vertex>> edgesOfFirstVertex = graph
					.getIncidentEdges(lowestElementInQueue);

			if (edgesOfFirstVertex.size() != 0) {
				for (Edge<Vertex> edge : edgesOfFirstVertex) {
					Vertex neighbour = edge.getVertexB();
					int weightOfEdge = edge.getWeight();
					if (weightOfEdge < 0) {
						throw new IllegalArgumentException("one edge of "
								+ lowestElementInQueue.getId() + " is negative");

					}

					relax(lowestElementInQueue, neighbour, weightOfEdge);

				}

			}
		
		}

		ResultsDisplay.printResults(graph);
		ResultsDisplay.printTheShortestWay(graph, startVertexID,
				destinationVertexID);
	}

	/**
	 * to performe the relaxation between two vertices
	 * 
	 * @param firstVertex
	 *            the first vertex
	 * @param neighbour
	 *            the neighbouring vertex of the first vertex
	 * @param weightOfEdge
	 *            the weight of the edge between the first vertex and the
	 *            neighbouring vertex
	 */
	static private void relax(Vertex firstVertex, Vertex neighbour,
			int weightOfEdge) {

		if (neighbour.getDistance() > firstVertex.getDistance() + weightOfEdge) {
			neighbour.setDistance(firstVertex.getDistance() + weightOfEdge);
			neighbour.setPredecessor(firstVertex);
			neighbour.setState(EndStateOfPoint.REACHABLE);
		}
	}

}
