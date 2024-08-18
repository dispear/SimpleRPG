package org.example.RPG.repository;

import org.example.RPG.informaion.User;

import java.io.*;

public class UserRepository {
    private static final String FILE_PATH = "RPG/src/main/java/org/example/RPG/db/userDB.dat";
    private User user = null;

    public UserRepository(User user) {
        File file = new File(FILE_PATH);

        saveUsers(file, user);
        loadUser(file);
    }

    private void loadUser(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            this.user = (User) ois.readObject();
        } catch (EOFException e) {
            System.out.println("로딩 완료");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveUsers(File file, User user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User statusUser() {
        return this.user;
    }

    public void updateUser(User user) {
        File file = new File(FILE_PATH);
        this.user = user;
        this.user.setMaxExp(changeMaxExp(this.user));
        this.user.setMinAttack(changeMinAttack(this.user));
        this.user.setMaxAttack(changeMaxAttack(this.user));
        this.user.setMaxHp(changeMaxHp(this.user));

        saveUsers(file, this.user);
    }

    public int changeMaxExp(User user) {
        if(user.getLevel() < 5){
            user.setMaxExp(user.getLevel() * 10);
        } else if(user.getLevel() < 10){
            user.setMaxExp(user.getLevel() * 20);
        }else if(user.getLevel() < 15){
            user.setMaxExp(user.getLevel() * 40);
        }else if(user.getLevel() < 20){
            user.setMaxExp(user.getLevel() * 80);
        } else if(user.getLevel() < 25){
            user.setMaxExp(user.getLevel() * 150);
        }else if(user.getLevel() < 30){
            user.setMaxExp(user.getLevel() * 240);
        }else{
            user.setMaxExp(user.getLevel() * 500);
        }

        return user.getMaxExp();
    }

    public int changeMinAttack(User user) {
        if(user.getLevel() < 5){
            user.setMinAttack(user.getLevel());
        } else if(user.getLevel() < 10){
            user.setMinAttack(user.getLevel() * 10);
        }else if(user.getLevel() < 15){
            user.setMinAttack(user.getLevel() * 20);
        }else if(user.getLevel() < 20){
            user.setMinAttack(user.getLevel() * 40);
        } else if(user.getLevel() < 25){
            user.setMinAttack(user.getLevel() * 80);
        }else if(user.getLevel() < 30){
            user.setMinAttack(user.getLevel() * 150);
        }else{
            user.setMinAttack(user.getLevel() * 240);
        }

        return user.getMinAttack();
    }

    public int changeMaxAttack(User user) {
        if(user.getLevel() < 5){
            user.setMaxAttack(user.getLevel() * 10);
        } else if(user.getLevel() < 10){
            user.setMaxAttack(user.getLevel() * 20);
        }else if(user.getLevel() < 15){
            user.setMaxAttack(user.getLevel() * 40);
        }else if(user.getLevel() < 20){
            user.setMaxAttack(user.getLevel() * 80);
        } else if(user.getLevel() < 25){
            user.setMaxAttack(user.getLevel() * 150);
        }else if(user.getLevel() < 30){
            user.setMaxAttack(user.getLevel() * 240);
        }else{
            user.setMaxAttack(user.getLevel() * 500);
        }

        return user.getMaxAttack();
    }

    public int changeMaxHp(User user) {
        if(user.getLevel() < 5){
            user.setMaxHp(user.getLevel() * 100);
        } else if(user.getLevel() < 10){
            user.setMaxHp(user.getLevel() * 200);
        }else if(user.getLevel() < 15){
            user.setMaxHp(user.getLevel() * 400);
        }else if(user.getLevel() < 20){
            user.setMaxHp(user.getLevel() * 800);
        } else if(user.getLevel() < 25){
            user.setMaxHp(user.getLevel() * 1500);
        }else if(user.getLevel() < 30){
            user.setMaxHp(user.getLevel() * 2400);
        }else{
            user.setMaxHp(user.getLevel() * 5000);
        }

        return user.getMaxHp();
    }
}
