import java.util.ArrayList;
public class DAG {
	private int V;   // No. of vertices 
    private ArrayList<Node> adj[]; //Adjacency Lists 
  
    // Constructor 
    @SuppressWarnings("unchecked")
	DAG(int v){ 
        setV(v); 
        setAdj(new ArrayList[v]); 
        for (int i=0; i<v; ++i){ 
            getAdj()[i] = new ArrayList<Node>(); // Array of arraylists
        }    
    } 
  
    // Function to add an edge into the graph 
    void addEdge(Node v,Node w) 
    { 
        getAdj()[v.intVal()-1].add(w); 
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
