package bsfUtil;

import graph.Vertex;

import java.util.Collection;
import java.util.LinkedList;

/**
 * This class represents a path between two vertices including start and goal
 * vertices
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 * @author Johannes Dirr
 * 
 */
public class VerticesPath {

	Collection<Vertex> verticesPath = new LinkedList<Vertex>();

	/**
	 * Default constructor for VerticesPath
	 */
	public VerticesPath() {

	}

	/**
	 * prints the vertices path
	 */
	public void printVerticesPath() {
		System.out.println(this.toString());
	}

	/**
	 * adds the given vertex to path
	 * 
	 * @param vertex
	 *            returns given vertex to add
	 * @return true if vertex has been added
	 */
	public boolean add(Vertex vertex) {
		return verticesPath.add(vertex);
	}

	/**
	 * adds the given vertex to path at first index
	 * 
	 * @param vertex
	 *            given vertex to add
	 */
	public void addFirst(Vertex vertex) {
		((LinkedList<Vertex>) verticesPath).addFirst(vertex);
	}

	@Override
	public String toString() {
		StringBuilder verticesPathAsString = new StringBuilder();
		for (int i = 0; i < verticesPath.size(); i++) {
			if (i == (verticesPath.size() - 1)) {
				verticesPathAsString.append(((LinkedList<Vertex>) verticesPath)
						.get(i).toString());
			} else {
				verticesPathAsString.append(((LinkedList<Vertex>) verticesPath)
						.get(i).toString() + "->");
			}
		}

		return verticesPathAsString.toString();
	}
}
