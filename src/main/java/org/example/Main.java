package org.example;

import java.io.PrintStream;
import java.util.Scanner;

class Pokemon {
    protected static int count = 0;
    protected String __hidden_owner, owner;
    protected String[] skills;
    public Pokemon() {

    }
    public Pokemon (String owner, String skills) {
        this.__hidden_owner = owner;
        this.skills =skills.split("/");
        PrintStream printf = System.out.printf("포켓몬 생성 :", "<br>");
        count = count + 1;
    }
    public String owner() {
        return __hidden_owner;
    }
    public void owner(String owner) {
        this.__hidden_owner = owner;
    }
    public void info() {
        System.out.printf("%s의 포켓몬이 사용 가능한 스킬", this.owner);
        for (int i =0; i<skills.length; i++) {
            System.out.printf("%d : %s", i+1, this.skills[i]);
        }
    }
    public void attack(int idx) {
        System.out.printf("%s 공격 시전!", this.skills[idx]);
    }
}

class Pikachu extends Pokemon {
    String name = null;

    public Pikachu(String owner, String skills) {
        super(owner, skills);
        this.name = "피카츄";
        System.out.printf("%s", this.name);
    }

    public void attack(int idx) {
        System.out.printf("[삐까삐까] %s의 %s가 %s 공격 시전!", this.owner, this.name, this.skills[idx]);
    }
}

class Ggoboogi extends Pokemon {
    String name = null;
    public Ggoboogi(String owner, String skills) {
        super(owner, skills);
        this.name = "꼬부기";
        System.out.printf("%s", this.name);
    }
    public void attack(int idx) {
        System.out.printf("[꼬북꼬북] %s의 %s가 %s 공격 시전!", this.owner, this.name, this.skills[idx]);
    }
    public void swim() {
        System.out.printf("%s가 수영을 합니다", this.name);
    }
}

class Pairi extends Pokemon {
    String name = null;
    public Pairi(String owner, String skills) {
        super(owner, skills);
        this.name = "파이리";
        System.out.printf("%s", this.name);
    }
    public void attack(int idx) {
        System.out.printf("[파읠파읠] %s의 %s가 %s 공격(불) 시전!", this.owner, this.name, this.skills[idx]);
    }
}

public class Main {
    public static String n, s = null;
    public static int menu, pokemon, attack_menu = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        while(true) {
            System.out.printf("총 %d마리의 포켓몬이 생성되었습니다", Pokemon.count);
            System.out.printf("1) 포켓몬 생성  2) 프로그램 종료 : ");
            menu = sc.nextInt();
            if (menu == 2 ) {
                System.out.printf("프로그램을 종료합니다");
                break;
            }
            else if (menu == 1) {
                System.out.printf("1) 피카츄  2) 꼬부기  3) 파이리 : ");
                pokemon = sc.nextInt();
                System.out.printf("플레이어 이름 입력 : ");
                n = sc.next();
                System.out.printf("사용 가능한 기술 입력(/로 구분하여 입력) : ");
                s = sc.next();
                if (pokemon == 1) {
                    Pikachu p = new Pikachu(n, s);
                    p.info();
                    System.out.printf("공격 번호 선택 : ");
                    attack_menu = sc.nextInt();
                    p.attack(attack_menu - 1);
                }
                else if (pokemon == 2) {
                    Ggoboogi p = new Ggoboogi(n, s);
                    p.info();
                    System.out.printf("공격 번호 선택 : ");
                    attack_menu = sc.nextInt();
                    p.attack(attack_menu - 1);
                }
                else if (pokemon == 3) {
                    Pairi p = new Pairi(n, s);
                    p.info();
                    System.out.printf("공격 번호 선택 : ");
                    attack_menu = sc.nextInt();
                    p.attack(attack_menu - 1);
                }
                else {
                    System.out.printf("메뉴에서 골라 주세요");
                }



            }
            else {
                System.out.printf("메뉴에서 골라 주세요");
            }


        }






    }

}
