package com.phonebook.apllication;

import java.util.Scanner;

public class PhoneBookFrame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PhoneBook phoneBook = new PhoneBook();

        boolean flag = true;

        while(flag) {
            System.out.println("======");
            System.out.println("1.등록");
            System.out.println("2.삭제");
            System.out.println("3.검색");
            System.out.println("4.수정");
            System.out.println("5.목록");
            System.out.println("6.종료");
            System.out.println("======");

            switch(sc.nextInt()) {
                //전화번호 등록 메서드 호출
                case 1:
                    //registered 메서드 적기
                    phoneBook.registered();
                    break;
                case 2:
                    //deleted 메서드 적기
                    phoneBook.deleted();
                    break;
                case 3:
                    //search 메서드 적기
                    phoneBook.search();
                    break;
                case 4:
                    //modified 메서드 적기
                    phoneBook.modified();
                    break;
                case 5:
                    //list 메서드 적기
                    phoneBook.list();
                    break;
                //종료
                default:
                    flag = false;
            }
        }
        sc.close();
    }
}
