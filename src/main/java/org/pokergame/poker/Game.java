package org.pokergame.poker;

public class Game {
    private Rule rule;
    private int num;

    public Game(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        }
        this.num = num;
        this.rule = new Rule(num);
    }

    public void start() {
        this.rule.getTable().cardProgress();
        this.rule.getTable().userRank();
        rule.victory(this.rule.getTable().getUsers());
        for (int i = 0; i < num; i++) {
            System.out.println("플레이어" + (i + 1) + "주어진 패: " + this.rule.getTable().getUser(i));
        }
        for (int i = 0; i < num; i++) {
            System.out.println("-------------------");
            System.out.println("플레이어" + (i + 1) + " 족보: " + this.rule.getTable().getUser(i).getRankCard());
            System.out.println("\n" + this.rule.getTable().getUser(i).getRank() + "\n");
        }
        System.out.println("-------------------");
        System.out.println("이긴사람 : 플레이어" + (this.rule.getVictoryPeople() + 1));
        System.out.println();
    }

    public Rule getRule() {
        return rule;
    }
}
