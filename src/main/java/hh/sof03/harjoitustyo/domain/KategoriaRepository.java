package hh.sof03.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KategoriaRepository extends CrudRepository<Kategoria, Long> {

    List<Kategoria> findByTuotetyyppi(@Param("tuotetyyppi") String tuotetyyppi);

}
