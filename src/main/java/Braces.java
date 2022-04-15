import java.util.Scanner;
import java.util.Stack;

// Write your code here. DO NOT use an access modifier in your class declaration.
class Parser {
    static String isBalanced(String s) {
        Stack<Character> res = new Stack<>();
        for (byte aByte : s.getBytes()) {
            if (!res.isEmpty() && (((char) aByte) == ')' && res.peek() == '('
                    || ((char) aByte) == '}' && res.peek() == '{')) {
                res.pop();
            } else
                res.push(((char) aByte));
        }
        if (res.isEmpty())
            return "true";
        else
            return "false";
    }
}

class Braces {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(Parser.isBalanced(in.next()));
        }

        in.close();
    }
}
