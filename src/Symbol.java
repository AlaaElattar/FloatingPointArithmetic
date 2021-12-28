public class Symbol {
    public char symbol;
    public double probability;
    public double lowRange;
    public double highRange;

    public Symbol ( char symbol , double probability , double lowRange, double highRange) {
        this.symbol = symbol;
        this.probability = probability;
        this.lowRange = lowRange;
        this.highRange = highRange;
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

    public double getHighRange ( ) {
        return highRange;
    }

    public double getLowRange ( ) {
        return lowRange;
    }

    public void setHighRange ( double highRange ) {
        this.highRange = highRange;
    }

    public void setLowRange ( double lowRange ) {
        this.lowRange = lowRange;
    }
}
