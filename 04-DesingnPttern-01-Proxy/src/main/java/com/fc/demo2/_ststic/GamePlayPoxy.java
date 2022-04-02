package com.fc.demo2._ststic;

public class GamePlayPoxy implements GamePlay{
    private GamePlay gamePlayer;

    public GamePlayPoxy(GamePlay gamePlayer){
        this.gamePlayer =gamePlayer;
    }

    @Override
    public void login() {
        gamePlayer.login();
    }

    @Override
    public void KillBoss() {
        gamePlayer.KillBoss();
    }

    @Override
    public void upgrade() {
        gamePlayer.upgrade();

        this.luckDraw();
    }

    private void luckDraw() {
        System.out.println("升级抽奖，抽中SSR~");
    }
}
