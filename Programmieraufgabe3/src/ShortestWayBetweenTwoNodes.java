import graph.Edge;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;

public class ShortestWayBetweenTwoNodes {

	private int startVertexID;
	private int destinationVertexID;
	private Graph<Vertex, Edge<Vertex>> graph;
	private ArrayList<Integer> listOfWayIDS;

	public ShortestWayBetweenTwoNodes(Graph<Vertex, Edge<Vertex>> graph,
			int startVertexID, int destinationVertexID) {
		this.startVertexID = startVertexID;
		this.destinationVertexID = destinationVertexID;
		this.graph = graph;
	}

	private ArrayList<Integer> idsList() {

		listOfWayIDS = new ArrayList<Integer>();
		if (startVertexID == destinationVertexID)
			return listOfWayIDS;

		int checkNodeID = destinationVertexID;
		while (checkNodeID != startVertexID) {
			// listOfWayIDS.add(checkNodeID);
			Vertex pred = graph.getVertex(checkNodeID);

			if (pred.getPredecessor() == null) {

				return listOfWayIDS;
			} else {
				checkNodeID = pred.getPredecessor().getId();
				listOfWayIDS.add(checkNodeID);
			}
		}
		return listOfWayIDS;

	}

	public String toString() {

		idsList();
		
		if (listOfWayIDS.size() != 0) {
			StringBuilder wayNodes = new StringBuilder();

			for (int i = listOfWayIDS.size() - 1; i >= 0; i--) {
				wayNodes.append(listOfWayIDS.get(i) + ", ");
			}
			return "The shortest way between " + startVertexID + " to "
					+ destinationVertexID + " is through nodes :  " + wayNodes
					+ destinationVertexID + " and Distance ist: "
					+ graph.getVertex(destinationVertexID).getDistance();
		} else {
			return "There is no way between " + startVertexID + " to "
					+ destinationVertexID;
		}
	}
}
