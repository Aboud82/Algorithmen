import graph.Edge;
import graph.Graph;
import graph.GraphLesen;
import graph.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * @author Aboud Chamoun
 * @euthor Martin Fleischer
 * @author Johannis Dirr
 * 
 */
public class BreadthFirst<V extends Vertex, E extends Edge<V>> {

	/**
	 * @param <V>
	 * @param args
	 */
	// a Graph to be edited.
	static private Graph<Vertex, Edge<Vertex>> graph;

	/*
	 * A Hashmap to save the whole vertices and their properties : color,
	 * distance, predecessor. the key is the id of the vertex. the value is an
	 * Arraylist, in which the three properties will be saved as follows: in
	 * index 0 the value color. in index 1 the value distance. in index 2 the
	 * value predecessor.
	 */
	private static HashMap<Integer, ArrayList> verticesMap = new HashMap<Integer, ArrayList>();



	// Arraylist to perform the Bread first search.
	private static ArrayList<Vertex> queue = new ArrayList<Vertex>();

	// Method to read the dat file and make a Graph.
	static private void getGraph() {
		graph = GraphLesen.FileToGraph("src/graphBeispiele/graph8.txt", true);

	}

	/*
	 * A methode to initialize the HashMap with default values before performing
	 * the breadth first search.
	 */
	private static void fillThemHashmap() {
		 ArrayList<Vertex> vertices = (ArrayList<Vertex>) graph.getVertices();

		ArrayList initialPropertiers = new ArrayList(Arrays.asList("white", 0,
				"none"));

		for (Vertex v : vertices) {
			verticesMap.put(v.getId(), initialPropertiers);
		}
	}

	/*
	 * Methode to initilize the Breadth first search by setting the start point
	 * to search.
	 * 
	 * @param StartVertexID sets the start point's id of the search.
	 */

	private static void initilizeBreadFirstSearch(int startVertexID) {

		Vertex startNode = graph.getVertex(startVertexID);

		verticesMap.put(startVertexID,
				new ArrayList(Arrays.asList("gray", 0, "start point")));

		// appends the start vertex to the queue.
		queue.add(startNode);

	}

	/*
	 * Methode to performe the Breadth first search
	 */
	private static void performBreadthFirstSearch() {

		while (queue.size() != 0) {

			Vertex firstVertexInQueue = queue.get(0);
			LinkedList<Vertex> neighboursOfFirstVertexInQueue = (LinkedList<Vertex>) graph
					.getNeighbours(firstVertexInQueue.getId());

			dequeue();

			if (neighboursOfFirstVertexInQueue.size() != 0) {
				for (Vertex v : neighboursOfFirstVertexInQueue) {

					int neighbourVertexID = v.getId();
					String colorOfNode = (String) verticesMap.get(
							neighbourVertexID).get(0);

					int weightOfEdge = calculateWeightOfWay(firstVertexInQueue,
							v);

					if (colorOfNode.equals("white")) {

						verticesMap.put(
								neighbourVertexID,
								new ArrayList(Arrays.asList("gray",
										weightOfEdge, firstVertexInQueue)));

						enqueue(v);
					}
				}

			}
			verticesMap.get(firstVertexInQueue.getId()).remove(0);
			verticesMap.get(firstVertexInQueue.getId()).add(0, "black");
		}
	}

	/*
	 * Methode to calculate a weight for a way to the start point , it can be
	 * one edge or a couple of edges
	 */
	private static int calculateWeightOfWay(Vertex firstVertex,
			Vertex secondVertex) {

		int currentWeight = (Integer) verticesMap.get(firstVertex.getId()).get(
				1);

		ArrayList<Edge<Vertex>> edgesOfFirstVertex = (ArrayList<Edge<Vertex>>) graph
				.getIncidentEdges(firstVertex.getId());

		for (Edge<Vertex> e : edgesOfFirstVertex) {
			if (e.getVertexB().getId() == secondVertex.getId()) {
				int edgeWeightBetweenFirstandSecond = e.getWeight();
				return edgeWeightBetweenFirstandSecond + currentWeight;
			}
		}
		System.out.println("no edge weight found");
		return 0;
	}

	/*
	 * to append a Vertex to the queue
	 */
	private static void enqueue(Vertex v) {
		queue.add((Vertex) v);

	}

	/*
	 * to delete the first vertex from the queue
	 */
	private static void dequeue() {
		queue.remove(0);

	}

	public static void main(String[] args) {

		getGraph();
		fillThemHashmap();
		initilizeBreadFirstSearch(5);
		performBreadthFirstSearch();
		displayConclusion();

	}

	/*
	 * Methode to display the conclusion of the search for the shortest way
	 */
	private static void displayConclusion() {
		System.out.println(verticesMap.keySet().toString());

		System.out.println("order of values:   color, weight ,predecessor");
		System.out.println("values of node index 0 :" + verticesMap.get(0));
		System.out.println("values of node index 1 :" + verticesMap.get(1));
		System.out.println("values of node index 2 :" + verticesMap.get(2));
		System.out.println("values of node index 3 :" + verticesMap.get(3));
		System.out.println("values of node index 4 :" + verticesMap.get(4));
		System.out.println("values of node index 5 :" + verticesMap.get(5));
		System.out.println("values of node index 6 :" + verticesMap.get(6));
		System.out.println("values of node index 7 :" + verticesMap.get(7));
	}

}
