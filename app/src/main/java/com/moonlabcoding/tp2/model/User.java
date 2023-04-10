package com.moonlabcoding.tp2.model;

public class User {
    private int mAge;
    private Float mPoids;
    private Float mTaille;
    private char mSex;

    public int getAge() {
        return mAge;
    }

    public Float getPoids() {
        return mPoids;
    }

    public Float getTaille() {
        return mTaille;
    }

    public char getSex() {
        return mSex;
    }

    private Float mIMC;
    private Float mIMG;

    public void setAge(int age) {
        mAge = age;
    }

    public void setPoids(Float poids) {
        mPoids = poids;
    }

    public void setTaille(Float taille) {
        mTaille = taille;
    }

    public void setSex(char sex) {
        mSex = sex;
    }

    private IMHelper mIMHelper;

    public Float getIMC() {
        return mIMC;
    }

    public void setIMC(Float IMC) {
        mIMC = IMC;
    }

    public void setIMG(Float IMG) {
        mIMG = IMG;
    }

    public User(int age, Float poids, Float taille, char sex) {
        this.mAge = age;
        this.mPoids = poids;
        this.mTaille = taille;
        this.mSex = sex;
    }

    public User() {

    }

    private void setIMG(){
        mIMHelper =new IMHelper();
        mIMC = mIMHelper.calculateIMC(mPoids, mTaille/100);
        mIMG = mIMHelper.calculateIMG(mIMC, mAge, mSex);
    }

    public Float getIMG() {
        setIMG();
        return mIMG;
    }


}
