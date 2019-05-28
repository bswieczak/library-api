package com.mgr.spring.dto;

public class WypozyczeniaRequestDto {

    private Integer czytelnikId;

    private Integer ksiazkaId;

    private Integer pracownikWypozyczenieId;

    private Integer pracownikOddanieId;

    public Integer getCzytelnikId() {
        return czytelnikId;
    }

    public Integer getKsiazkaId() {
        return ksiazkaId;
    }

    public Integer getPracownikWypozyczenieId() {
        return pracownikWypozyczenieId;
    }

    public Integer getPracownikOddanieId() {
        return pracownikOddanieId;
    }
}
