package org.pokergame.poker;

public class Game {
    private Table table;
    private Rule rule;

    public Game(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }
        this.rule = new Rule(num);
    }

    public void start() {
        int victoryPeople = 0;
        this.rule.getTable().cardProgress();
        this.rule.getTable().userRank();
        victoryPeople = rule.victory(this.rule.getTable().getUsers());
        System.out.println("이긴사람 : 플레이어" + (victoryPeople + 1));
        System.out.println();
    }

    public Rule getRule() {
        return rule;
    }
}
