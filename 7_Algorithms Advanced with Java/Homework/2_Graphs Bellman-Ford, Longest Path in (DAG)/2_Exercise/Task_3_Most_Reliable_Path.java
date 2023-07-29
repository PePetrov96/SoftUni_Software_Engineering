import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_3_Most_Reliable_Path {
    static class Edge {
        int source, destination;
        double reliability;

        public Edge(int source, int destination, double reliability) {
            this.source = source;
            this.destination = destination;
            this.reliability = reliability;
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        double reliability;

        public Node(int index, double reliability) {
            this.index = index;
            this.reliability = reliability;
        }

        public int compareTo(Node other) {
            return Double.compare(other.reliability, this.reliability);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodesCount = extractNumbers(scanner.nextLine()).get(0);
        List<Integer> pathData = extractNumbers(scanner.nextLine());
        int start = pathData.get(0), end = pathData.get(1);
        int edgesCount = extractNumbers(scanner.nextLine()).get(0);

        ArrayList<Edge>[] edges = new ArrayList[nodesCount];
        for (int i = 0; i < nodesCount; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgesCount; i++) {
            List<Integer> edgeData = extractNumbers(scanner.nextLine());
            int source = edgeData.get(0);
            int destination = edgeData.get(1);
            double reliability = edgeData.get(2) / 100.0;
            edges[source].add(new Edge(source, destination, reliability));
            edges[destination].add(new Edge(destination, source, reliability));
        }

        double[] reliability = new double[nodesCount];
        int[] prev = new int[nodesCount];
        boolean[] visited = new boolean[nodesCount];
        Arrays.fill(reliability, -1);
        Arrays.fill(prev, -1);
        reliability[start] = 1;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 1));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visited[node.index]) continue;
            visited[node.index] = true;

            for (Edge edge : edges[node.index]) {
                double newReliability = node.reliability * edge.reliability;
                if (newReliability > reliability[edge.destination]) {
                    reliability[edge.destination] = newReliability;
                    prev[edge.destination] = edge.source;
                    queue.offer(new Node(edge.destination, newReliability));
                }
            }
        }

        System.out.printf("Most reliable path reliability: %.2f%%\n", reliability[end] * 100);
        LinkedList<Integer> pathList = new LinkedList<>();
        for (int i = end; i != -1; i = prev[i]) {
            pathList.addFirst(i);
        }
        for (int i = 0; i < pathList.size(); i++) {
            if (i > 0) System.out.print(" -> ");
            System.out.print(pathList.get(i));
        }
    }

    private static List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(input);
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }
        return numbers;
    }
}
