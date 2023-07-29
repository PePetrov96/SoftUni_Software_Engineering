import java.util.*;

public class ArticulationPoints {

    private static List<Integer>[] graph;
    private static List<Integer> points;
    private static boolean[] visited;
    private static int[] parents;
    private static int[] depths;
    private static int[] lowpoints;

    public static List<Integer> findArticulationPoints(List<Integer>[] targetGraph) {
        graph = targetGraph;
        points = new ArrayList<>();
        visited = new boolean[graph.length];
        parents = new int[graph.length];
        depths = new int[graph.length];
        lowpoints = new int[graph.length];

        Arrays.fill(parents, -1);

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                discoverArticulationPoints(i, 0);
            }
        }

        return points;
    }

    private static void discoverArticulationPoints(int node, int depth) {
        visited[node] = true;
        depths[node] = depth;
        lowpoints[node] = depth;

        int children = 0;
        boolean isArticulationPoint = false;

        for (int child : graph[node]) {
            if (!visited[child]) {
                parents[child] = node;
                children++;
                discoverArticulationPoints(child, depth + 1);
                if (lowpoints[child] >= depth) {
                    isArticulationPoint = true;
                }
                lowpoints[node] = Math.min(lowpoints[node], lowpoints[child]);
            } else if (parents[node] != child) {
                lowpoints[node] = Math.min(lowpoints[node], depths[child]);
            }
        }

        if ((parents[node] == -1 && children > 1) || (parents[node] != -1 && isArticulationPoint)) {
            points.add(node);
        }
    }
}
