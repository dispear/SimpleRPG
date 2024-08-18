package org.example.RPG.informaion;

import java.io.Serializable;

public class Monster implements Serializable {
    private int num;
    private String name;
    private int hp;
    private int maxHp;
    private int minAttack;
    private int maxAttack;
    private int exp;
    private int minMoney;
    private int maxMoney;

    public Monster(int num, String name, int hp, int maxHp, int minAttack, int maxAttack, int exp, int minMoney, int maxMoney) {
        this.num = num;
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        this.exp = exp;
        this.minMoney = minMoney;
        this.maxMoney = maxMoney;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public void setMinAttack(int minAttack) {
        this.minAttack = minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(int minMoney) {
        this.minMoney = minMoney;
    }

    public int getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(int maxMoney) {
        this.maxMoney = maxMoney;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", minAttack=" + minAttack +
                ", maxAttack=" + maxAttack +
                ", exp=" + exp +
                ", minMoney=" + minMoney +
                ", maxMoney=" + maxMoney +
                '}';
    }


}
