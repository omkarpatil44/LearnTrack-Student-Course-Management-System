package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.constant.TrainerType;

public class TrainerEntity extends Person{

    private TrainerType type;

    public TrainerEntity(String firstName,String lastName,String email,TrainerType type) {
        super();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.type = type;
    }

    public TrainerType getType() {
        return type;
    }

    public void setType(TrainerType type) {
        this.type = type;
    }


    @Override
    public String getDisplayNane() {
        return  "Hi I am "+ this.getType() +". My name is "+ this.getFirstName() +" "+ this.getLastName() ;
    }
}
