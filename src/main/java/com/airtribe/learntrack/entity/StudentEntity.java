package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.Utility;

public class StudentEntity extends Person {

    private String batch;
    private boolean active;

    public StudentEntity(String firstName,String lastName,String email,String batch,Boolean active) {
        super();
        this.setId(Utility.getNextStudentId());
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.batch = batch;
        this.active = active;
    }

    public StudentEntity(String firstName,String lastName,String batch,Boolean active) {
        super();
        this.setId(Utility.getNextStudentId());
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.batch = batch;
        this.active = active;
    }

    public String getBatch() {
        return batch;
    }
    public boolean getActive() {
        return active;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getDisplayNane() {
        return   "Hi, I am a  Student. My name is "+ this.getFirstName() + " " + this.getLastName();
    }
}
