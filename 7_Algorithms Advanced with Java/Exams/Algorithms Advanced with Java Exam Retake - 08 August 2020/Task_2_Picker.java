import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task_2_Picker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        int[][] graph = new int[nodes][nodes];

        for (int i = 0; i < edges; i++) {
            int[] tokens = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int source = tokens[0];
            int destination = tokens[1];
            int weight = tokens[2];

            graph[source][destination] = weight;
        }

        int cost = 0;

        int[] parents = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            parents[i] = i;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(n -> graph[n[0]][n[1]]));

        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {
                if (graph[row][col] != 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        StringBuilder out = new StringBuilder();

        while (!queue.isEmpty()) {
            int[] minEdge = queue.poll();

            int from = minEdge[0];
            int to = minEdge[1];
            int weight = graph[from][to];

            int firstRoot = findRoot(from, parents);
            int secondRoot = findRoot(to, parents);

            if (firstRoot != secondRoot) {
                parents[secondRoot] = firstRoot;
                out.append(from).append(" ").append(to).append(System.lineSeparator());
                cost += weight;
            }
        }

        out.append(cost);

        System.out.println(out.toString());
    }

    private static int findRoot(int from, int[] parents) {
        while (parents[from] != from) {
            from = parents[from];
        }
        return from;
    }
}
