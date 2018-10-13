
public class LCA2 {
	public void findLCA(){
		
	}
	public char cmpAncestorLists(){
		char common = ' ';
		return common;
	}
	public void bfs(Node src, DAG sample) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(src.intVal()-1);
		src.marked[src.intVal()-1] = true;
		src.distTo[src.intVal()-1] = 0;

		while (!q.isEmpty()) {
			int s = q.dequeue();
			for (Node w : sample.getAdj()[s]) {
				if (!src.marked[w.intVal()-1]) {
					q.enqueue(w.intVal()-1);
					src.marked[w.intVal()-1] = true;
					src.edgeTo[w.intVal()-1] = w.getValue();
					src.distTo[w.intVal()-1] = src.distTo[s] + 1;
				}
			}
		}
		for (int i = 0; i < src.edgeTo.length-1; i++) {
			System.out.println("EdgeTo: " + src.edgeTo[i] + " distTo: " + src.distTo[i]);
		}
	}
}
