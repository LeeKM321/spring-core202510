package com.codeit.springcore.chap01;

public class WesternRestaurant {

    private JohnChef chef = new JohnChef();

    private WesternCourse course = new WesternCourse();

    public void order() {
        System.out.println("안녕하세요. 서양 레스토랑 입니다.");
        chef.cook();
        course.combineMenu();
    }

}
