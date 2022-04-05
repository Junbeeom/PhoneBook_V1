package com.phonebook.apllication;

public class PhoneUserData {

    private String name;
    private String number;
    private String email;
    private String registeredTime;
    private String modifyTime;

    public PhoneUserData() {}

    public PhoneUserData(String name, String number, String email, String registeredTime, String modifyTime) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.registeredTime = registeredTime;
        this.modifyTime = modifyTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String toString() {
        return String.format("이    름 : %s\n전화번호 : %s\n메    일 : %s\n등록일시 : %s\n수정일시 : %s", name, number, email, registeredTime, modifyTime);
    }
}


