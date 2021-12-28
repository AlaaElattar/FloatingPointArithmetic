public class Symbol {
    private char symbol;
    private double probability;

    public Symbol ( char symbol , double probability ) {
        this.symbol = symbol;
        this.probability = probability;
    }

    public char getSymbol ( ) {
        return symbol;
    }

    public void setSymbol ( char symbol ) {
        this.symbol = symbol;
    }

    public double getProbability ( ) {
        return probability;
    }

    public void setProbability ( double probability ) {
        this.probability = probability;
    }
}
