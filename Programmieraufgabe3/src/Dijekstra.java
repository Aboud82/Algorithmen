import graph.Edge;
import graph.EndStateOfPoint;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

public class Dijekstra {

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

	static private void prepareQueue(Graph<Vertex, Edge<Vertex>> graph,
			Vertex vertex, ArrayList<Vertex> queue) {

		Collection<Edge<Vertex>> edges = graph.getIncidentEdges(vertex);

		SortedMap<Integer, Vertex> weightVertexMap = new TreeMap<Integer, Vertex>();
		for (Edge<Vertex> edge : edges) {
			weightVertexMap.put(edge.getWeight(), edge.getVertexB());
		}

		for (Integer weight : weightVertexMap.keySet()) {
			Vertex neighbour = weightVertexMap.get(weight);
			if (!queue.contains(neighbour)) {
				queue.add(neighbour);
				
			}
		}
		for (Integer neighbourWeight : weightVertexMap.keySet()) {
			Vertex neighbour = weightVertexMap.get(neighbourWeight);
			prepareQueue(graph, neighbour, queue);
		}
	}

	static private void performeDijekstra(Graph<Vertex, Edge<Vertex>> graph,
			ArrayList<Vertex> queue, int startVertexID, int destinationVertexID) {
		while (queue.size() != 0) {
			Vertex firstElementInQueue = queue.get(0);
			queue.remove(firstElementInQueue);

			Collection<Edge<Vertex>> edgesOfFirstVertex = graph
					.getIncidentEdges(firstElementInQueue);
			if (edgesOfFirstVertex.size() != 0) {
				for (Edge<Vertex> edge : edgesOfFirstVertex) {
					Vertex neighbour = edge.getVertexB();
					int weightOfEdge = edge.getWeight();
					if (weightOfEdge < 0) {
						throw new IllegalArgumentException("one edge of "
								+ firstElementInQueue.getId() + " is negative");

					}

					relax(firstElementInQueue, neighbour, weightOfEdge);
				}
			}
		}

		ResultsDisplay.printResults(graph);
		ResultsDisplay.printTheShortestWay(graph, startVertexID,
				destinationVertexID);
	}

	static private void relax(Vertex firstVertex, Vertex neighbour,
			int weightOfEdge) {

		if (neighbour.getDistance() > firstVertex.getDistance() + weightOfEdge) {
			neighbour.setDistance(firstVertex.getDistance() + weightOfEdge);
			neighbour.setPredecessor(firstVertex);
			neighbour.setState(EndStateOfPoint.REACHABLE);
		}
	}

}
