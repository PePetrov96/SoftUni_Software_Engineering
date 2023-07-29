import java.util.*;

public class Dijkstra {
    public static List<Integer> dijkstraAlgorithm(int[][] graph, int sourceNode, int destinationNode) {
        int n = graph.length;
        int[] prev = new int[n];
        boolean[] visited = new boolean[n];
        int[] distances = new int[n];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(node -> distances[node]));

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[sourceNode] = 0;
        queue.offer(sourceNode);
        Arrays.fill(prev, -1);

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            visited[parent] = true;

            for (int childNode = 0; childNode < n; childNode++) {
                if (graph[parent][childNode] != 0 && !visited[childNode]) {
                    int newDistance = distances[parent] + graph[parent][childNode];
                    if (newDistance < distances[childNode]) {
                        distances[childNode] = newDistance;
                        prev[childNode] = parent;
                        queue.offer(childNode);
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (distances[destinationNode] == Integer.MAX_VALUE) {
            return null;
        }

        for (int i = destinationNode; i != -1; i = prev[i]) {
            path.add(i);
        }

        Collections.reverse(path);
        return path;
    }
}
