package ru.job4j.inheritance;

public class Mathematics extends Teacher {
    private String sectionOfMathematics;
    private String academicDegree;
    public String getSectionOfMathematics() {
        return this.sectionOfMathematics;
    }
    public String getAcademicDegree() {
        return this.academicDegree;
    }
}
