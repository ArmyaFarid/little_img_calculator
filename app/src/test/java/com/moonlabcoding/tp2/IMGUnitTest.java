package com.moonlabcoding.tp2;

import org.junit.Test;

import static org.junit.Assert.*;

import com.moonlabcoding.tp2.model.IMHelper;
import com.moonlabcoding.tp2.model.User;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class IMGUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void calculate_IMG_isCorrect(){
        IMHelper mIMHelper=new IMHelper();
        int age = 16;
        char sex = 'H';
        int intSex = 1;
        Float poids = 45f;
        Float taille = 1.80f;
        User mUser = new User(age, poids, taille, sex);
        Float IMG = mUser.getIMG();
        Float expectedIMC = poids/(taille*taille);
        Float expectedImg = (1.20f*expectedIMC) + (0.23f*age)+(10.8f*intSex)-5.4f;
        String interpretation= mIMHelper.getIMGInterpretation(mUser.getSex(),IMG);
        assertEquals(expectedImg,IMG,0.001);
    }
}