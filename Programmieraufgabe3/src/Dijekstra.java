import graph.Edge;
import graph.EndStateOfPoint;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * a class to performe the Dijekstra algorithem
 * 
 * @author Aboud Chamoun
 * @author Martin Fleischer
 * @author Johannis Dirr
 * 
 */
public class Dijekstra {

	/**
	 * initializes the Dijekstra algorithem by setting the start vertice,
	 * setting a queue to help performing Dijekstra
	 * 
	 * @param graph
	 *            the graph in which the Dijekstra algorithem should be
	 *            performed
	 * @param startVertexID
	 *            the start vertice
	 * @param destinationVertexID
	 *            the end vertice
	 */
	public static void initializeDijekstra(Graph<Vertex, Edge<Vertex>> graph,
			int startVertexID, int destinationVertexID) {

		Vertex startVertex = graph.getVertex(startVertexID);
		startVertex.setDistance(0);
		startVertex.setPredecessor(startVertex);
		startVertex.setState(EndStateOfPoint.STARTPOINT);

		ArrayList<Vertex> queue = new ArrayList<Vertex>();
		queue.add(startVertex);

		prepareQueue(graph, startVertex, queue);
		performeDijekstra(graph, queue, startVertexID, destinationVertexID);

	}

	/**
	 * prepares the queue for Dijekstra, the neighbours of the vertice, given as
	 * parameter, will be sorted acsending in a SortedMap. the methode will be
	 * called recursively for each neighbour of vertice.
	 * 
	 * @param graph
	 *            a graph in which Dijekstra will be performed
	 * @param vertex
	 *            the vertice, whose neighbours will be taken
	 * @param queue
	 *            the queue to help performe Dijekstra
	 */
	static private void prepareQueue(Graph<Vertex, Edge<Vertex>> graph,
			Vertex vertex, ArrayList<Vertex> queue) {

		Collection<Edge<Vertex>> edges = graph.getIncidentEdges(vertex);

		// to sort the neighbouring vertices descending after thier weight,
		// ArrayList as value in case several edges have the same weight
		SortedMap<Integer, ArrayList<Vertex>> weightVertexMap = new TreeMap<Integer, ArrayList<Vertex>>();

		// initialize the SortedMap
		for (Edge<Vertex> egde : edges) {
			if (!weightVertexMap.containsKey(egde.getWeight())) {
				weightVertexMap.put(egde.getWeight(), new ArrayList<Vertex>());
			}
		}

		// write the vertices' id's in the ArrayList of the certian weight
		for (Edge<Vertex> egde : edges) {
			weightVertexMap.get(egde.getWeight()).add(egde.getVertexB());
		}

		// to add the missing neighbours, ascending after weight,to the queue
		for (Integer weight : weightVertexMap.keySet()) {
			ArrayList<Vertex> neighbours = weightVertexMap.get(weight);

			for (Vertex neighbour : neighbours) {

				if (!queue.contains(neighbour)) {
					queue.add(neighbour);

				}
			}
		}

		// to call prepareQueue ascending for each neighbour of vertice,given as
		// parameter
		for (Integer neighbourWeight : weightVertexMap.keySet()) {
			ArrayList<Vertex> neighbours = weightVertexMap.get(neighbourWeight);
			for (Vertex neighbour : neighbours) {
				prepareQueue(graph, neighbour, queue);
			}
		}
	}

	/**
	 * performs the Dijekstra algorithem
	 * 
	 * @param graph
	 *            a graph, in which the Dijekstra will be performed
	 * @param queue
	 *            a queue of vertices to help perform Dijekstra
	 * @param startVertexID
	 *            a start vertices id
	 * @param destinationVertexID
	 *            an end vertices id
	 */
	static private void performeDijekstra(Graph<Vertex, Edge<Vertex>> graph,
			ArrayList<Vertex> queue, int startVertexID, int destinationVertexID) {

		while (queue.size() != 0) {

			int lowest = 0;
			for (int i = 1; i < queue.size(); i++) {
				if (queue.get(i).getDistance() < queue.get(lowest)
						.getDistance()) {
					lowest = i;
				}
			}

			Vertex lowestElementInQueue = queue.get(lowest);
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
	 *            the first vertice
	 * @param neighbour
	 *            the neighbouring vertice of the first vertice
	 * @param weightOfEdge
	 *            the weight of the edge between the first vertice and the
	 *            neighbouring vertice
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
