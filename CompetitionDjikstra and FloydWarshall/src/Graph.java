import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {

	public EdgeNode[] edges;
	private int nvertices, nedges;// number of vertices and edges
	private int maxSize;// max number of vertices
	private boolean[] processed;
	private int[] parents;
	private double[] distTo;
	private BinaryHeap pq;


	public Graph(File points) {
		Scanner input;
		try {
			input = new Scanner(points);
			this.nvertices = input.nextInt();
			this.maxSize = this.nvertices;
			this.nedges = input.nextInt();
			this.edges = new EdgeNode[nvertices];
			this.pq = new BinaryHeap(nedges);
			this.distTo = new double[nvertices];
			this.processed = new boolean[nvertices];
			this.parents = new int[nvertices];
			int x;
			int y;
			double dist;
			for (int i = 0; i < this.nedges; i++) {
				x = input.nextInt();
				y = input.nextInt();
				dist = input.nextDouble();
				addEdge(x, y, dist);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public void addEdge(int x, int y, double weight) {
		EdgeNode tmp = new EdgeNode(y, weight);
//		if (this.edges[x] == null && this.edges[y] == null && !fromFile) nvertices++;
//		if(!fromFile) nedges++;
		tmp.next = this.edges[x];
		this.edges[x] = tmp;
	}

	private void Djikstra(int start) {
		initSearch();
		int y; // child points on graph
		this.distTo[start] = 0.0;
		pq.insert(this.distTo[start], start);
		while (!pq.isEmpty()) {
			y = pq.delMin();
			relax(y);
		}
	}

	private void relax(int v) {
		for (EdgeNode tmp = this.edges[v]; tmp != null; tmp = tmp.next) {
			if (this.distTo[tmp.y] > this.distTo[v] + tmp.weight) {
				this.distTo[tmp.y] = this.distTo[v] + tmp.weight;
				parents[tmp.y] = v;
				pq.insert(this.distTo[tmp.y], tmp.y);
			}
		}
		processed[v] = true;
	}

	private void initSearch() {
		pq = new BinaryHeap(nedges);
		distTo = new double[nvertices];
		processed = new boolean[nvertices];
		parents = new int[nvertices];
		for (int i = 0; i < maxSize; i++) {
			this.distTo[i] = Double.POSITIVE_INFINITY;
			this.processed[i] = false;
			this.parents[i] = -1;
		}
	}

	public double getMaxDist(int start) {
		Djikstra(start);
		double maxDist = 0;
		for (int i = 0; i < nvertices; i++) {
			maxDist = Math.max(maxDist, distTo[i]);
		}
		return maxDist;
	}

	public int getNVertices() {
		return nvertices;
	}

	public boolean isEmpty() {
		return nvertices == 0;
	}

	// checking if graph contains an edge
	public boolean contains(int x, int y, double weight) {
		if (x < maxSize) {
			for (EdgeNode tmp = edges[x]; tmp != null; tmp = tmp.next) {
				if ((tmp.y == y) && (tmp.weight == weight))
					return true;
			}
		}
		return false;
	}


}
