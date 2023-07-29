import java.util.*;

public class Task_4_Cheap_Town_Tour {
    static class Edge implements Comparable<Edge> {
        int source, destination, cost;

        public Edge(int source, int destination, int cost) {
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }

        public int compareTo(Edge compareEdge) {
            return this.cost - compareEdge.cost;
        }
    }

    static int[] parent;

    static int find(int i) {
        if (parent[i] == i)
            return i;
        else {
            int result = find(parent[i]);
            parent[i] = result;
            return result;
        }
    }

    static void union(int i, int j) {
        parent[find(i)] = find(j);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int towns = Integer.parseInt(scanner.nextLine());
        int roads = Integer.parseInt(scanner.nextLine());

        parent = new int[towns];
        for (int i = 0; i < towns; i++)
            parent[i] = i;

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for (int i = 0; i < roads; i++) {
            String[] connection = scanner.nextLine().split(" - ");
            int source = Integer.parseInt(connection[0]);
            int destination = Integer.parseInt(connection[1]);
            int cost = Integer.parseInt(connection[2]);

            pq.offer(new Edge(source, destination, cost));
        }

        int totalCost = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.source) != find(edge.destination)) {
                union(edge.source, edge.destination);
                totalCost += edge.cost;
            }
        }

        System.out.println("Total cost: " + totalCost);
    }
}
