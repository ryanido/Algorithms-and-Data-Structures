import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;

import org.junit.Test;

public class CompetitionTests {
	public String filename = "tinyEWD.txt";

	// Testing Graph Class Methods
	@Test
	public void testGraphConstructors() {
		Graph testGraph = new Graph(new File("input-J.txt"));
		assertTrue("Checking if a new graph is empty", testGraph.isEmpty());
		testGraph = new Graph(new File(filename));
		assertTrue("Checking if edges added from a file are added correctly", testGraph.contains(4, 5, 0.35));
		assertTrue("Checking if edges added from a file are added correctly", testGraph.contains(6, 4, 0.93));
	}


	// Testing Competition Djikstra Class
	@Test
	public void testDijkstraConstructor() {
		CompetitionDijkstra test = new CompetitionDijkstra(filename, 1, 2, 3);
		assertTrue("Checking if CompetitionDijkstra constructor works correctly",
				(!test.city.isEmpty() && test.sA == 1 && test.sB == 2 && test.sC == 3));
	}

	@Test
	public void testTimeRequiredforCompetitionDijkstra() {
		CompetitionDijkstra test = new CompetitionDijkstra(filename, 100, 100, 100);
		assertEquals("Checking if testTimeRequiredforCompetition is correct when all contestants have the same speed",
				19, test.timeRequiredforCompetition(), 0);
		test = new CompetitionDijkstra(filename, 50, 75, 100);
		assertEquals("Checking if testTimeRequiredforCompetition is correct when contestants have different speed", 38,
				test.timeRequiredforCompetition(), 0);
		test = new CompetitionDijkstra(filename, 50, -75, 100);
		assertEquals("Checking if testTimeRequiredforCompetition returns -1 when contestants have illegal speed", -1,
				test.timeRequiredforCompetition(), 0);

	}

	// Testing FWGraph Class Methods
	@Test
	public void testFWGraphConstructors() {
		FWGraph testGraph = new FWGraph(new File("input-J.txt"));
		assertTrue("Checking if a new graph is empty", testGraph.isEmpty());
		testGraph = new FWGraph(new File(filename));
		assertTrue("Checking if edges added from a file are added correctly", testGraph.contains(4, 5, 0.35));
		assertTrue("Checking if edges added from a file are added correctly", testGraph.contains(6, 4, 0.93));

	}


	// Testing Competition FloydWarshall Class
	@Test
	public void testFWConstructor() {
		CompetitionFloydWarshall test = new CompetitionFloydWarshall(filename, 1, 2, 3);
		assertTrue("Checking if CompetitionFloydWarshall constructor works correctly",
				(!test.city.isEmpty() && test.sA == 1 && test.sB == 2 && test.sC == 3));
	}

	@Test
	public void testTimeRequiredforCompetitionFW() {
		CompetitionFloydWarshall test = new CompetitionFloydWarshall(filename, 100, 100, 100);
		assertEquals("Checking if testTimeRequiredforCompetition is correct when all contestants have the same speed",
				19, test.timeRequiredforCompetition(), 0);
		test = new CompetitionFloydWarshall(filename, 50, 75, 100);
		assertEquals("Checking if testTimeRequiredforCompetition is correct when contestants have different speed", 38,
				test.timeRequiredforCompetition(), 0);
		test = new CompetitionFloydWarshall(filename, 50, -75, 100);
		assertEquals("Checking if testTimeRequiredforCompetition returns -1 when contestants have illegal speed", -1,
				test.timeRequiredforCompetition(), 0);
	}

	// TODO - more tests

}