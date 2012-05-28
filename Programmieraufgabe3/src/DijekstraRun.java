import graph.Edge;
import graph.Graph;
import graph.GraphLesen;
import graph.Vertex;

import java.awt.Container;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * this class runs the Dijekstra algorithem.
 * 
 * 
 * @author Martin Fleicher
 * @author Aboud Chamoun
 * @author Johannis Dirr
 * 
 */
public class DijekstraRun {

	/**
	 * @param <E>
	 * @param args
	 */

	/**
	 * creates and shows the filechooser, loads the chosen graph
	 * 
	 * @param graphDirection
	 *            pass true if graph should be directed
	 * 
	 * 
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

	/**
	 * finds the shortest way between two vertices
	 * 
	 * @param startVertexID
	 *            the start vertice
	 * @param destinationVertexID
	 *            the end vertice
	 * @param isDirected
	 *            pass true if graph should be directed
	 */
	private static void findWaysBetweenTheTwoVertices(int startVertexID,
			int destinationVertexID, boolean isDirected) {

		Graph<Vertex, Edge<Vertex>> graph = loadGraph(isDirected);
		Dijekstra
				.initializeDijekstra(graph, startVertexID, destinationVertexID);

	}

	public static void main(String[] args) {
		// first param is the start vertice
		// second param is the end vertice
		// third param if the graph is directed
		findWaysBetweenTheTwoVertices(0, 5, true);

	}

}
