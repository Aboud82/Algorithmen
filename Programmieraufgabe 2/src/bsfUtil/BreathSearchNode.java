package bsfUtil;

import graph.Vertex;

/**
 * This class represents an node of the BSF Tree with dist for distance to start
 * vertex, pred for predecessor of the path from first vertex and col for color,
 * which represents the state during BSF
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 * @author Johannes Dirr
 * 
 */
public class BreathSearchNode {
	private int dist;
	private Vertex pred;
	private Color col;

	/**
	 * default constructor generates an unvisited BreathSearchNode with distance
	 * MAX_INT and no predecessor
	 */
	public BreathSearchNode() {
		this.dist = Integer.MAX_VALUE;
		this.pred = null;
		this.col = Color.WHITE;
	}

	/**
	 * generates an BreathSearchNode with given values
	 * 
	 * @param dist
	 *            distance to first node
	 * @param pred
	 *            predecessor vertex
	 * @param col
	 *            Color of the node
	 */
	public BreathSearchNode(int dist, Vertex pred, Color col) {
		this.dist = dist;
		this.pred = pred;
		this.col = col;
	}

	/**
	 * 
	 * @return distance to first node
	 */
	public int getDist() {
		return dist;
	}

	/**
	 * 
	 * @param dist
	 *            to first node
	 */
	public void setDist(int dist) {
		this.dist = dist;
	}

	/**
	 * 
	 * @return predecessor of the node
	 */
	public Vertex getPred() {
		return pred;
	}

	/**
	 * 
	 * @param pred
	 *            predecessor of the node
	 */
	public void setPred(Vertex pred) {
		this.pred = pred;
	}

	/**
	 * 
	 * @return color of the node
	 */
	public Color getCol() {
		return col;
	}

	/**
	 * 
	 * @param col
	 *            color of the node
	 */
	public void setCol(Color col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return "[dist=" + dist + ", pred=" + pred + ", col=" + col + "]";
	}
}
