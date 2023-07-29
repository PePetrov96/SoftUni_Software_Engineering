import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {

    public static List<Edge> kruskal(int numberOfVertices, List<Edge> edges) {
        Collections.sort(edges);

        int[] parents = new int[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            parents[i] = i;
        }

        List<Edge> mst = new ArrayList<>();
        for (Edge edge : edges) {
            int source = edge.getStartNode();
            int dest = edge.getEndNode();

            int firstRoot = findRoot(source, parents);
            int secondRoot = findRoot(dest, parents);

            if (firstRoot != secondRoot) {
                mst.add(edge);
                parents[firstRoot] = secondRoot;
            }
        }

        return mst;
    }

    public static int findRoot(int node, int[] parents) {
        while (parents[node] != node) {
            node = parents[node];
        }

        return node;
    }
}
