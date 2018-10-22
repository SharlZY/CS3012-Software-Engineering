import java.util.ArrayList;

public class DAG {
	private int V; // No. of vertices
	private ArrayList<Node> adj[]; // Adjacency Lists

	@SuppressWarnings("unchecked")
	DAG(int v) {
		setV(v);
		setAdj(new ArrayList[v]);
		for (int i = 0; i < v; ++i) {
			getAdj()[i] = new ArrayList<Node>(); // Array of arraylists
		}
	}

	boolean isEmpty() {
		if (getAdj().length == 0) {
			return true;
		} else {
			return false;
		}
	}

	boolean nodeExists(Node x) {
		for (int i = 0; i < getAdj().length; i++) {
			for (int j = 0; j < getAdj()[i].size(); j++) {
				if (getAdj()[i].get(j).equals(x)) {
					return true;
				}
			}
		}
		return false;
	}

	void addEdge(Node v, Node w) {
		getAdj()[v.intVal() - 1].add(w);
	}

	public ArrayList<Node>[] getAdj() {
		return adj;
	}

	public void setAdj(ArrayList<Node> adj[]) {
		this.adj = adj;
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}
}
