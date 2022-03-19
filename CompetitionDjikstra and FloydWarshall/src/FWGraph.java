import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FWGraph {
	private double[][] adjList;
	private int nvertices, nedges;// number of vertices and edges
	private int maxSize;// max number of vertices
	private boolean[][] routePossible;// route possible

	public FWGraph(File points) {
		Scanner input;
		try {
			input = new Scanner(points);
			this.nvertices = input.nextInt();
			this.maxSize = this.nvertices;
			this.nedges = input.nextInt();
			this.adjList = new double[maxSize][maxSize];
			this.routePossible = new boolean[maxSize][maxSize];
//			this.fromFile = true;
			int x;
			int y;
			double dist;
			for (int i = 0; i < this.nvertices; i++)
				for (int j = 0; j < this.nvertices; j++) {
					adjList[i][j] = Double.POSITIVE_INFINITY;
					routePossible[i][j] = false;
				}
			for (int i = 0; i < this.nvertices; i++) {
				adjList[i][i] = 0;
			}
			for (int i = 0; i < this.nedges; i++) {
				x = input.nextInt();
				y = input.nextInt();
				dist = input.nextDouble();
				addEdge(x, y, dist);
			}
			floydWarshall();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void addEdge(int x, int y, double weight) {
		adjList[x][y] = weight;
		routePossible[x][y] = true;
	}

	public void floydWarshall() {
		for (int i = 0; i < maxSize; i++)
			for (int j = 0; j < maxSize; j++)
				for (int k = 0; k < maxSize; k++) {
					if ((adjList[j][k] > (adjList[j][i] + adjList[i][k]))) {
						adjList[j][k] = (adjList[j][i] + adjList[i][k]);
						routePossible[i][k] = true;
					}
				}
	}

	public double getMaxDistance() {
		double max = 0;
		for (int i = 0; i < maxSize; i++)
			for (int j = 0; j < maxSize; j++)
				max = Math.max(max, adjList[i][j]);

		return max;
	}

	public int getNVertices() {
		return nvertices;
	}

	public boolean isEmpty() {
		return nvertices == 0;
	}

	public boolean contains(int x, int y, double weight) {
		return adjList[x][y] == weight;
	}

}
