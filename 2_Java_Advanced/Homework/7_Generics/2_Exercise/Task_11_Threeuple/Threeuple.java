public class Threeuple<T1, T2, T3> {
    T1 item1;
    T2 item2;
    T3 item3;

    public Threeuple(T1 item1, T2 item2, T3 item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format(item1 + " -> " + item2 + " -> " + item3);
    }
}