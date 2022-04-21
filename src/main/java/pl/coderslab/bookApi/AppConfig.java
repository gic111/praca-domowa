package pl.coderslab.bookApi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Główna klasa konfiguracyjna, niezwiązana z żadną "warstwą" aplikacji
@Configuration
@ComponentScan(basePackages = "pl.coderslab")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
}