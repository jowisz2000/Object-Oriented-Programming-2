enum Rank{
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(2, "J"),
    QUEEN(3, "Q"),
    KING(4, "K"),
    ACE(1, "A");
    private final int rank;
    private final String symbol;


    Rank(int rank, String symbol) {
        this.rank = rank;
        this.symbol = symbol;
    }

    public int getRank() {
        return rank;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return rank + ": " + symbol;
    }
}