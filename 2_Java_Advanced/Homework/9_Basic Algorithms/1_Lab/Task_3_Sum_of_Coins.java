import java.util.*;
import java.util.stream.Collectors;

public class Task_3_Sum_of_Coins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(",\\s+");
        int[] coins = Arrays.stream(elements).mapToInt(Integer::parseInt).toArray();

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Arrays.sort(coins);

        List<Integer> sortedCoins = Arrays.stream(coins).boxed()
               .sorted(Collections.reverseOrder())
               .collect(Collectors.toList());

        Map<Integer, Integer> chosenCoins = new LinkedHashMap<>();

        int currentSum = 0;
        int coinIndex = 0;

        while (currentSum != targetSum && coinIndex < sortedCoins.size()) {
           int currentCoin = sortedCoins.get(coinIndex);
           int remainder = targetSum - currentSum;
           int numberOfCoins = remainder / currentCoin;

           if (currentSum + currentCoin <= targetSum) {
               chosenCoins.put(currentCoin, numberOfCoins);
               currentSum += (numberOfCoins * currentCoin);
           }

           coinIndex++;
        }

        if (currentSum != targetSum) {
           throw new IllegalArgumentException();
        }

        return chosenCoins;
    }
}