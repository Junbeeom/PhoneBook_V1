package com.phonebook.apllication;

public class PhoneUserData {

    private String name;
    private String number;
    private String email;
    private String registeredTime;
    private String modifyTime;

    public PhoneUserData() {}

    //(등록을 위한) 이름, 전화번호부, 이메일 등록하기
    public PhoneUserData(String name, String number, String email, String registeredTime, String modifyTime) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.registeredTime = registeredTime;
        this.modifyTime = modifyTime;
    }


    public String getName() {
        return name;
    }
    // 접근제한자 리턴타입 메소드명(매개변수) { 바디 ?}
    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return  number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return  email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegisteredTime() {
        return registeredTime;
    }
    public void setRegisteredTime(String registeredTime) {
        this.registeredTime = registeredTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String toString() {
        return String.format("이    름 : %s\n전화번호 : %s\n메    일 : %s\n등록일시 : %s\n수정일시 : %s", name, number, email, registeredTime, modifyTime);
    }
}


