package org.biglietto;

import java.math.BigDecimal;

public class Biglietto {
 private int km;
 private int eta;

 private final BigDecimal COSTO_KM = new BigDecimal("0.21");
 private final BigDecimal SCONTO_OVER_65 = new BigDecimal("0.6");
 private final BigDecimal SCONTO_MINORI = new BigDecimal("0.8");


    //COSTRUTTORI
public Biglietto(int km, int eta) throws RuntimeException {
  this.km=km;
  this.eta= eta;
  isValidKm(this.km);
  isValidEta(this.eta);
}

    // METODI
    // isValidKm: se non valido sollevare eccezione
private boolean isValidKm(int km) {
        if (km<=0){
            throw new RuntimeException();
        }
        return true;
    }

    // isValidEta: se non valido sollevare eccezione
    private boolean isValidEta(int eta) {
        if (eta<0){
            throw new RuntimeException();
        }
        return true;
    }

    //calcolaSconto: metodo private
private BigDecimal calcolaSconto(int eta){
    BigDecimal sconto = new BigDecimal("1");
    if(eta<18){
        sconto = SCONTO_MINORI;
    } else if(eta>65){
        sconto = SCONTO_OVER_65;
    }
    return sconto;
}

    // calcolaPrezzo: calcola il prezzo del biglietto comprensivo di eventuale sconto; richiama metodo calcolaSconto
    public BigDecimal calcolaPrezzo(int km, int eta){
        BigDecimal kmViaggio = BigDecimal.valueOf(km);
        BigDecimal prezzo =kmViaggio.multiply(COSTO_KM).multiply(calcolaSconto(eta));
        return prezzo;
    }
}
