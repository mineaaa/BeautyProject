package hh.sof03.harjoitustyo.domain;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Kynsilakka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long lakka_id;
    @NotEmpty
    private String lakka_nimi;
    private String lakkaVari;
    private LocalDate lakka_hankinta;

    @ManyToOne
    @JsonIgnoreProperties("kynsilakat")
    @JoinColumn(name = "kategoria_id")
    private Kategoria kategoria;

    public Kynsilakka(String lakka_nimi, String lakkaVari, LocalDate lakka_hankinta, Kategoria kategoria) {
        this.lakka_nimi = lakka_nimi;
        this.lakkaVari = lakkaVari;
        this.lakka_hankinta = lakka_hankinta;
        this.kategoria = kategoria;
    }

    public Kynsilakka() {
    }

    public Kynsilakka(long lakka_id, String lakka_nimi, String lakkaVari, LocalDate lakka_hankinta,
            Kategoria kategoria) {
        this.lakka_id = lakka_id;
        this.lakka_nimi = lakka_nimi;
        this.lakkaVari = lakkaVari;
        this.lakka_hankinta = lakka_hankinta;
        this.kategoria = kategoria;
    }

    public long getLakka_id() {
        return lakka_id;
    }

    public void setLakka_id(long lakka_id) {
        this.lakka_id = lakka_id;
    }

    public String getLakka_nimi() {
        return lakka_nimi;
    }

    public void setLakka_nimi(String lakka_nimi) {
        this.lakka_nimi = lakka_nimi;
    }

    public String getLakkaVari() {
        return lakkaVari;
    }

    public void setLakkaVari(String lakkaVari) {
        this.lakkaVari = lakkaVari;
    }

    public LocalDate getLakka_hankinta() {
        return lakka_hankinta;
    }

    public void setLakka_hankinta(LocalDate lakka_hankinta) {
        this.lakka_hankinta = lakka_hankinta;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        if (this.kategoria != null) {
            return "Kynsilakka [lakka_nimi=" + lakka_nimi + ", lakka_vari=" + lakkaVari + ", lakka_hankinta="
                    + lakka_hankinta + ", kategoria=" + kategoria + "]";
        } else {
            return "Kynsilakka [lakka_nimi=" + lakka_nimi + ", lakka_vari=" + lakkaVari + ", lakka_hankinta="
                    + lakka_hankinta + "]";
        }

    }

}
