package graph;

/**
 * Eine Klasse, die Knoten eines Graphen repr�sentiert
 * 
 * @author ripphausen
 * @version 1.0
 */
public class Vertex {

	private EndStateOfPoint state = EndStateOfPoint.UNREACHABLE;

	private int distance = Integer.MAX_VALUE;

	private Vertex predecessor;

	private int id;

	public Vertex(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public EndStateOfPoint getState() {
		return state;
	}

	public void setState(EndStateOfPoint state) {
		this.state = state;
	}

	public String toString() {
		return new Integer(id).toString();
	}
}