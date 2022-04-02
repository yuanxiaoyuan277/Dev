package com.fc.demo2._ststic;

import org.junit.Test;

public class Client {
    @Test
    public void test() {
        GamePlay player = new GamePlayer();

        GamePlay proxy = new GamePlayPoxy(player);

        proxy.login();
        proxy.KillBoss();
        proxy.upgrade();
    }
}
