package org.biglietto;

import java.math.BigDecimal;

public class Biglietto {
 private int km;
 private int eta;

 private final BigDecimal COSTO = new BigDecimal("0.21");
 private final BigDecimal SCONTOOVER65 = new BigDecimal("0.4");
 private final BigDecimal SCONTOMINORI = new BigDecimal("0.2");


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
    BigDecimal SCONTO = new BigDecimal("0");
    if(eta<18){
        SCONTO = SCONTOMINORI;
    } else if(eta>65){
        SCONTO = SCONTOOVER65;
    }
    return SCONTO;
}

    // calcolaPrezzo: calcola il prezzo del biglietto comprensivo di eventuale sconto; richiama metodo calcolaSconto
    public BigDecimal calcolaPrezzo(Biglietto){
        BigDecimal KM = BigDecimal.valueOf(km);
        BigDecimal PREZZO =KM.multiply(COSTO);
        BigDecimal PREZZOTOTALE = PREZZO.subtract(calcolaSconto(eta));
        return PREZZOTOTALE;
    }
}
