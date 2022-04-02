package com.fc.demo2._ststic;

public class GamePlayer implements GamePlay{
    @Override
    public void login() {
        System.out.println("爷傲奈我何 TiMi~");
    }

    @Override
    public void KillBoss() {
        System.out.println("爷傲奈我何 打BOSS~");
    }

    @Override
    public void upgrade() {
        System.out.println("爷傲奈我何 升级~");
    }
}
