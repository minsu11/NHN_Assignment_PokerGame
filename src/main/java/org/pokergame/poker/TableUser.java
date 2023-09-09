package org.pokergame.poker;

public class TableUser {
    private int peopleNum;
    private User user[];

    public TableUser(int num) {
        this.user = new User[num];
    }

    public void setUser(User[] user) {
        this.user = user;
    }

    public User[] getUser() {
        return user;
    }
}
