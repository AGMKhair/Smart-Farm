package com.securesoftbd.smart_farm.Model;

public class User {
    private String id;
    private String name;
    private String age;
    private String profileImage;
    private String gender;

    public User(String id, String name, String age, String profileImage, String genger) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.profileImage = profileImage;
        this.gender = genger;
    }


    public User( String name, String age, String profileImage, String gender)
    {
        this.age = age;
        this.name = name;
        this.profileImage = profileImage;
        this.gender = gender;
    }

    public User(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getGenger() {
        return gender;
    }

    public void setGenger(String genger) {
        this.gender = genger;
    }
}
