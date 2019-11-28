package ru.ifmo.itcenter;

import junit.framework.Assert;
import org.junit.Test;
import ru.ifmo.itcenter.User;

import java.util.*;

/**
 * Created by Roman Petrov
 */
public class UserTest {

    @Test
    public void expiredTest(){
        User user = new User();
        user.setPasswordUpdated(new Date());
        Assert.assertFalse(user.isPasswordExpired());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        calendar.add(Calendar.HOUR, -1);

        user.setPasswordUpdated(calendar.getTime());
        Assert.assertTrue(user.isPasswordExpired());

        calendar.add(Calendar.HOUR, 2);
        user.setPasswordUpdated(calendar.getTime());
        Assert.assertFalse(user.isPasswordExpired());
    }

    @Test
    public void testPasswordValid(){
        User user = new User();
        user.setPassword("123456f");
        Assert.assertFalse(user.isPasswordValid());


        user.setPassword("12345678");
        Assert.assertFalse(user.isPasswordValid());


        user.setPassword("abcdabcd");
        Assert.assertFalse(user.isPasswordValid());


        user.setPassword("1234567g");
        Assert.assertTrue(user.isPasswordValid());
    }

    @Test
    public void testPasswordGenerator(){
        int N = 10000;
        List<String> passwords = new ArrayList<>(N);
        User user = new User();
        for(int i = 0; i < N; i++){
            String pass = User.generateRandomPassword();
            user.setPassword(pass);
            Assert.assertTrue(user.isPasswordValid());
            Assert.assertFalse(passwords.contains(pass));
            passwords.add(pass);
        }
    }
}

