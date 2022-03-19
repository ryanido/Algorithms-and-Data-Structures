import java.io.File;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */

public class CompetitionFloydWarshall {
	public FWGraph city;
	// speeds
	public int sA;
	public int sB;
	public int sC;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA,       sB, sC: speeds for 3 contestants
	 */
	CompetitionFloydWarshall(String filename, int sA, int sB, int sC) {
		if (filename == null) return;
		File file = new File(filename);
		this.city = new FWGraph(file);
		this.sA = sA;
		this.sB = sB;
		this.sC = sC;
	}

	/**
	 * @return int: minimum minutes that will pass before the three contestants can
	 *         meet
	 */
	public int timeRequiredforCompetition() {
		if ((sA <= 100 && sA >= 50) && (sB <= 100 && sB >= 50) && (sC <= 100 && sC >= 50) && !city.isEmpty()) {
			double maxDist = city.getMaxDistance();
			if (maxDist == Double.POSITIVE_INFINITY)
				return -1;
			int slowestSpeed = Math.min(Math.min(sA, sB), sC);
			return (int) Math.ceil(maxDist * 1000 / slowestSpeed);
		}
		return -1;
	}

}
