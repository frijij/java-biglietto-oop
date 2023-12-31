package org.biglietto;

import java.math.BigDecimal;
import java.time.LocalDate;
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
            LocalDate data = LocalDate.now();
            System.out.println("Biglietto flessibile? (Y/N)");
            String tipo = scan.nextLine();
            boolean flessibile=false;
            switch (tipo.toLowerCase()) {
                case "n":
                    flessibile=false;
                    break;
                case "y":
                    flessibile=true;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }

            try {
                Biglietto biglietto = new Biglietto(km, eta, data, flessibile);
                isValid = true;
                System.out.println("Ecco il tuo biglietto:");
                System.out.println("Prezzo: " + biglietto.calcolaPrezzo(km, eta) + " €.");
                System.out.println("Scadenza biglietto: " + biglietto.calcolaDataScadenza(data, flessibile));
            } catch (RuntimeException e) {
                System.out.println("Il numero di km e l'età devono essere maggiori di 0.");
            }
        }



        scan.close();
    }
}
