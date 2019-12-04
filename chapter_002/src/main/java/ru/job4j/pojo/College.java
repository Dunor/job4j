package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Кудряшов М.В.");
        student.setGroup("Android");
        student.setReceipt(new Date());
        System.out.println("name: " + student.getFio() + ", группа: "
                + student.getGroup() + ", дата поступления: " + student.getReceipt());
    }
}
