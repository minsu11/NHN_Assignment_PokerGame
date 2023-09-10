package org.pokergame.poker;

public class Game {
    private Table table;
    private Rule rule;
    private int num;

    public Game(int num) {
        this.rule = new Rule(num);
        this.num = num;
    }

    public void start() {
        int victoryPeople = 0;
        this.rule.getTable().cardProgress();
        this.rule.getTable().userRank();
        victoryPeople = rule.victory(this.num, this.rule.getTable().getUsers());
        System.out.println("이긴사람 : 플레이어" + (victoryPeople + 1));
        System.out.println();
    }

    public Rule getRule() {
        return rule;
    }
}
