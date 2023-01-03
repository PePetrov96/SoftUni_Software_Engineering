package Task_4_Random_Array_List;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<String> rndList = new RandomArrayList<>();
        rndList.add("a"); rndList.add("b"); rndList.add("c");
        rndList.add("d"); rndList.add("e"); rndList.add("f");
        rndList.add("g"); rndList.add("h"); rndList.add("i");

        System.out.println(rndList.getRandomElement());
    }
}