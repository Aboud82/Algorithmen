package oo;
import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

import bsfUtil.BreathSearchFirstTree;
import bsfUtil.BreathSearchNode;
import bsfUtil.Color;
import bsfUtil.VerticesPath;

/**
 * This class holds the main functions of BFS. The static methods return the
 * results of BFS.
 * 
 * getShortestDistancesFor: prints and returns the distances of all vertices to
 * the vertex at given index in given graph
 * 
 * getShortestPathBetween: prints and returns the path from given index of goal
 * vertex to given index of end vertex in given graph
 * 
 * breadthFirstSearch: returns the BSF Tree for given vertex in given path
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 * @author Johannes Dirr
 * 
 */
public class BreadthFirstSearch {

	/**
	 * prints and returns the shortest distances from vertex at given index to
	 * all vertices
	 * 
	 * @param graph
	 *            the graph of the vertices
	 * @param vertexIndex
	 *            index of vertex to get distances for
	 * @return SortedMap with vertexID as key and distance as value
	 */
	public static SortedMap<Integer, Integer> getShortestDistancesFor(
			Graph<Vertex, Edge<Vertex>> graph, int vertexIndex) {
		// validates params
		if (graph == null || vertexIndex < 0
				|| vertexIndex >= graph.getNumberVertices()) {
			throw new IllegalArgumentException();
		}
		// SortedMap to fill
		SortedMap<Integer, Integer> distances = new TreeMap<Integer, Integer>();

		// generating BSF-Tree for vertex with vertexIndex
		BreathSearchFirstTree bsfTree = breadthFirstSearch(vertexIndex, graph);

		// fills SortedMap
		for (int i = 0; i < bsfTree.size(); i++) {
			Vertex vertex = graph.getVertex(i);
			int vertexID = vertex.getId();
			int distance = bsfTree.getBsfNode(i).getDist();
			distances.put(vertexID, distance);
		}

		// prints result
		printDistances(vertexIndex, distances);

		return distances;
	}

	/**
	 * prints the distances calculated in getShortestDistancesFor
	 * 
	 * @param vertexIndex
	 *            index of start vertex
	 * @param distances
	 *            from start vertex to all vertices
	 */
	private static void printDistances(int vertexIndex,
			SortedMap<Integer, Integer> distances) {
		for (Integer vertexID : distances.keySet()) {
			System.out.print("Distance between vertex" + vertexIndex
					+ "->vertex" + vertexID + " : ");
			if (distances.get(vertexID) == Integer.MAX_VALUE) {
				System.out.print("not reachable");
			} else {
				System.out.print(distances.get(vertexID));
			}
			System.out.println();
		}
	}

	/**
	 * calculates the shortest path between two vertices an returns it as
	 * VerticesPath
	 * 
	 * @param graph
	 *            the graph with the vertices
	 * @param vertexIndex1
	 *            index of start vertex
	 * @param vertexIndex2
	 *            index of goal index
	 * @return VerticesPath between vertex at vertexIndex1 and vertex at
	 *         vertexIndex2
	 */
	public static VerticesPath getShortestPathBetween(
			Graph<Vertex, Edge<Vertex>> graph, int vertexIndex1,
			int vertexIndex2) {
		// validates params
		if (graph == null || vertexIndex1 < 0
				|| vertexIndex1 >= graph.getNumberVertices()
				|| vertexIndex2 < 0
				|| vertexIndex2 >= graph.getNumberVertices()) {
			throw new IllegalArgumentException();
		}

		// generating BSF-Tree for vertex with vertexIndex1
		BreathSearchFirstTree bsfTree = breadthFirstSearch(vertexIndex1, graph);

		// end of path
		Vertex goalVertex = graph.getVertex(vertexIndex2);
		Vertex vertex = goalVertex;

		// creating the vertices path
		VerticesPath path = new VerticesPath();
		path.addFirst(goalVertex);

		// while first vertex has not been reached
		while (true) {
			int vertexID = vertex.getId();
			Vertex pred = bsfTree.getBsfNode(vertexID).getPred();

			// if has first vertex been reached
			if (pred == null) {
				break;
			} else {
				// add vertex to path
				path.addFirst(pred);
				int predID = pred.getId();
				vertex = graph.getVertex(predID);
			}
		}

		// prints result
		printVerticesPath(graph, vertexIndex1, vertexIndex2, path);

		return path;
	}

	/**
	 * prints the VerticesPath calculated in getShortestPathBetween
	 * 
	 * @param graph
	 *            the graph of the vertices
	 * @param vertexIndex1
	 *            index of start vertex
	 * @param vertexIndex2
	 *            index of goal vertex
	 * @param path
	 *            the calculated path between the two vertices
	 */
	private static void printVerticesPath(Graph<Vertex, Edge<Vertex>> graph,
			int vertexIndex1, int vertexIndex2, VerticesPath path) {
		System.out.print("Path between vertex" + graph.getVertex(vertexIndex1)
				+ " and vertex" + graph.getVertex(vertexIndex2) + " : ");
		path.printVerticesPath();
	}

	/**
	 * the BSF algorithm. Generates the BSF Tree for vertex at given index of
	 * given graph.
	 * 
	 * 
	 * @param startVertexIndex
	 *            index of vertex to get tree for
	 * @param graph
	 *            the graph of the vertex
	 * @return BreathSearchFirstTree for vertex at given index
	 */
	public static BreathSearchFirstTree breadthFirstSearch(
			int startVertexIndex, Graph<Vertex, Edge<Vertex>> graph) {

		int verticesNumber = graph.getVertices().size();
		// Initializes the tree with unvisited nodes. One for each vertex of the
		// graph
		BreathSearchFirstTree bsfTree = new BreathSearchFirstTree(
				verticesNumber);

		// the first BreathSearchNode with dist = 0, pred = null and col = GREY
		BreathSearchNode firstBreathSearchNode = new BreathSearchNode(0, null,
				bsfUtil.Color.GREY);
		bsfTree.setBsfNode(startVertexIndex, firstBreathSearchNode);

		Queue<Vertex> queue = new LinkedList<Vertex>();
		// enqueue first node
		queue.add(graph.getVertex(startVertexIndex));

		// queue not empty
		while (queue.size() != 0) {
			// dequeue
			Vertex vertex = queue.remove();
			int vertexID = vertex.getId();

			// indexing all neighbours of current node
			for (Vertex neighbour : graph.getNeighbours(vertex)) {
				Color colNeighbour = bsfTree.getBsfNode(neighbour.getId())
						.getCol();

				// if node has not already been visited
				if (colNeighbour == Color.WHITE) {
					int neighbourID = neighbour.getId();

					// distance of the node's predecessor + 1
					int predDist = bsfTree.getBsfNode(vertexID).getDist();

					BreathSearchNode visitedBreathSearchNode = new BreathSearchNode(
							predDist + 1, vertex, Color.GREY);
					// sets the current founded node
					BreathSearchNode node = visitedBreathSearchNode;

					bsfTree.setBsfNode(neighbourID, node);
					// enqueue the new node
					queue.add(graph.getVertex(neighbourID));
				}
			}
			// sets color of the node BLACK because all neighbours have been
			// visited now
			bsfTree.getBsfNode(vertexID).setCol(Color.BLACK);
		}

		// returns the result of the BSF algorithm
		return bsfTree;
	}
}
