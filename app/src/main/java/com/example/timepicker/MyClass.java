package com.example.timepicker;

public class MyClass {
    private String time;
    private String note;

    public MyClass(String time, String note) {
        this.time = time;
        this.note = note;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
