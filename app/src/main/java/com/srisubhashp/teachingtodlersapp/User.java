package com.srisubhashp.teachingtodlersapp;

public class User {
    private String firstName, lastName, email, phone, age;
    private String levelOneScore, levelTwoScore, levelThreeScore;
    private int levelOneAttempts, levelTwoAttempts, levelThreeAttempts;

    public User() {}

    public User(String fn, String ln, String e)
    {
        firstName = fn;
        lastName = ln;
        email = e;
        phone = "";
        age = "";

        levelOneScore = "";
        levelTwoScore = "";
        levelThreeScore = "";

        levelOneAttempts = 0;
        levelTwoAttempts = 0;
        levelThreeAttempts = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAge() {
        return age;
    }

    public String getLevelOneScore() {
        return levelOneScore;
    }

    public String getLevelTwoScore() {
        return levelTwoScore;
    }

    public String getLevelThreeScore() {
        return levelThreeScore;
    }

    public int getLevelOneAttempts() {
        return levelOneAttempts;
    }

    public int getLevelTwoAttempts() {
        return levelTwoAttempts;
    }

    public int getLevelThreeAttempts() {
        return levelThreeAttempts;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setLevelOneScore(String levelOneScore) {
        this.levelOneScore = levelOneScore;
    }

    public void setLevelTwoScore(String levelTwoScore) {
        this.levelTwoScore = levelTwoScore;
    }

    public void setLevelThreeScore(String levelThreeScore) {
        this.levelThreeScore = levelThreeScore;
    }

    public void setLevelOneAttempts(int levelOneAttempts) {
        this.levelOneAttempts = levelOneAttempts;
    }

    public void setLevelTwoAttempts(int levelTwoAttempts) {
        this.levelTwoAttempts = levelTwoAttempts;
    }

    public void setLevelThreeAttempts(int levelThreeAttempts) {
        this.levelThreeAttempts = levelThreeAttempts;
    }
}
