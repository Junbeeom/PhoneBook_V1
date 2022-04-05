package com.phonebook.apllication;

import java.util.HashMap;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhoneBook {
    private String userName, userNumber, userEmail, secondName, newNumber, newEmail;
    private int cnt = 1;

    PhoneBook() {};

    HashMap<String, PhoneUserData> phone_dic = new HashMap<>();

    //등록하기
    public void registered() {
        Scanner scanner = new Scanner(System.in);
        PhoneUserData userData = new PhoneUserData();

        //1.이름 등록
        System.out.println("등록할 이름을 입력하세요 : ");
        userName = scanner.next();

        if(phone_dic.get(userName) != null) {
            //중복된 이름이 있다면
            userName = userName + cnt;
            userData.setName(userName);

            cnt++;

            System.out.println("동명이인이 존재하여 귀하의 성명 " + userName + "로 저장되었습니다.");
        }

        //2.핸드폰 번호 등록
        boolean flag = true;
        while (flag) {
            System.out.println("번호를 입력하세요 : ");
            userNumber = scanner.next();

            char arr[] = userNumber.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                if (Character.isDigit(arr[i])) {
                    userNumber = userNumber.replaceAll("[^0-9]", "");
                    flag = false;
                } else {
                    System.out.println("문자를 제외한 숫자만 저장됩니다.");
                    break;
                }
            }
        }

        //3.이메일 등록
        while (true) {
            String emailCheck = "^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$";

            System.out.print("이메일 : ");
            userEmail = scanner.next();

            if (userEmail.matches(emailCheck) == true) {
                userEmail = userEmail;
                break;
            } else {
                System.out.println("올바른 형식을 입력하세요. ex)wns_p@naver.com");
            }
        }

        //4.등록 일시
        SimpleDateFormat format1 = new SimpleDateFormat( "yyyy.MM.dd HH:mm:ss");
        Date time = new Date();
        String registeredTime = format1.format(time);

        phone_dic.put(userName, new PhoneUserData(userName, userNumber, userEmail, registeredTime, "없음"));

        System.out.println();
        System.out.println(userName + "의 정보가 등록 완료 되었습니다. ");
        System.out.println("등록일시 : " + registeredTime);
    }

    //삭제하기
    public void deleted() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("삭제하실 이름을 입력하세요.");
        userName = scanner.next();

        if(phone_dic.get(userName) == null) {
            System.out.println("존재하지 않는 이름입니다");
        } else {
            System.out.println("삭제 1번, 취소 2번");
            int deleteNumber = scanner.nextInt();
            switch (deleteNumber) {
                case 1:
                    phone_dic.remove(userName);
                    System.out.println(userName + "의 정보가 삭제되었습니다.");
                    break;
                default:
                    System.out.println("취소 되었습니다");
                    break;
            }
        }
    }

    //검색하기
   public void search() {
       Scanner scanner = new Scanner(System.in);

       System.out.println("이름을 입력하세요");
       String searchName = scanner.next();

       boolean flag = false;
       for (String key : phone_dic.keySet()) {
           if (key.contains(searchName) == true) {
               System.out.println(phone_dic.get(key).toString());
               flag = true;
           }
       }

       if(!flag) {
           System.out.println("등록된 이름이 없습니다.");
       }
   }

    //수정하기
    public void modified() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("수정하실 이름을 입력하세요. ex)1조준범");
        String inputName = scanner.next();

        if(phone_dic.get(inputName) == null) {
            System.out.println("존재하지 않는 이름입니다");
        } else {
            System.out.println("수정하실 항목을 선택하세요 1.이름 2.전화번호 3.이메일");
            int choiceNumber = scanner.nextInt();

            switch (choiceNumber) {
                //이름 변경
                case 1:
                    System.out.println("변경하실 이름을 입력하세요.");
                    String newName = scanner.next();

                    System.out.println("변경 1번, 취소 2번");
                    int switchNumber = scanner.nextInt();

                    switch (switchNumber) {
                        case 1:
                            SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss");
                            Date time2 = new Date();
                            String modifyTime = format2.format(time2);

                            phone_dic.get(inputName).setModifyTime(modifyTime);

                            if(phone_dic.containsKey(newName)) {
                                newName = newName + cnt;
                                cnt++;

                                System.out.println("동명이인이 존재하여 귀하의 성명은 " + newName + "로 저장되었습니다.");
                            }

                            phone_dic.get(inputName).setName(newName);
                            phone_dic.put(newName, phone_dic.get(inputName));

                            phone_dic.remove(inputName);

                            System.out.println("수정이 완료되었습니다.\n수정일시 : " + modifyTime);
                            break;

                        case 2:
                            System.out.println("취소 되었습니다");
                            break;
                    }
                    break;

                //휴대전화 번호 수정
                case 2:
                    boolean flag = true;
                    while (flag) {
                        System.out.println("변경하실 번호를 입력하세요 : ");
                        userNumber = scanner.next();

                        char arr[] = userNumber.toCharArray();

                        for (int i = 0; i < arr.length; i++) {
                            if (Character.isDigit(arr[i]) == true) {
                                newNumber = userNumber.replaceAll("[^0-9]", "");
                                flag = false;
                            } else {
                                System.out.println("문자를 제외한 숫자만 저장됩니다.");
                                break;
                            }
                        }
                    }
                    System.out.println("정말 변경 하실 껀가요? 변경 1번, 취소 2번");
                    int switchNumber2 = scanner.nextInt();

                    switch (switchNumber2) {
                        case 1:
                            //전화번호 수정 로직
                            phone_dic.get(inputName).setNumber(newNumber);

                            SimpleDateFormat format2 = new SimpleDateFormat( "yyyy.MM.dd HH:mm:ss");
                            Date time2 = new Date();
                            String modifyTime = format2.format(time2);

                            System.out.println("수정이 완료되었습니다.\n수정일시 : " + modifyTime);

                            phone_dic.get(inputName).setModifyTime(modifyTime);
                            break;

                        case 2:
                            System.out.println("취소 되었습니다");
                            break;
                    }
                    break;

                //이메일 주소 변경
                case 3:
                    boolean flag2 = true;
                    while (flag2) {
                        String emailCheck = "^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$";

                        System.out.println("변경하실 이메일을 입력하세요.");
                        userEmail = scanner.next();

                        if (userEmail.matches(emailCheck) == true) {
                            newEmail = userEmail;
                            flag2 = false;
                        } else {
                            System.out.println("올바른 형식을 입력하세요. ex)wns_p@naver.com");
                        }
                    }
                    System.out.println("정말 변경 하실 껀가요? 변경 1번, 취소 2번");
                    int switchNumber3 = scanner.nextInt();

                    switch (switchNumber3) {
                        case 1:
                           //이메일 주소 변경 로직
                            phone_dic.get(inputName).setEmail(newEmail);

                            SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss");
                            Date time2 = new Date();
                            String modifyTime = format2.format(time2);

                            phone_dic.get(inputName).setModifyTime(modifyTime);
                            System.out.println("수정이 완료되었습니다.\n수정일시 : " + modifyTime);
                            break;
                        case 2:
                            System.out.println("취소 되었습니다");
                            break;
                    }

            }
        }

    }

    //목록보기
    public void list() {
        for (PhoneUserData phoneBookList : phone_dic.values()){
            System.out.println(phoneBookList.toString());
            System.out.println();
        }
    }
}
