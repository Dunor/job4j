package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String projectName;
    private String position;
    public String getPosition() {
        return this.position;
    }
    public String getProjectName() {
        return this.projectName;
    }
}
