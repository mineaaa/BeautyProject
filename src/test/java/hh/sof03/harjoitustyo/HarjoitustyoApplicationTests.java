package hh.sof03.harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.harjoitustyo.web.KategoriaController;
import hh.sof03.harjoitustyo.web.KynsilakkaController;
import hh.sof03.harjoitustyo.web.MeikkiController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HarjoitustyoApplicationTests {

	@Autowired
	private MeikkiController meikkiController;

	@Autowired
	private KynsilakkaController kynsilakkaController;

	@Autowired
	private KategoriaController kategoriaController;

	@Test
	void contextLoads() {
		assertThat(meikkiController).isNotNull();
		assertThat(kynsilakkaController).isNotNull();
		assertThat(kategoriaController).isNotNull();

	}

}
