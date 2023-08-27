package api.app;
import api.app.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


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
            insuranceService.loadOnstart("Insurance-Data.json");
        };
    }



}
