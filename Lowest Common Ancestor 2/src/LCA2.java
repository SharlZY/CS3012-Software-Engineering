
public class LCA2 {
	private boolean[] marked = new boolean[7];
	private char[] edgeTo = new char[7];
	private int[] distTo = new int[7];

	public void bfs(Node src, DAG sample) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(src.intVal()-1);
		marked[src.intVal()-1] = true;
		distTo[src.intVal()-1] = 0;

		while (!q.isEmpty()) {
			int s = q.dequeue();
			for (Node w : sample.getAdj()[s]) {
				if (!marked[w.intVal()-1]) {
					q.enqueue(w.intVal()-1);
					marked[w.intVal()-1] = true;
					edgeTo[w.intVal()-1] = w.getValue();
					distTo[w.intVal()-1] = distTo[s] + 1;
				}
			}
		}
		for (int i = 0; i < edgeTo.length-1; i++) {
			System.out.println("EdgeTo: " + edgeTo[i] + " distTo: " + distTo[i]);
		}
	}
}
