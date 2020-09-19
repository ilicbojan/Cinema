package cinemaapp;

import cinemaapp.controllers.MoviesController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@SpringBootApplication
@EnableJpaRepositories
public class CinemaApplication {

	public static void main(String[] args) {
		new File(MoviesController.uploadDirectory).mkdirs();
		SpringApplication.run(CinemaApplication.class, args);
	}

	@Configuration
	public class AdditionalResourceWebConfiguration implements WebMvcConfigurer {

		@Override
		public void addResourceHandlers(final ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/uploads/**").addResourceLocations("file:///" + System.getProperty("user.dir") + "/src/main/uploads/");
		}
	}
}
