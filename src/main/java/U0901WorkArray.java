public class U0901WorkArray <T extends Number> {
    T[] arrNums;

    public U0901WorkArray(T[] numP) {
        this.arrNums = numP;
    }

    public double sum() {
        double result = 0.0;
        for (T el: arrNums) {
            result += el.doubleValue();
        }
        return result;
    }
}
