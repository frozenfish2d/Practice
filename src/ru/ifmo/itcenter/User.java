package ru.ifmo.itcenter;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Roman Petrov
 */
public class User {
    private long id;
    private String name;
    private String password;

    /*
        Дата последнего обновления пароля
     */
    private Date passwordUpdated;


    public User(long id, String name, String password, Date passwordUpdated) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.passwordUpdated = passwordUpdated;
    }

    public static User newUser(long id, String name) {
        return new User(id, name, generateRandomPassword(), new Date());
    }

    public User() {
    }

    /**
     * @return true если последнее обновление пароля было год назад или более, false в противоположном случае
     */
    public boolean isPasswordExpired() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);


        return calendar.getTime().after(passwordUpdated);
    }

    /*
        Пароль валидный если он >= 8 символов, содержит как минимумум 1 цифру, 1 латинскую букву.
     */
    public boolean isPasswordValid() {
        Pattern pattern;
        Matcher matcher;
        //pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{6,20}");
        pattern = Pattern.compile("[a-zA-Z0-9]{8,20}");
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /*
        Генерирует случайный пароль.

     */
    public static String generateRandomPassword() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int rand = 0;
            while (rand < 65 || rand > 90) {
                rand = (int) (Math.random() * 200);
            }
            stringBuilder.append((char) rand);
        }
        for (int i = 0; i < 3; i++) {
            int rand = 0;
            while (rand < 48 || rand > 57) {
                rand = (int) (Math.random() * 200);
            }
            stringBuilder.append((char) rand);
        }
        for (int i = 0; i < 2; i++) {
            int rand = 0;
            while (rand < 97 || rand > 122) {
                rand = (int) (Math.random() * 200);
            }
            stringBuilder.append((char) rand);
        }

        //System.out.println(stringBuilder.toString());

        return stringBuilder.toString();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getPasswordUpdated() {
        return passwordUpdated;
    }

    public void setPasswordUpdated(Date passwordUpdated) {
        this.passwordUpdated = passwordUpdated;
    }
}
