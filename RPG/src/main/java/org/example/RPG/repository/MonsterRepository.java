package org.example.RPG.repository;

import org.example.RPG.informaion.Monster;
import org.example.RPG.informaion.User;

import java.io.*;
import java.util.ArrayList;

public class MonsterRepository {
    private final ArrayList<Monster> monsterList = new ArrayList<>();
    private static final String FILE_PATH = "RPG/src/main/java/org/example/RPG/db/monsterDB.dat";

    public MonsterRepository() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            ArrayList<Monster> monsters = new ArrayList<>();
            monsters.add(new Monster(1, "달팽이", 20, 20, 1, 10, 10, 10, 40));
            monsters.add(new Monster(2, "슬라임", 70, 70, 20, 40, 40, 40, 100));
            monsters.add(new Monster(3, "늑대", 200, 200, 40, 100, 100, 100, 400));
            monsters.add(new Monster(4, "유령", 500, 500, 100, 200, 400, 400, 1000));
            monsters.add(new Monster(5, "골렘", 1200, 1200, 200, 400, 1000, 1000, 4000));
            monsters.add(new Monster(6, "마녀", 2700, 2700, 400, 800, 4000, 4000, 10000));
            monsters.add(new Monster(7, "드래곤", 10000, 10000, 800, 2000, 10000, 10000, 50000));

            saveMonsters(file, monsters);
        }

        loadMonsters(file);
    }

    private void loadMonsters(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                monsterList.add((Monster) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("몬스터 로딩");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveMonsters(File file, ArrayList<Monster> monsters) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Monster monster : monsters) {
                oos.writeObject(monster);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Monster selectMonsterByNo(int no) {
        for (Monster monster : monsterList) {
            if (monster.getNum() == no) {
                return monster;
            }
        }
        return null;
    }
}


