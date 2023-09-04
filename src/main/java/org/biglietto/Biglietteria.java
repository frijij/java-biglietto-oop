package org.biglietto;

import java.math.BigDecimal;
import java.util.Scanner;

public class Biglietteria {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean isValid = false;
        while(!isValid) {
            System.out.println(("Numero di km: "));
            int km = Integer.parseInt(scan.nextLine());
            System.out.println("Età: ");
            int eta= Integer.parseInt(scan.nextLine());
            try {
                Biglietto biglietto = new Biglietto(km, eta);
                isValid = true;
                System.out.println("Biglietto valido");
            } catch (RuntimeException e) {
                System.out.println("Il numero di km e l'età devono essere maggiori di 0.");
            }

        }


        scan.close();
    }
}
