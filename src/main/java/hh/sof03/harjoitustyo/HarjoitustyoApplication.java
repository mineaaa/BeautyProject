package hh.sof03.harjoitustyo;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.harjoitustyo.domain.Kategoria;
import hh.sof03.harjoitustyo.domain.KategoriaRepository;
import hh.sof03.harjoitustyo.domain.Kynsilakka;
import hh.sof03.harjoitustyo.domain.KynsilakkaRepository;
import hh.sof03.harjoitustyo.domain.Meikki;
import hh.sof03.harjoitustyo.domain.MeikkiRepository;
import hh.sof03.harjoitustyo.domain.User;
import hh.sof03.harjoitustyo.domain.UserRepository;

@SpringBootApplication
public class HarjoitustyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}

	@Bean
	public CommandLineRunner kauneusJarjestelma(MeikkiRepository meikkiRepository,
			KynsilakkaRepository kynsilakkaRepository, KategoriaRepository kategoriaRepository,
			UserRepository userRepository) {
		return (args) -> {
			Kategoria c1 = new Kategoria("Poskipuna");
			kategoriaRepository.save(c1);

			Kategoria c2 = new Kategoria("Akryyli");
			kategoriaRepository.save(c2);

			Kategoria c3 = new Kategoria("Geeli");
			kategoriaRepository.save(c3);

			Kategoria c4 = new Kategoria("Ripsiväri");
			kategoriaRepository.save(c4);

			Kategoria c5 = new Kategoria("Kulmakynä");
			kategoriaRepository.save(c5);

			Meikki m1 = new Meikki("Maybelline New York Lash Sensational Sky High", LocalDate.of(2023, 10, 2), 15.00,
					c4);
			meikkiRepository.save(m1);

			Meikki m2 = new Meikki("Essence Baby Got Blush 10 tickle me pink", LocalDate.of(2022, 5, 10), 8.50, c1);
			meikkiRepository.save(m2);

			Meikki m3 = new Meikki("Micro Brow Pencil Brunette", LocalDate.of(2022, 3, 12), 15.00, c5);
			meikkiRepository.save(m3);

			Kynsilakka k1 = new Kynsilakka("Essie Spring 2023 Collection 13,5ml", "Vaaleanpunainen ja kimalteleva",
					LocalDate.of(2022, 8, 23), c2);
			kynsilakkaRepository.save(k1);

			Kynsilakka k2 = new Kynsilakka("W7 102A Retreat", "Violetti", LocalDate.of(2020, 4, 14), c3);
			kynsilakkaRepository.save(k2);

			User user1 = new User("admin", "$2a$10$whw5dGSF1d0T010NFcz1pOpYD0kN7wwmDMq6XKGiMCwbfW5fCMxju",
					"admin@haagahelia.fi", "ADMIN");
			userRepository.save(user1);

		};

	}
}
