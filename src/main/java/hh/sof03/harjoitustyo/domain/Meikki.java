package hh.sof03.harjoitustyo.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Meikki {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long meikki_id;
    private String meikkinimi;
    @Column(name = "hankinta-aika")
    private LocalDate meikkihankinta;
    private double meikki_hinta;

    @ManyToOne
    @JsonIgnoreProperties("meikit")
    @JoinColumn(name = "kategoria_id")
    private Kategoria kategoria;

    public Meikki() {
    }

    public Meikki(String meikkinimi, LocalDate meikkihankinta, double meikki_hinta, Kategoria kategoria) {
        this.meikkinimi = meikkinimi;
        this.meikkihankinta = meikkihankinta;
        this.meikki_hinta = meikki_hinta;
        this.kategoria = kategoria;
    }

    public Meikki(Long meikki_id, String meikkinimi, LocalDate meikkihankinta, double meikki_hinta,
            Kategoria kategoria) {
        this.meikki_id = meikki_id;
        this.meikkinimi = meikkinimi;
        this.meikkihankinta = meikkihankinta;
        this.meikki_hinta = meikki_hinta;
        this.kategoria = kategoria;
    }

    public Long getMeikki_id() {
        return meikki_id;
    }

    public void setMeikki_id(Long meikki_id) {
        this.meikki_id = meikki_id;
    }

    public String getMeikkinimi() {
        return meikkinimi;
    }

    public void setMeikkinimi(String meikkinimi) {
        this.meikkinimi = meikkinimi;
    }

    public LocalDate getMeikkihankinta() {
        return meikkihankinta;
    }

    public void setMeikkihankinta(LocalDate meikkihankinta) {
        this.meikkihankinta = meikkihankinta;
    }

    public double getMeikki_hinta() {
        return meikki_hinta;
    }

    public void setMeikki_hinta(double meikki_hinta) {
        this.meikki_hinta = meikki_hinta;
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
            return "Meikki [meikkinimi=" + meikkinimi + ", meikkihankinta=" + meikkihankinta + ", meikki_hinta="
                    + meikki_hinta + ", kategoria=" + kategoria + "]";
        } else {
            return "Meikki [meikkinimi=" + meikkinimi + ", meikkihankinta=" + meikkihankinta + ", meikki_hinta="
                    + meikki_hinta + "]";
        }

    }

}
