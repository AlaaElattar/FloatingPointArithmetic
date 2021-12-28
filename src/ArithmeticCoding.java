import java.util.ArrayList;
import java.util.HashMap;

public class ArithmeticCoding {
    private double LowRange;
    private double HighRange;
    HashMap<Character,Double> probabilities;
    private ArrayList<Double> Low;
    private ArrayList<Double> high;
    private ArrayList<Symbol> symbols;

    ArithmeticCoding() {
        LowRange =0;
        HighRange =1;
        probabilities = new HashMap <> ();
        Low = new ArrayList<> ();
        high = new ArrayList<> ();
    }

    public Symbol getSymbol(char tmp)
    {
        for (int i=0;i<symbols.size ();i++) {
            if (symbols.get ( i ).symbol == tmp){
                return symbols.get ( i );
            }
        }
        return null;
    }

    public void Compress(String msg){
        for (int i=0;i<msg.length ();i++){
            Symbol x= getSymbol(msg.get(i));


        }

    }

    public void calcProbability(String txt) {
        symbols = new ArrayList <> ();
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
            probabilities.put(txt.charAt(i), count/txt.length ());
        }
        boolean flag = true;
        for (Character key : probabilities.keySet()) {
            if (flag){
                Symbol S = new Symbol ( key,probabilities.get ( key),0,probabilities.get ( key ));
                symbols.add ( S );
                flag = false;
            }else{
                Symbol S = new Symbol ( key,probabilities.get ( key ),symbols.get ( symbols.size( )-1 ).highRange, symbols.get ( symbols.size( )-1 ).highRange+probabilities.get ( key ));
                symbols.add ( S );
            }
            System.out.println(key + " = " + probabilities.get(key));
        }
    }

    public static void main ( String[] args ) {
        ArithmeticCoding h = new ArithmeticCoding ();
        h.calcProbability ( "ACBA" );
    }



}
