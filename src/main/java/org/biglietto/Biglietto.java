package org.biglietto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {

    /* Alla classe Biglietto aggiungere i seguenti attributi:
● data: LocalDate
● flessibile: boolean
Entrambi gli attributi vanno valorizzati nel costruttore.
Aggiungere due costanti:
● durata normale: 30 giorni (int)
● durata flessibile: 90 giorni (int)
 Nel metodo che calcola il prezzo, se il biglietto è flessibile, maggiorare il prezzo del 10%.
Modificare la classe Biglietteria in modo che, alla creazione del Biglietto, valorizzi la data con la data odierna e il parametro flessibile in base alla scelta dell’utente. Dopo aver stampato il prezzo del biglietto, stampare a video anche la data di scadenza.
*/

    // ATTRIBUTI
 private int km;
 private int eta;

 private final BigDecimal COSTO_KM = new BigDecimal("0.21");
 private final BigDecimal SCONTO_OVER_65 = new BigDecimal("0.6");
 private final BigDecimal SCONTO_MINORI = new BigDecimal("0.8");

 private LocalDate data;
 private boolean flessibile;
 private final int DURATA_BIGLIETTO_NORMALE = 30;
 private final int DURATA_BIGLIETTO_FLESSIBILE = 90;

    //COSTRUTTORI
public Biglietto(int km, int eta, LocalDate data, boolean flessibile) throws RuntimeException {
  this.km=km;
  this.eta= eta;
  isValidKm(this.km);
  isValidEta(this.eta);
  this.data= data;
  this.flessibile=flessibile;
}

    // METODI
private boolean isValidKm(int km) {
        if (km<=0){
            throw new RuntimeException();
        }
        return true;
    }

    private boolean isValidEta(int eta) {
        if (eta<0){
            throw new RuntimeException();
        }
        return true;
    }

private BigDecimal calcolaSconto(int eta){
    BigDecimal sconto = new BigDecimal("1");
    if(eta<18){
        sconto = SCONTO_MINORI;
    } else if(eta>65){
        sconto = SCONTO_OVER_65;
    }
    return sconto;
}

    public BigDecimal calcolaPrezzo(int km, int eta){
        BigDecimal kmViaggio = BigDecimal.valueOf(km);
        BigDecimal prezzo =kmViaggio.multiply(COSTO_KM).multiply(calcolaSconto(eta));
        return prezzo;
    }

    public LocalDate calcolaDataScadenza(LocalDate data, boolean flessibile){
        LocalDate dataScadenza;
        if (flessibile){
            dataScadenza=data.plusDays(DURATA_BIGLIETTO_FLESSIBILE);
        } else {
            dataScadenza=data.plusDays(DURATA_BIGLIETTO_NORMALE);
        }
            return dataScadenza;
    }
}
