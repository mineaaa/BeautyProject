package hh.sof03.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KynsilakkaRepository extends CrudRepository<Kynsilakka, Long> {
    List<Kynsilakka> findByLakkaVari(@Param("lakkaVari") String lakkaVari);
}
