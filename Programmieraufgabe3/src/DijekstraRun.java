import graph.Edge;
import graph.Graph;
import graph.GraphLesen;
import graph.Vertex;

import java.awt.Container;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DijekstraRun {

	/**
	 * @param <E>
	 * @param args
	 */

	private static Graph<Vertex, Edge<Vertex>> loadGraph(boolean graphDirection) {
		// creating JFileChooser to select graph
		JFileChooser chooser = new JFileChooser("./src/graphenExamples/");
		// only searching for txt files
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Graph in txt format", "txt");
		chooser.setFileFilter(filter);

		// opens JFileChooser dialog and reads selected graph
		int returnVal = chooser.showOpenDialog(new Container());
		File file;
		Graph<Vertex, Edge<Vertex>> graph = null;

		// if a file was selected
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// sets selected file
			file = chooser.getSelectedFile();
			// reads graph from file
			graph = GraphLesen.FileToWeightedGraph(file.getAbsolutePath(),
					graphDirection);
		}
		return graph;

	}

	private static void findWaysBetweenTheTwoVertices(int startVertexID,
			int destinationVertexID, boolean isDirected) {
		
		Graph<Vertex, Edge<Vertex>> graph = loadGraph(isDirected);
		Dijekstra.initializeDijekstra(graph, startVertexID, destinationVertexID);
		

		// print BFS result
		// printBSF(graph, vertexIndex, goalVertexIndex);

	}

	public static void main(String[] args) {
		findWaysBetweenTheTwoVertices(3, 0, true);
		// Graph<Vertex, Edge<Vertex>> graph = GraphLesen.FileToWeightedGraph(
		// "src/graphenExamples/graphwsu.txt", true);
		//
		// Collection<Edge<Vertex>> edgaes = (Collection<Edge<Vertex>>) graph
		// .getEdges();
		// for (Edge<Vertex> edge : edgaes) {
		// System.out.println("v " + edge.getVertexA() + ", u "
		// + edge.getVertexB() + ", weight " + edge.getWeight());
		// }

	}

}
