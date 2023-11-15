package hh.sof03.harjoitustyo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.harjoitustyo.domain.Kategoria;
import hh.sof03.harjoitustyo.domain.KategoriaRepository;
import hh.sof03.harjoitustyo.domain.Kynsilakka;
import hh.sof03.harjoitustyo.domain.KynsilakkaRepository;
import hh.sof03.harjoitustyo.domain.Meikki;
import hh.sof03.harjoitustyo.domain.MeikkiRepository;
import hh.sof03.harjoitustyo.domain.User;
import hh.sof03.harjoitustyo.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HarjoitustyoRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KategoriaRepository kategoriaRepository;

    @Autowired
    private KynsilakkaRepository kynsilakkaRepository;

    @Autowired
    private MeikkiRepository meikkiRepository;

    @Test // kaikkien meikkituotteiden listaaminen
    public void listAllMakeup() {
        assertThat(meikkiRepository.findAll());
    }

    @Test // poista meikki testi
    public void deleteMeikkiById() {
        List<Meikki> meikit = (List<Meikki>) meikkiRepository.findAll();
        meikkiRepository.deleteById((long) 1);
        meikit = (List<Meikki>) meikkiRepository.findAll();
        assertThat(meikit).hasSize(2);
    }

    @Test // uuden meikin lisäminen testi
    public void createNewMeikki() {
        Meikki meikki = new Meikki("Huulirasva", LocalDate.of(2022, 5, 10), 15.00, null);
        meikkiRepository.save(meikki);
        assertThat(meikki.getMeikki_id()).isNotNull();
    }

    @Test // kaikkien kynsilakkojen listaaminen
    public void listAllKynsilakka() {
        assertThat(kynsilakkaRepository.findAll());
    }

    @Test // testataan uuden kategorian luominen
    public void createNewKategoria() {
        Kategoria kategoria = new Kategoria("Huulirasva");
        kategoriaRepository.save(kategoria);
        assertThat(kategoria.getKategoria_id()).isNotNull();
    }

    @Test // testataan kategorian poisto
    public void deleteKategoriabyId() {
        List<Kategoria> kategoriat = (List<Kategoria>) kategoriaRepository.findAll();
        kategoriaRepository.deleteById((long) 1);
        kategoriat = (List<Kategoria>) kategoriaRepository.findAll();
        assertThat(kategoriat).hasSize(4);
    }

    @Test // kaikkien kategorioiden listaaminen
    public void listAllKategoriat() {
        assertThat(kategoriaRepository.findAll());
    }

    @Test // testataan uuden lakan lisääminen
    public void createNewKynsilakka() {
        Kynsilakka kynsilakka = new Kynsilakka("Söpöin lakka ikinä", "Beige", LocalDate.of(2023, 11, 10), null);
        kynsilakkaRepository.save(kynsilakka);
        assertThat(kynsilakka.getLakka_id()).isNotNull();
    }

    @Test // testataan kynsilakan poist aminen
    public void deleteKynsilakkabyId() {
        List<Kynsilakka> kynsilakat = (List<Kynsilakka>) kynsilakkaRepository.findAll();
        kynsilakkaRepository.deleteById((long) 1);
        kynsilakat = (List<Kynsilakka>) kynsilakkaRepository.findAll();
        assertThat(kynsilakat).hasSize(1);
    }

    @Test // kaikkien käyttäjien listaaminen
    public void listAllUsers() {
        assertThat(userRepository.findAll());
    }

    @Test // testataan uuden käyttäjän luonti
    public void createNewUser() {
        User u2 = new User("user", "$2a$10$1a8KO6xK3eoYcnGHZ4UHLOYfKr3.sHbtBzpXZdgL8skDCHYnSkl8W", "user@haagahelia.fi",
                "USER");
        userRepository.save(u2);
        assertThat(u2.getId()).isNotNull();
    }

    @Test // testataan käyttäjän poistaminen
    public void deleteUserbyId() {
        List<User> users = (List<User>) userRepository.findAll();
        userRepository.deleteById((long) 1);
        users = (List<User>) userRepository.findAll();
        assertThat(users).hasSize(0);
    }

}
