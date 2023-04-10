package com.moonlabcoding.tp2.model;

public class IMHelper {

    public Float calculateIMC(Float poids, Float taille){
        return poids/(taille*taille);
    }

    private int getSexValue(char sex){
        if (sex=='H'){
            return 1;
        }
        return 0;
    }

    private static void initIMGConstants(int age,Float C1, Float C2, Float C3,Float C4){
        if(age<16){
            C1=1.51f;
            C2=0.70f;
            C3=3.6f;
            C4=1.4f;
        }else {
            C1=1.20f;
            C2=0.23f;
            C3=10.8f;
            C4=5.4f;
        }
    }

    public Float calculateIMG(Float IMC,int age , char sex){
        Float C1;
        Float C2;
        Float C3;
        Float C4;
        int sexValue;
        sexValue=getSexValue(sex);
        if(age<=16){
            C1=1.20f;
            C2=0.23f;
            C3=10.8f;
            C4=-5.4f;
        }else {
            C1=1.51f;
            C2=0.70f;
            C3=3.6f;
            C4=1.4f;
        }
        return (C1*IMC)+(C2*age)+(C3*sexValue)+C4;
    }

    public String getIMGInterpretation(char sex, Float IMG){
        if(sex=='H'){
            if (IMG<15f){
                return "Trop maigre";
            }else {
                if (IMG<20f){
                    return "Pourcentage normal";
                }else{
                    return "Trop de graisse";
                }
            }
        }else {
            if (IMG<25f){
                return "Trop maigre";
            }else {
                if (IMG<30f){
                    return "Pourcentage normal";
                }else{
                    return "Trop de graisse";
                }
            }
        }
    }




}
