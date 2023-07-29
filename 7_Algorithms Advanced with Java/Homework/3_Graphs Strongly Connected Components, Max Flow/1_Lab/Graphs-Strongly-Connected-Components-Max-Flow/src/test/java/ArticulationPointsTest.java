import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ArticulationPointsTest {

    @Test
    public void FindArticulationPoints_WithTwoNodes() {
        List<Integer>[] graph = new ArrayList[2];
        graph[0] = new ArrayList<>(Arrays.asList(1));
        graph[1] = new ArrayList<>(Arrays.asList(0));

        List<Integer> expected = new ArrayList<>();
        List<Integer> result = ArticulationPoints.findArticulationPoints(graph);

        Collections.sort(expected);
        Collections.sort(result);

        Assert.assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void FindArticulationPoints_WithSingleArticulationPoint() {
        List<Integer>[] graph = new ArrayList[3];
        graph[0] = new ArrayList<>(Arrays.asList(1));
        graph[1] = new ArrayList<>(Arrays.asList(0, 2));
        graph[2] = new ArrayList<>(Arrays.asList(1));

        List<Integer> expected = new ArrayList<>(Arrays.asList(1));
        List<Integer> result = ArticulationPoints.findArticulationPoints(graph);

        Collections.sort(expected);
        Collections.sort(result);

        Assert.assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void FindArticulationPoints_WithSmallGraph() {
        List<Integer>[] graph = new ArrayList[6];
        graph[0] = new ArrayList<>(Arrays.asList(1, 2));
        graph[1] = new ArrayList<>(Arrays.asList(0, 5));
        graph[2] = new ArrayList<>(Arrays.asList(0, 2, 3, 4));
        graph[3] = new ArrayList<>(Arrays.asList(0, 2));
        graph[4] = new ArrayList<>(Arrays.asList(2));
        graph[5] = new ArrayList<>(Arrays.asList(1));

        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2));
        List<Integer> result = ArticulationPoints.findArticulationPoints(graph);

        Collections.sort(expected);
        Collections.sort(result);

        Assert.assertEquals(expected.toString(), expected.toString());
    }

    @Test
    public void FindArticulationPoints_WithMediumGraph() {
        List<Integer>[] graph = new ArrayList[8];
        graph[0] = new ArrayList<>(Arrays.asList(1, 3, 5));
        graph[1] = new ArrayList<>(Arrays.asList(0, 7));
        graph[2] = new ArrayList<>(Arrays.asList(3, 6));
        graph[3] = new ArrayList<>(Arrays.asList(0, 2, 7));
        graph[4] = new ArrayList<>(Arrays.asList(6));
        graph[5] = new ArrayList<>(Arrays.asList(0, 7));
        graph[6] = new ArrayList<>(Arrays.asList(2, 4));
        graph[7] = new ArrayList<>(Arrays.asList(1, 3, 5));

        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 6));
        List<Integer> result = ArticulationPoints.findArticulationPoints(graph);

        Collections.sort(expected);
        Collections.sort(result);

        Assert.assertEquals(expected.toString(), result.toString());
    }


    @Test
    public void FindArticulationPoints_WithLargeGraph() {
        List<Integer>[] graph = new ArrayList[12];
        graph[0] = new ArrayList<>(Arrays.asList(1, 2, 6, 7, 9));
        graph[1] = new ArrayList<>(Arrays.asList(0, 6));
        graph[2] = new ArrayList<>(Arrays.asList(0, 7));
        graph[3] = new ArrayList<>(Arrays.asList(4));
        graph[4] = new ArrayList<>(Arrays.asList(3, 6, 10));
        graph[5] = new ArrayList<>(Arrays.asList(7));
        graph[6] = new ArrayList<>(Arrays.asList(0, 1, 4, 8, 10, 11));
        graph[7] = new ArrayList<>(Arrays.asList(0, 2, 5, 9));
        graph[8] = new ArrayList<>(Arrays.asList(6, 11));
        graph[9] = new ArrayList<>(Arrays.asList(0, 7));
        graph[10] = new ArrayList<>(Arrays.asList(4, 6));
        graph[11] = new ArrayList<>(Arrays.asList(6, 8));

        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 4, 6, 7));
        List<Integer> result = ArticulationPoints.findArticulationPoints(graph);

        Collections.sort(expected);
        Collections.sort(result);

        Assert.assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void FindArticulationPoints_WithMediumGraphWithNoArticulationPoints() {
        List<Integer>[] graph = new ArrayList[7];
        graph[0] = new ArrayList<>(Arrays.asList(3, 4, 6));
        graph[1] = new ArrayList<>(Arrays.asList(3, 5));
        graph[2] = new ArrayList<>(Arrays.asList(3, 5));
        graph[3] = new ArrayList<>(Arrays.asList(4, 6));
        graph[4] = new ArrayList<>(Arrays.asList(3, 6));
        graph[5] = new ArrayList<>(Arrays.asList(3, 6));
        graph[6] = new ArrayList<>(Arrays.asList(0, 5));

        List<Integer> expected = new ArrayList<>(Arrays.asList());
        List<Integer> result = ArticulationPoints.findArticulationPoints(graph);

        Collections.sort(expected);
        Collections.sort(result);

        Assert.assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void FindArticulationPoints_WithSingleComponentCentralPoint() {
        List<Integer>[] graph = new ArrayList[5];
        graph[0] = new ArrayList<>(Arrays.asList(1, 3));
        graph[1] = new ArrayList<>(Arrays.asList(2, 4));
        graph[2] = new ArrayList<>(Arrays.asList(1, 3));
        graph[3] = new ArrayList<>(Arrays.asList(0, 2, 4));
        graph[4] = new ArrayList<>(Arrays.asList(1, 3));

        List<Integer> expected = new ArrayList<>(Arrays.asList());
        List<Integer> result = ArticulationPoints.findArticulationPoints(graph);

        Collections.sort(expected);
        Collections.sort(result);

        Assert.assertEquals(expected.toString(), result.toString());
    }
}
