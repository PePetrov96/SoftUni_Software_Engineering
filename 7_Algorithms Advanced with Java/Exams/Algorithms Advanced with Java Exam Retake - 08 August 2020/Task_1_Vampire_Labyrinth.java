import java.util.*;

public class Task_1_Vampire_Labyrinth {
    static class Node implements Comparable<Node> {
        int id;
        int dist;

        public Node(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }

        public int compareTo(Node other) {
            return this.dist - other.dist;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] places = scanner.nextLine().split(" ");
        int landingPlace = Integer.parseInt(places[0]);
        int temple = Integer.parseInt(places[1]);

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] way = scanner.nextLine().split(" ");
            int from = Integer.parseInt(way[0]);
            int to = Integer.parseInt(way[1]);
            int vampiresCount = Integer.parseInt(way[2]);

            graph.get(from).add(new Node(to, vampiresCount));
            graph.get(to).add(new Node(from, vampiresCount));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[landingPlace] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(landingPlace, 0));

        boolean[] visited = new boolean[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.id]) {
                continue;
            }
            visited[node.id] = true;

            for (Node neighbor : graph.get(node.id)) {
                if (!visited[neighbor.id] && dist[node.id] + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = dist[node.id] + neighbor.dist;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                    prev[neighbor.id] = node.id;
                }
            }
        }

        if (dist[temple] == Integer.MAX_VALUE) {
            System.out.println("No path found");
        } else {
            List<Integer> path = new ArrayList<>();
            for (int v = temple; v != -1; v = prev[v]) {
                path.add(v);
            }
            Collections.reverse(path);

            for (int i = 0; i < path.size(); i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(path.get(i));
            }
            System.out.println();
            System.out.println(dist[temple]);
        }
    }
}
