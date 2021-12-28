import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Alaa Mahmoud Ebrahim 20190105
 * @author Rana Ihab Ahmed  20190207
 */

public class ArithmeticCoding {
    private double LowRange;
    private double HighRange;
    HashMap<Character, Double> probabilities;
    private ArrayList<Symbol> symbols;
    private double code;

    ArithmeticCoding() {
        LowRange = 0;
        HighRange = 1;
        probabilities = new HashMap<>();
        code = -1;
    }

    public Symbol getSymbol(char tmp) {
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i).symbol == tmp) {
                return symbols.get(i);
            }
        }
        return null;
    }

    public void Compress(String msg) {
        for (int i = 0; i < msg.length(); i++) {
            Symbol x = getSymbol(msg.charAt(i));
            double newLow = LowRange;
            LowRange = LowRange + (HighRange - LowRange) * x.getLowRange();
            HighRange = newLow + (HighRange - newLow) * x.getHighRange();
        }

        code = (LowRange + HighRange) / 2;
        System.out.println("The compressed code is : " + code);
    }

    public void calcProbability(String txt) {
        symbols = new ArrayList<>();
        for (int i = 0; i < txt.length(); i++) {
            double count = 1;
            if (probabilities.containsKey(txt.charAt(i))) {
                continue;
            }

            for (int j = i + 1; j < txt.length(); j++) {
                if (txt.charAt(j) == txt.charAt(i)) {
                    count++;
                }
            }
            probabilities.put(txt.charAt(i), count / txt.length());
        }
        boolean flag = true;
        for (Character key : probabilities.keySet()) {
            if (flag) {
                Symbol S = new Symbol(key, probabilities.get(key), 0, probabilities.get(key));
                symbols.add(S);
                flag = false;
            } else {
                Symbol S = new Symbol(key, probabilities.get(key), symbols.get(symbols.size() - 1).highRange, symbols.get(symbols.size() - 1).highRange + probabilities.get(key));
                symbols.add(S);
            }
            //System.out.println(key + " = " + probabilities.get(key));
        }
    }

    public void Decompress(int msgSize) {
        LowRange = 0;
        HighRange = 1;
        double newCode = code;
        code = ((newCode - LowRange) / (HighRange - LowRange));
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < msgSize; i++) {
            for (int j = 0; j < symbols.size(); j++) {
                if (code < symbols.get(j).getHighRange() && code > symbols.get(j).getLowRange()) {
                    output.append(symbols.get(j).getSymbol());
                    double oldLow = LowRange;
                    LowRange = LowRange + (HighRange - LowRange) * symbols.get(j).getLowRange();

                    double oldHigh = HighRange;
                    HighRange = oldLow + (HighRange - oldLow) * symbols.get(j).getHighRange();
                    code = ((newCode - LowRange) / (HighRange - LowRange));
                    break;
                }
            }
        }

        System.out.println("The message is : " + output);

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please, Enter the message : ");
        String message = input.next();
        ArithmeticCoding h = new ArithmeticCoding();
        h.calcProbability(message);
        h.Compress(message);
        int size = message.length();
        h.Decompress(size);

    }


}
