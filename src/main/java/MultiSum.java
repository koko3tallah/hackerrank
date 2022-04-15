import java.util.Scanner;

class Arithmetic {
    public Integer sum(Integer[] ints) {
        Long sum = 0L;

        for (Integer anInt : ints) {
            sum += anInt;
        }
        return sum.intValue();
    }

    public String sum(String[] strings) {

        StringBuilder sum = new StringBuilder();
        for (String string : strings) {
            sum.append(string);
        }

        return sum.toString();
    }
}

public class MultiSum {

    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] values = line.split(" ");

        //check if int array
        try {
            Integer.parseInt(values[0]);

            //System.out.println("Integer array");
            Integer[] ia = new Integer[values.length];
            for (int i = 0; i < values.length; i++) {
                ia[i] = Integer.valueOf(values[i]);
            }
            System.out.println(arithmetic.sum(ia));
        } catch (NumberFormatException nfe) {
            //then string array

            //System.out.println("String array");
            System.out.println(arithmetic.sum(values));
        }
    }

}