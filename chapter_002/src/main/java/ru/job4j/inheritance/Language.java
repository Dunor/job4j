package ru.job4j.inheritance;

public class Language extends Teacher {
    private String whatLanguage;
    private boolean nativeSpeaker;
    public String getWhatLanguage() {
        return this.whatLanguage;
    }
    public boolean getNativeSpeaker() {
        return this.nativeSpeaker;
    }
}
