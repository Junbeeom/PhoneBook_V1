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
                case 1:
                    phoneBook.registered();
                    break;
                case 2:
                    phoneBook.deleted();
                    break;
                case 3:
                    phoneBook.search();
                    break;
                case 4:
                    phoneBook.modified();
                    break;
                case 5:
                    phoneBook.list();
                    break;
                default:
                    flag = false;
            }
        }
        sc.close();
    }
}
