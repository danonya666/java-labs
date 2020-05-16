import java.util.Arrays;

public class FirstCycles {
    public static void main(String[] argc) {
        FirstCycles cycles = new FirstCycles();
        cycles.a_z();
        cycles.productivity_check();
        cycles.time_experiments();
        cycles.array_test();
        cycles.transpose_test();
    }

    private void a_z() {
        char current = 'a';
        while (current <= 'z') {
            System.out.println(current);
            current++;
        }
    }

    private void productivity_check() {
        int i = 0;
        long start = System.currentTimeMillis();
        while (i < 100000000) {
            i++;
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.format("millies elapsed with int: %d\n", elapsed);
    }

    private void time_experiments() {
        long begin = new java.util.Date().getTime();
        long i = 0;
        while (i < 100000000) {
            ++i;
        }
        long end = new java.util.Date().getTime();
        System.out.format("millies elapsed with long: %d\n", end - begin);
    }

    private void array_test() {
        int[] mas = {12, 43, 12, -65, 778, 123, 32, 76};
        int maximum = mas[0];
        for (int el: mas) {
            if (el > maximum) {
                maximum = el;
            }
        }
        System.out.format("max element is: %d\n", maximum);
    }

    private void transpose_test() {
        int[][] arr = new int[3][3];
        Arrays.setAll(arr, x -> {
            int[] tmp = new int[3];
            Arrays.setAll(tmp, y -> (int)Math.round(Math.random() * 10));
            return tmp;
        });
        System.out.format("original array: %s\n", Arrays.deepToString(arr));
        System.out.format("transposed array: %s\n", Arrays.deepToString(transpose(arr)));
    }

    private int[][] transpose(int[][] matrix) {
        // Transpose, where m == n
        int m = matrix.length;
        int n = matrix[0].length;
        if (m != n) {
            throw new ArithmeticException("wrong array size");
        }
        for(int i = 0; i < m; i++) {
            for(int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }
}
