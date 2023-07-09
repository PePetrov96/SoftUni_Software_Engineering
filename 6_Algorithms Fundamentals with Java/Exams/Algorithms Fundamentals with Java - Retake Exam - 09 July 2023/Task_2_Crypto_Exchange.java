import java.util.*;

public class Task_2_Crypto_Exchange {
    public static void main(String[] args) {
        // Read input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, List<String>> exchangeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String pair = scanner.nextLine();
            String[] assets = pair.split(" - ");
            String asset1 = assets[0];
            String asset2 = assets[1];

            // Add the trading pair to the exchange map
            exchangeMap.putIfAbsent(asset1, new ArrayList<>());
            exchangeMap.putIfAbsent(asset2, new ArrayList<>());
            exchangeMap.get(asset1).add(asset2);
            exchangeMap.get(asset2).add(asset1);
        }

        String request = scanner.nextLine();
        String[] requestAssets = request.split(" -> ");
        String startAsset = requestAssets[0];
        String targetAsset = requestAssets[1];

        int minimumTrades = findMinimumTrades(exchangeMap, startAsset, targetAsset);
        System.out.println(minimumTrades);
    }

    private static int findMinimumTrades(Map<String, List<String>> exchangeMap, String startAsset, String targetAsset) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> tradeCount = new HashMap<>();

        queue.add(startAsset);
        visited.add(startAsset);
        tradeCount.put(startAsset, 0);

        while (!queue.isEmpty()) {
            String currentAsset = queue.poll();

            if (currentAsset.equals(targetAsset)) {
                return tradeCount.get(currentAsset);
            }

            List<String> connectedAssets = exchangeMap.get(currentAsset);
            for (String connectedAsset : connectedAssets) {
                if (!visited.contains(connectedAsset)) {
                    queue.add(connectedAsset);
                    visited.add(connectedAsset);
                    tradeCount.put(connectedAsset, tradeCount.get(currentAsset) + 1);
                }
            }
        }

        return -1; // Request is impossible to fulfill
    }
}
