package org.pokergame.poker;

public enum Rank {
    NOPAIR(0),
    ONEPAIR(1),
    TWOPAIR(2),
    TRIPLE(3);
    private final int rank;

    public int getRank() {
        return rank;
    }

    Rank(int rank) {
        this.rank = rank;
    }

}
