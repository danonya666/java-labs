import java.util.Arrays;

public class ThirdU0901Main {
    public static void main(String[] argc) {
        Integer[] intArr = {10, 20, 15};
        Float[] floatArr = new Float[1377];
        String[] strArr = new String[] {
                "I", "Hate", "Java",
        };
        Arrays.fill(floatArr, 0f);
        for (float i = 1.5f; i < 10; ++i) {
            floatArr[Math.round(i)] = i;
        }
        U0901WorkArray<Integer> insWorkArrayInt = new U0901WorkArray<>(intArr);
        U0901WorkArray<Float> insWorkArrayFloat = new U0901WorkArray<>(floatArr);
//        U0901WorkArray insWorkArrayString = new U0901WorkArray(strArr);
        System.out.format("sum of ints: %f\n", insWorkArrayInt.sum());
        System.out.format("sum of floats: %f\n", insWorkArrayFloat.sum());
        System.out.format("sum of strings: %s\n", insWorkArrayFloat.sum());
    }
}
