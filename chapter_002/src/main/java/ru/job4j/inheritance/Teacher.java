package ru.job4j.inheritance;

public class Teacher extends Profession {
    private String educationalInstitution;
    private String category;
    public String getEducationalInstitution() {
        return this.educationalInstitution;
    }
    public String getCategory() {
        return this.category;
    }


}
