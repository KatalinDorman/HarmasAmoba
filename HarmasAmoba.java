/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmasamoba;

import java.util.Scanner;

/**
 *
 * @author javaoktatas
 */
public class HarmasAmoba {

    public static void tablaInit(String[][] tabla) {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j] = " ";
            }
        }
    }

    public static void tablaRajzol(String[][] tabla) {
        System.out.println("    1   2   3 ");
        System.out.println("  +---+---+---+");
        System.out.println("A | " + tabla[0][0] + " | " + tabla[0][1] + " | " + tabla[0][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println("B | " + tabla[1][0] + " | " + tabla[1][1] + " | " + tabla[1][2] + " |");
        System.out.println("  +---+---+---+");
        System.out.println("C | " + tabla[2][0] + " | " + tabla[2][1] + " | " + tabla[2][2] + " |");
        System.out.println("  +---+---+---+");
    }

    public static int sorFeldolgoz(String lepes) {
        int sor = -1;
        switch (lepes.substring(0, 1)) {
            case "A":
                sor = 0;
                break;
            case "B":
                sor = 1;
                break;
            case "C":
                sor = 2;
                break;
        }
        return sor;
    }

    public static int oszlopFeldolgoz(String lepes) {
        int oszlop = -1;
        switch (lepes.substring(1)) {
            case "1":
                oszlop = 0;
                break;
            case "2":
                oszlop = 1;
                break;
            case "3":
                oszlop = 2;
                break;
        }
        return oszlop;
    }

    public static boolean nyertes(String[][] tabla) {
        boolean nyert = true;

        if (tabla[0][0].equals(tabla[0][1]) && tabla[0][0].equals(tabla[0][2]) && !tabla[0][0].equals(" ")) {
            return nyert;
        }
        if (tabla[1][0].equals(tabla[1][1]) && tabla[1][0].equals(tabla[1][2]) && !tabla[1][0].equals(" ")) {
            return nyert;
        }
        if (tabla[2][0].equals(tabla[2][1]) && tabla[2][0].equals(tabla[2][2]) && !tabla[2][0].equals(" ")) {
            return nyert;
        }

        if (tabla[0][0].equals(tabla[1][0]) && tabla[0][0].equals(tabla[2][0]) && !tabla[0][0].equals(" ")) {
            return nyert;
        }

        if (tabla[0][1].equals(tabla[1][1]) && tabla[0][1].equals(tabla[2][1]) && !tabla[0][1].equals(" ")) {
            return nyert;
        }

        if (tabla[0][2].equals(tabla[1][2]) && tabla[0][2].equals(tabla[2][2]) && !tabla[0][2].equals(" ")) {
            return nyert;
        }

        if (tabla[0][0].equals(tabla[1][1]) && tabla[0][0].equals(tabla[2][2]) && !tabla[0][0].equals(" ")) {
            return nyert;
        }
        if (tabla[0][2].equals(tabla[1][1]) && tabla[0][2].equals(tabla[2][0]) && !tabla[0][2].equals(" ")) {
            return nyert;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean vege = false;
        boolean csere = true;

        String aktJatekos = "O";
        String jatekosCsere = "X";
        String[][] tabla = new String[3][3];
        tablaInit(tabla);
        tablaRajzol(tabla);
        int lepesSzam = 0;
        do {

            if (csere) {
                String tmp = aktJatekos;
                aktJatekos = jatekosCsere;
                jatekosCsere = tmp;
            }

            //jatekoscsere
            String lepes;

            int sor;
            int oszlop;
            do {

                System.out.print("Kérem a " + aktJatekos + " játékos lépését: ");
                lepes = sc.nextLine();
                lepes = lepes.toUpperCase();
                sor = sorFeldolgoz(lepes);
                oszlop = oszlopFeldolgoz(lepes);

                if (sor == -1 || oszlop == -1) {
                    System.out.println("Csak A,B,C és 1,2,3 értékeket adj meg!");
                } else if (!tabla[sor][oszlop].equals(" ")) {
                    System.out.println("Ez a mező már foglalt!");
                } else {
                    lepesSzam++;
                }

            } while (lepes.isEmpty() || sor == -1 || oszlop == -1 || !tabla[sor][oszlop].equals(" "));

            //játékos lép
            //lepes feldolgozas - A1 [0,0] 
            tabla[sor][oszlop] = aktJatekos;
            tablaRajzol(tabla);// kirajzoljuk
            if (lepesSzam == 9 || nyertes(tabla)) {
                vege = true;
                if (lepesSzam == 9 & !nyertes(tabla)) {
                    System.out.println("Az eredmény döntetlen!");
                } else {
                    System.out.println("Az " + aktJatekos + " játékos nyert!");
                }
            }

            //vége van e a játéknak?
            //betelt a tábla - döntetlen, 
//            
        } while (!vege);

        System.out.println("A játéknak vége.");  //kiirjuk, hogy mi lett a vége

    }

}
