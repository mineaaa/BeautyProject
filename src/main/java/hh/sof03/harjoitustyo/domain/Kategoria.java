package hh.sof03.harjoitustyo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Kategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long kategoria_id;
    private String tuotetyyppi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoria")
    @JsonIgnoreProperties("kategoria")
    private List<Meikki> meikit;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoria")
    @JsonIgnoreProperties("kategoria")
    private List<Kynsilakka> kynsilakat;

    public Long getKategoria_id() {
        return kategoria_id;
    }

    public void setKategoria_id(Long kategoria_id) {
        this.kategoria_id = kategoria_id;
    }

    public String getTuotetyyppi() {
        return tuotetyyppi;
    }

    public void setTuotetyyppi(String tuotetyyppi) {
        this.tuotetyyppi = tuotetyyppi;
    }

    public List<Meikki> getMeikit() {
        return meikit;
    }

    public void setMeikit(List<Meikki> meikit) {
        this.meikit = meikit;
    }

    public List<Kynsilakka> getKynsilakat() {
        return kynsilakat;
    }

    public void setKynsilakat(List<Kynsilakka> kynsilakat) {
        this.kynsilakat = kynsilakat;
    }

    public Kategoria(Long kategoria_id, String tuotetyyppi) {
        this.kategoria_id = kategoria_id;
        this.tuotetyyppi = tuotetyyppi;
    }

    public Kategoria(String tuotetyyppi) {
        this.tuotetyyppi = tuotetyyppi;
    }

    public Kategoria() {
    }

    @Override
    public String toString() {
        return tuotetyyppi;
    }

}
