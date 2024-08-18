package org.example.RPG.informaion;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String name;
    private int hp;
    private int maxHp;
    private int level;
    private int minAttack;
    private int maxAttack;
    private int money;
    private int exp;
    private int maxExp;

    public User(String name, int hp, int maxHp, int level, int minAttack, int maxAttack, int money, int exp, int maxExp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.level = level;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        this.money = money;
        this.exp = exp;
        this.maxExp = maxExp;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    @Override
    public String toString() {
        return
                "이름='" + name + '\'' +
                ", 현재 체력=" + hp +
                ", 전체 체력=" + maxHp +
                ", 레벨=" + level +
                ", 최소공격력=" + minAttack +
                ", 최대공격력=" + maxAttack +
                ", 돈=" + money +
                ", 현재경험치=" + exp +
                ", 필요경험치=" + maxExp
                ;
    }


}
