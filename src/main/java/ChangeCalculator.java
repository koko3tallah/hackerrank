public class ChangeCalculator {

    //1c, 5c, 10c, 25c, 50c, and $1

    public static int[] getChange(float M, float P) {

        int[] result = {0, 0, 0, 0, 0, 0};
        int[] ratios = {1, 5, 10, 25, 50, 100};
        int remaining = (int) (100 * (M - P));

        for (int i = ratios.length - 1; i >= 0; i--) {
            if (i == ratios.length - 1) {
                result[i] = remaining / 100;
                remaining = remaining - (result[i] * 100);
            } else {
                if (remaining > ratios[i]) {
                    result[i] = remaining % ratios[i];
                    remaining = remaining - result[i];
                } else if (remaining == ratios[i]) {
                    result[i]++;
                    break;
                }
            }
        }

        return result;
    }
}
