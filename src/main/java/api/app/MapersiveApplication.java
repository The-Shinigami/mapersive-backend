package api.app;
import api.app.repository.InsuranceRepository;
import api.app.service.InsuranceService;
import com.fasterxml.jackson.core.type.TypeReference;
import api.app.model.Insurance;
import api.app.model.InsuranceDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.PostLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication()
public class MapersiveApplication {

    @Autowired
    InsuranceService insuranceService;

    public static void main(String[] args) {
        SpringApplication.run(MapersiveApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            // Your initialization code here

            insuranceService.loadOnstart("Insurance-Data.json");
        };
    }



}
