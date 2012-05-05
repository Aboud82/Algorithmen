import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class BreadthFirstSearch {

	/**
	 * 
	 * @param graph
	 *            the given graph
	 * @param vertexIndex
	 *            the index of the vertex for shortest path
	 * @return a Collection with ArrayLists for each vertex of the given graph.
	 *         Each ArrayList represents the shortest path/paths from
	 *         vertexIndex to vertex at the Collection's index
	 */
	public static Collection<ArrayList<Vertex>> getShortestDistanceFor(
			Graph<Vertex, Edge<Vertex>> graph, int vertexIndex) {
		// validates params
		if (graph == null || vertexIndex < 0
				|| vertexIndex >= graph.getNumberVertices()) {
			throw new IllegalArgumentException();
		}

		Collection<Vertex> verticesPath = new LinkedList<Vertex>();
		// TODO
		return null;
	}

	/**
	 * 
	 * @param graph
	 *            the given graph
	 * @param vertexIndex1
	 *            first index of vertex for shortest path
	 * @param vertexIndex2
	 *            second index of vertex for shortest path
	 * @return HashMap with two entries. One for path from vertexIndex1 (at
	 *         index 0) to vertexIndex2 (at index 1), the other one for the
	 *         inverse path. The ArrayList of the HashMap contains an ArrayList
	 *         of vertices, which represents the path between, for the
	 *         path/paths with shortest distance
	 */
	public static HashMap<Integer, ArrayList<ArrayList<Vertex>>> getShortestPathBetween(
			Graph<Vertex, Edge<Vertex>> graph, int vertexIndex1,
			int vertexIndex2) {
		// validates params
		if (graph == null || vertexIndex1 < 0
				|| vertexIndex1 >= graph.getNumberVertices()
				|| vertexIndex2 < 0
				|| vertexIndex2 >= graph.getNumberVertices()) {
			throw new IllegalArgumentException();
		}

		// TODO
		return null;
	}

	private static boolean breadthFirstSearch() {
		// TODO
		return false;
	}
}
