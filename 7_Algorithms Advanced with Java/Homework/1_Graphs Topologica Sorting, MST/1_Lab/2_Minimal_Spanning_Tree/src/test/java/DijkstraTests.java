import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DijkstraTests {

    private static int[][] GRAPH =
    {
        // 0   1   2   3   4   5   6   7   8   9  10  11
        { 0,  0,  0,  0,  0,  0, 10,  0, 12,  0,  0,  0 }, // 0
        { 0,  0,  0,  0, 20,  0,  0, 26,  0,  5,  0,  6 }, // 1
        { 0,  0,  0,  0,  0,  0,  0, 15, 14,  0,  0,  9 }, // 2
        { 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  7,  0 }, // 3
        { 0, 20,  0,  0,  0,  5, 17,  0,  0,  0,  0, 11 }, // 4
        { 0,  0,  0,  0,  5,  0,  6,  0,  3,  0,  0, 33 }, // 5
        {10,  0,  0,  0, 17,  6,  0,  0,  0,  0,  0,  0 }, // 6
        { 0, 26, 15,  0,  0,  0,  0,  0,  0,  3,  0, 20 }, // 7
        {12,  0, 14,  0,  0,  3,  0,  0,  0,  0,  0,  0 }, // 8
        { 0,  5,  0,  0,  0,  0,  0,  3,  0,  0,  0,  0 }, // 9
        { 0,  0,  0,  7,  0,  0,  0,  0,  0,  0,  0,  0 }, // 10
        { 0,  6,  9,  0, 11, 33,  0, 20,  0,  0,  0,  0 }, // 11
    };

    @Test
    public void FindPathBetween0And9() {
        List<Integer> path = Dijkstra.dijkstraAlgorithm(GRAPH, 0, 9);
        int length = 0;

        for (int i = 1; i < path.size(); i++) {
            length += GRAPH[path.get(i - 1)][path.get(i)];
        }

        int[] expectedPath = new int[] { 0, 8, 5, 4, 11, 1, 9 };
        int expectedLength = 42;

        int[] resultPath = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            resultPath[i] = path.get(i);
        }

        Assert.assertEquals(expectedLength, length);
        Assert.assertArrayEquals(expectedPath, resultPath);
    }

    @Test
    public void FindPathBetween0And2() {
        List<Integer> path = Dijkstra.dijkstraAlgorithm(GRAPH, 0, 2);
        int length = 0;

        for (int i = 1; i < path.size(); i++) {
            length += GRAPH[path.get(i - 1)][path.get(i)];
        }

        int[] expectedPath = new int[] { 0, 8, 2 };
        int expectedLength = 26;

        int[] resultPath = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            resultPath[i] = path.get(i);
        }

        Assert.assertEquals(expectedLength, length);
        Assert.assertArrayEquals(expectedPath, resultPath);
    }

    @Test
    public void FindPathBetween0And10() {
        List<Integer> path = Dijkstra.dijkstraAlgorithm(GRAPH, 0, 10);

        Assert.assertNull(path);
    }

    @Test
    public void FindPathBetween0And11()
    {
        List<Integer> path = Dijkstra.dijkstraAlgorithm(GRAPH, 0, 11);
        int length = 0;

        for (int i = 1; i < path.size(); i++) {
            length += GRAPH[path.get(i - 1)][path.get(i)];
        }

        int[] expectedPath = new int[] { 0, 8, 5, 4, 11 };
        int expectedLength = 31;

        int[] resultPath = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            resultPath[i] = path.get(i);
        }

        Assert.assertEquals(expectedLength, length);
        Assert.assertArrayEquals(expectedPath, resultPath);
    }

    @Test
    public void FindPathBetween0And1()
    {
        List<Integer> path = Dijkstra.dijkstraAlgorithm(GRAPH, 0, 1);
        int length = 0;

        for (int i = 1; i < path.size(); i++) {
            length += GRAPH[path.get(i - 1)][path.get(i)];
        }

        int[] expectedPath = new int[] { 0, 8, 5, 4, 11, 1 };
        int expectedLength = 37;

        int[] resultPath = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            resultPath[i] = path.get(i);
        }

        Assert.assertEquals(expectedLength, length);
        Assert.assertArrayEquals(expectedPath, resultPath);
    }
}
