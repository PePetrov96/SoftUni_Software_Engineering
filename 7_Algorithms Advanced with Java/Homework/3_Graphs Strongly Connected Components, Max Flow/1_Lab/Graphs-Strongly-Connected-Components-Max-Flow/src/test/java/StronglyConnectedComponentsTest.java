import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
@SuppressWarnings("all")
public class StronglyConnectedComponentsTest {

    @Test
    public void FindSCC_WithSingleNode() {
        List<Integer>[] graph = new ArrayList[1];
        graph[0] = new ArrayList<>();

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(0)));

        List<List<Integer>> result = StronglyConnectedComponents.findStronglyConnectedComponents(graph);
        result = result.stream().sorted((l1, l2) -> {
            int cmp = Integer.compare(l1.size(), l2.size());
            if (cmp == 0) {
                return l1.get(0).compareTo(l2.get(0));
            }

            return cmp;
        }).collect(Collectors.toList());

        for (int i = 0; i < expected.size(); i++) {
            Collections.sort(expected.get(i));
            Collections.sort(result.get(i));
            Assert.assertEquals(expected.get(i).toString(), result.get(i).toString());
        }
    }

    @Test
    public void FindSCC_WithSingleComponentWithMultipleVertices() {
        List<Integer>[] graph = new ArrayList[3];
        graph[0] = new ArrayList<>(Arrays.asList(2));
        graph[1] = new ArrayList<>(Arrays.asList(2));
        graph[2] = new ArrayList<>(Arrays.asList(0, 1));

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(0, 1, 2)));

        List<List<Integer>> result = StronglyConnectedComponents.findStronglyConnectedComponents(graph);
        result = result.stream().sorted((l1, l2) -> {
            int cmp = Integer.compare(l1.size(), l2.size());
            if (cmp == 0) {
                return l1.get(0).compareTo(l2.get(0));
            }

            return cmp;
        }).collect(Collectors.toList());

        for (int i = 0; i < expected.size(); i++) {
            Collections.sort(expected.get(i));
            Collections.sort(result.get(i));
            Assert.assertEquals(expected.get(i).toString(), result.get(i).toString());
        }
    }

    @Test
    public void FindSCC_WithCyclicComponent() {
        List<Integer>[] graph = new ArrayList[3];
        graph[0] = new ArrayList<>(Arrays.asList(1));
        graph[1] = new ArrayList<>(Arrays.asList(2));
        graph[2] = new ArrayList<>(Arrays.asList(0));

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(0, 1, 2)));

        List<List<Integer>> result = StronglyConnectedComponents.findStronglyConnectedComponents(graph);
        result = result.stream().sorted((l1, l2) -> {
            int cmp = Integer.compare(l1.size(), l2.size());
            if (cmp == 0) {
                return l1.get(0).compareTo(l2.get(0));
            }

            return cmp;
        }).collect(Collectors.toList());

        for (int i = 0; i < expected.size(); i++) {
            Collections.sort(expected.get(i));
            Collections.sort(result.get(i));
            Assert.assertEquals(expected.get(i).toString(), result.get(i).toString());
        }
    }

    @Test
    public void FindSCC_WithThreeComponents() {
        List<Integer>[] graph = new ArrayList[8];
        graph[0] = new ArrayList<>(Arrays.asList(1, 3));
        graph[1] = new ArrayList<>(Arrays.asList());
        graph[2] = new ArrayList<>(Arrays.asList(4, 7));
        graph[3] = new ArrayList<>(Arrays.asList(2, 3, 4, 6));
        graph[4] = new ArrayList<>(Arrays.asList(3, 5));
        graph[5] = new ArrayList<>(Arrays.asList(1, 6));
        graph[6] = new ArrayList<>(Arrays.asList(5));
        graph[7] = new ArrayList<>(Arrays.asList(0, 2, 6));

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(1)));
        expected.add(new ArrayList<>(Arrays.asList(5, 6)));
        expected.add(new ArrayList<>(Arrays.asList(0, 2, 3, 4, 7)));

        List<List<Integer>> result = StronglyConnectedComponents.findStronglyConnectedComponents(graph);
        result = result.stream().sorted((l1, l2) -> {
            int cmp = Integer.compare(l1.size(), l2.size());
            if (cmp == 0) {
                return l1.get(0).compareTo(l2.get(0));
            }

            return cmp;
        }).collect(Collectors.toList());

        for (int i = 0; i < expected.size(); i++) {
            Collections.sort(expected.get(i));
            Collections.sort(result.get(i));
            Assert.assertEquals(expected.get(i).toString(), result.get(i).toString());
        }
    }

    @Test
    public void FindSCC_WithMultipleComponents() {
        List<Integer>[] graph = new ArrayList[14];
        graph[0] = new ArrayList<>(Arrays.asList(1, 11, 13));
        graph[1] = new ArrayList<>(Arrays.asList(6));
        graph[2] = new ArrayList<>(Arrays.asList(0));
        graph[3] = new ArrayList<>(Arrays.asList(4));
        graph[4] = new ArrayList<>(Arrays.asList(3, 6));
        graph[5] = new ArrayList<>(Arrays.asList(13));
        graph[6] = new ArrayList<>(Arrays.asList(0, 11));
        graph[7] = new ArrayList<>(Arrays.asList(12));
        graph[8] = new ArrayList<>(Arrays.asList(6, 11));
        graph[9] = new ArrayList<>(Arrays.asList(0));
        graph[10] = new ArrayList<>(Arrays.asList(4, 6, 10));
        graph[11] = new ArrayList<>(Arrays.asList());
        graph[12] = new ArrayList<>(Arrays.asList(7));
        graph[13] = new ArrayList<>(Arrays.asList(2, 9));

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(5)));
        expected.add(new ArrayList<>(Arrays.asList(8)));
        expected.add(new ArrayList<>(Arrays.asList(10)));
        expected.add(new ArrayList<>(Arrays.asList(11)));
        expected.add(new ArrayList<>(Arrays.asList(3, 4)));
        expected.add(new ArrayList<>(Arrays.asList(7, 12)));
        expected.add(new ArrayList<>(Arrays.asList(0, 1, 2, 6, 9, 13)));

        List<List<Integer>> result = StronglyConnectedComponents.findStronglyConnectedComponents(graph);
        result = result.stream().sorted((l1, l2) -> {
            int cmp = Integer.compare(l1.size(), l2.size());
            if (cmp == 0) {
                return l1.get(0).compareTo(l2.get(0));
            }

            return cmp;
        }).collect(Collectors.toList());

        for (int i = 0; i < expected.size(); i++) {
            Collections.sort(expected.get(i));
            Collections.sort(result.get(i));
            Assert.assertEquals(expected.get(i).toString(), result.get(i).toString());
        }
    }
}
