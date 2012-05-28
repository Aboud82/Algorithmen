import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;

/**
 * a class to save the properties (attributes) of a way between two vertices,
 * given in the constructor.
 * 
 * @author Aboud Chamoun
 * @author Martin Fleischer
 * @author Johannis Dirr
 * 
 */
public class WayBetweenTwoNodes {

	private int startVertexID;
	private int destinationVertexID;
	private Graph<Vertex, Edge<Vertex>> graph;
	private ArrayList<Integer> listOfWayIDS;

	public WayBetweenTwoNodes(Graph<Vertex, Edge<Vertex>> graph,
			int startVertexID, int destinationVertexID) {
		this.startVertexID = startVertexID;
		this.destinationVertexID = destinationVertexID;
		this.graph = graph;
	}

	/**
	 * to list the vertices on the way between the two vertices given in
	 * constructor
	 * 
	 * @return list of way vertices
	 */
	private ArrayList<Integer> idsList() {

		listOfWayIDS = new ArrayList<Integer>();
		if (startVertexID == destinationVertexID) {
			return listOfWayIDS;
		}

		// check id of type int, to check if the id of current vertice,starting
		// from
		// destination vertice of constructor , equals the id of start vertice
		// of constructor
		int checkNodeID = destinationVertexID;
		while (checkNodeID != startVertexID) {

			Vertex currentVertex = graph.getVertex(checkNodeID);

			// if there is no way to start vertice
			if (currentVertex.getPredecessor() == null) {

				return listOfWayIDS;
			} else {
				checkNodeID = currentVertex.getPredecessor().getId();
				listOfWayIDS.add(checkNodeID);
			}
		}
		return listOfWayIDS;

	}

	/**
	 * displays the properties of the way between two vertices
	 */
	@Override
	public String toString() {

		idsList();

		if (listOfWayIDS.size() != 0) {
			StringBuilder wayNodes = new StringBuilder();

			for (int i = listOfWayIDS.size() - 1; i >= 0; i--) {
				wayNodes.append(listOfWayIDS.get(i) + ", ");
			}
			return "The shortest way between " + startVertexID + " to "
					+ destinationVertexID + " is through nodes :  " + wayNodes
					+ destinationVertexID + " and Distance is: "
					+ graph.getVertex(destinationVertexID).getDistance();
		} else {
			return "There is no way between " + startVertexID + " to "
					+ destinationVertexID;
		}
	}
}
