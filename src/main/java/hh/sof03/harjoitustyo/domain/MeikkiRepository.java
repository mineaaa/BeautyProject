package hh.sof03.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MeikkiRepository extends CrudRepository<Meikki, Long> {

    List<Meikki> findByKategoria(Kategoria kategoria);

}
