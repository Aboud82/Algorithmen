package bsfUtil;

/**
 * This class represents the tree which is the result of BSF. nodes will be
 * persisted in a BreathSearchNode array
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 * @author Johannes Dirr
 * 
 */
public class BreathSearchFirstTree {
	BreathSearchNode[] bsfTree;

	/**
	 * constructor of a BreathSearchFirstTree
	 * 
	 * @param nodesNumber
	 *            number of nodes. will be equal to number of vertices
	 */
	public BreathSearchFirstTree(int nodesNumber) {
		bsfTree = new BreathSearchNode[nodesNumber];
		for (int i = 0; i < bsfTree.length; i++) {
			bsfTree[i] = new BreathSearchNode();
		}
	}

	/**
	 * sets a node at specified index
	 * 
	 * @param index
	 *            the index
	 * @param node
	 *            to add
	 * @return true if node has been added
	 */
	public boolean setBsfNode(int index, BreathSearchNode node) {
		if (index < 0 || index >= bsfTree.length) {
			return false;
		}
		bsfTree[index] = node;
		return true;
	}

	/**
	 * returns the node at specified index
	 * 
	 * @param index
	 *            the index of the node
	 * @return node at given index
	 */
	public BreathSearchNode getBsfNode(int index) {
		if (index < 0 || index >= bsfTree.length) {
			return null;
		}
		return bsfTree[index];
	}

	/**
	 * prints the tree
	 */
	public void printBsfTree() {
		this.toString();
	}

	/**
	 * returns the number of nodes of the tree
	 * 
	 * @return number of nodes of the tree
	 */
	public int size() {
		return bsfTree.length;
	}

	@Override
	public String toString() {
		StringBuilder bsfTreeAsString = new StringBuilder();
		for (int i = 0; i < bsfTree.length; i++) {
			BreathSearchNode node = bsfTree[i];
			bsfTreeAsString.append(i + ":" + node.toString() + "\n");
		}
		return bsfTreeAsString.toString();
	}
}
