package org.pokergame;

import org.pokergame.poker.Game;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        try {
            gameStart();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void gameStart() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("포커 게임을 시작합니다.");
//        System.out.printf("인원 수를 정하세요(2인 ~ 4인) : ");
//        int people = scanner.nextInt();
//        if (people < 2 && people > 4) {
//            throw new IllegalArgumentException("플레이어 수를 잘못 입력하셨습니다.");
//        }
        Game game = new Game(2);
        game.start();
    }
}
