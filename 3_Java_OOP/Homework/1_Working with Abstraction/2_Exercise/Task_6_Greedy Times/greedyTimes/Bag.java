import java.util.HashMap;
import java.util.Map;

public class Bag {
    private final long capacity;
    private long currentWeight;
    private long totalGold;
    private long totalGems;
    private long totalCash;
    private final Map<String, Long> gems;
    private final Map<String, Long> cash;
    private boolean goldIsAdded;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.currentWeight = 0;
        this.totalGold = 0;
        this.totalGems = 0;
        this.totalCash = 0;
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
        this.goldIsAdded=false;
    }

    public void addCash(String name, long amount) {
        if (hasFreeCapacity(amount) && this.totalGems >= this.totalCash + amount) {
            if (!this.cash.containsKey(name)) {
                this.cash.put(name, amount);
            } else {
                this.cash.put(name, this.cash.get(name) + amount);
            }
            this.totalCash += amount;
            this.currentWeight += amount;
        }
    }

    private boolean hasFreeCapacity(long quantity) {
        return this.currentWeight + quantity <= this.capacity;
    }

    public void addGems(String name, long amount) {
        if (this.hasFreeCapacity(amount) && this.totalGold >= this.totalGems + amount) {
            if (!this.gems.containsKey(name)) {
                this.gems.put(name, amount);
            } else {
                this.gems.put(name, this.gems.get(name) + amount);
            }
            this.totalGems += amount;
            this.currentWeight += amount;
        }
    }

    public void addGold(long quantity) {
        if (this.hasFreeCapacity(quantity)) {
            this.goldIsAdded=true;
            this.totalGold += quantity;
            this.currentWeight += quantity;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(this.goldIsAdded) {
            sb.append("<Gold> $").append(this.totalGold).append(System.lineSeparator());
            sb.append("##Gold - ").append(this.totalGold).append(System.lineSeparator());
        }
        if (this.gems.size() > 0) {
            sb.append("<Gem> $").append(this.totalGems).append(System.lineSeparator());
            this.gems.entrySet().stream().sorted((f, s) -> {
                int result = s.getKey().compareTo(f.getKey());
                if (result == 0) {
                    result = f.getValue().compareTo(s.getValue());
                }
                return result;
            }).forEach(entry -> {
                sb.append("##")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue())
                        .append(System.lineSeparator());
            });
        }
        if (this.cash.size() > 0) {
            sb.append("<Cash> $").append(this.totalCash).append(System.lineSeparator());
            this.cash.entrySet().stream().sorted((f, s) -> {
                int result = s.getKey().compareTo(f.getKey());
                if (result == 0) {
                    result = f.getValue().compareTo(s.getValue());
                }
                return result;
            }).forEach(entry -> {
                sb.append("##")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue())
                        .append(System.lineSeparator());
            });
        }
        return sb.toString();
    }
}