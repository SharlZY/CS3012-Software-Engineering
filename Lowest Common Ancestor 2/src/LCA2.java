
public class LCA2 {
	public char findLCA(Node x, Node y, DAG graph) {
		char common = ' ';
		if (!graph.nodeExists(x) && !graph.nodeExists(y) || graph.isEmpty()) {
			return common;
		} else {
			bfs(x, graph);
			bfs(y, graph);
			common = cmpAncestorLists(x, y);
			return common;
		}
	}

	public char cmpAncestorLists(Node x, Node y) {
		int min = 1;
		boolean isFound = false;
		if (x.distTo[y.intVal() - 1] != -1) { // if the LCA is one of the nodes
												// itself
			return y.getValue();
		} else if (y.distTo[x.intVal() - 1] != -1) { // check other node
			return x.getValue();
		} else {
			while (isFound == false) {
				for (int i = 0; i < x.distTo.length; i++) { // else if its not,
															// check for the
															// shortest dist,
															// incrementing min
															// till we find a
															// value in the
															// other list that
															// isnt -1
					if (x.distTo[i] == min) {
						if (y.distTo[i] != -1) {
							return y.edgeTo[i];
						}
					}
				}
				min++;
			}
		}
		return ' ';
	}

	public void bfs(Node src, DAG sample) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(src.intVal() - 1);
		src.marked[src.intVal() - 1] = true;
		src.distTo[src.intVal() - 1] = 0;

		while (!q.isEmpty()) {
			int s = q.dequeue();
			for (Node w : sample.getAdj()[s]) {
				if (!src.marked[w.intVal() - 1]) {
					q.enqueue(w.intVal() - 1);
					src.marked[w.intVal() - 1] = true;
					src.edgeTo[w.intVal() - 1] = w.getValue();
					src.distTo[w.intVal() - 1] = src.distTo[s] + 1;
				}
			}
		}
		/*
		 * for(int i = 0; i < src.distTo.length; i++ ){
		 * System.out.println("Src: " + src.getValue() + " Dist: " +
		 * src.distTo[i]); }
		 */
	}
}
