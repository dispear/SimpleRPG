package org.example.RPG.service;

import org.example.RPG.informaion.Monster;
import org.example.RPG.informaion.User;
import org.example.RPG.repository.MonsterRepository;
import org.example.RPG.repository.UserRepository;

public class GameService {
    private UserRepository userRepository;
    private final MonsterRepository monsterRepository = new MonsterRepository();

    public void newGame(User user) {
        userRepository = new UserRepository(user);
    }

    public void status() {
        User user = userRepository.statusUser();

        System.out.println(user);
    }

    // 몬스터 선택
    public Monster selectMonster(int choice) {
        Monster monster = monsterRepository.selectMonsterByNo(choice);
        return monster;
    }

    // 배틀 진행
    public void battle(int choice2) {
        Monster monster = selectMonster(choice2);
        User user = userRepository.statusUser();
        monster.setHp(monster.getMaxHp());

        while (user.getHp() > 0 && monster.getHp() > 0) {
            monster = attack(user, monster);
            if (monster.getHp() <= 0) {
                user = win(user, monster);
                break;
            }

            user = defend(user, monster);
            if (user.getHp() <= 0) {
                user = lose(user);
                break;
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        userRepository.updateUser(user);
    }

    // 유저의 공격
    public Monster attack(User user, Monster monster) {
        int damage = (int) (Math.random() * (user.getMaxAttack() - user.getMinAttack())) + user.getMinAttack();
        int nowHp = monster.getHp() - damage;
        if (nowHp <= 0)
            nowHp = 0;

        monster.setHp(nowHp);
        System.out.println(damage + " 데미지를 입혔습니다. " + monster.getName() + "의 체력 : " + monster.getHp());

        return monster;
    }

    // 몬스터의 공격
    public User defend(User user, Monster monster) {
        int damage = (int) (Math.random() * (monster.getMaxAttack() - monster.getMinAttack()))
                + monster.getMinAttack();
        int nowHp = user.getHp() - damage;
        if (nowHp <= 0)
            nowHp = 0;

        user.setHp(nowHp);
        System.out.println(damage + " 데미지를 받았습니다. " + user.getName()
                + " 의 남은 체력 : " + user.getHp() + "/" + user.getMaxHp());

        return user;
    }

    // 유저 승리 시 경험치, 돈 적용
    public User win(User user, Monster monster) {
        int exp = monster.getExp();

        user.setExp(user.getExp() + exp);
        user.setMoney(user.getMoney()
                + (int) (Math.random() * (monster.getMaxMoney() - monster.getMinMoney()) + monster.getMinMoney()));

        while (user.getExp() >= user.getMaxExp()) {
            user.setExp(user.getExp() - user.getMaxExp());
            user.setLevel(user.getLevel() + 1);
            user.setMaxHp(userRepository.changeMaxHp(user));
            user.setHp(user.getMaxHp());
            user.setMaxExp(userRepository.changeMaxExp(user));
        }

        System.out.println("승리 하였습니다!!!!!!");
        return user;
    }

    // 유저 패배, 돈 잃음
    public User lose(User user) {
        int money = user.getMoney() / 2;
        user.setMoney(money);
        user.setHp(user.getMaxHp());

        System.out.println("패배 하였습니다.... ");
        System.out.println(money + "을 잃어버렸다......");
        return user;
    }

    // 휴식, 비용 소모
    public void rest() {
        User user = userRepository.statusUser();

        if(user.getHp() == user.getMaxHp()) {
            System.out.println("체력이 가득합니다!!!");
        }else{
            int money = (int)(user.getMoney() / 5);
            user.setMoney(user.getMoney() - money);
            user.setHp(user.getMaxHp());

            System.out.println("체력이 회복되었습니다!!! ");
            System.out.println("비용 : " + money);
            System.out.println("현재 소지금 : " + user.getMoney());

            userRepository.updateUser(user);
        }
    }

    public boolean ending(int choice2) {
        Monster monster = selectMonster(choice2);

        if (monster.getHp() == 0) {
            System.out.println("드래곤을 무찌른 용사는 세계 최고의 검사가 되었다. -end-");
            return true;
        }

        return false;
    }
}
