package oo;

import graph.Edge;
import graph.Graph;
import graph.GraphLesen;
import graph.Vertex;

import java.awt.Container;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This class runs the program. Pass index of vertex for BSF,index of vertex to
 * get path to and boolean if graph should be directed in main call doBsfFor, to
 * get the results of the BSF
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 * @author Johannes Dirr
 * 
 */
public class BreadthFirstSearchRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// first param index of vertex for BSF
		// second param index of vertex to get path to
		// third param if graph should be directed
		doBsfFor(5, 2, true);

	}

	/**
	 * prints the result of BSF
	 * 
	 * @param graph
	 *            the graph for the BSF
	 * @param vertexIndex
	 *            start vertex for BSF
	 * @param goalVertexIndex
	 *            vertex to get path between
	 */
	private static void printBSF(Graph<Vertex, Edge<Vertex>> graph,
			int vertexIndex, int goalVertexIndex) {

		// prints the graph
		System.out.println(graph.toString());

		// prints the BSF tree
		System.out.println("BSF Tree for vertex" + vertexIndex + ":");
		System.out.println(BreadthFirstSearch.breadthFirstSearch(vertexIndex,
				graph).toString());

		// prints the shortest distances
		System.out.println("Shortest distances to other vertices from vertex"
				+ vertexIndex + ":");
		BreadthFirstSearch.getShortestDistancesFor(graph, vertexIndex);

		// prints shortest path between
		System.out.println();
		BreadthFirstSearch.getShortestPathBetween(graph, vertexIndex,
				goalVertexIndex);
	}

	/**
	 * creates and shows the filechooser
	 * 
	 * @param vertexIndex
	 *            index of vertex for BSF
	 * @param goalVertexIndex
	 *            index of vertex to get path to
	 * @param isDirected
	 *            pass true if graph should be directed
	 */
	private static void doBsfFor(int vertexIndex, int goalVertexIndex,
			boolean isDirected) {

		// creating JFileChooser to select graph
		JFileChooser chooser = new JFileChooser("./src/graphBeispiele/");
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
			graph = GraphLesen.FileToGraph(file.getAbsolutePath(), isDirected);
			// print BFS result
			printBSF(graph, vertexIndex, goalVertexIndex);
		}
	}
}
