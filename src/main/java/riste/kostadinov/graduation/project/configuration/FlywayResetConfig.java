//package riste.kostadinov.graduation.project.configuration;
//import org.flywaydb.core.Flyway;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FlywayResetConfig {
//
//    @Bean
//    CommandLineRunner resetDbOnce(Flyway flyway) {
//        return args -> {
//            // ⚠️ This will DROP ALL TABLES in your DB and re-run all migrations
//            System.out.println("Cleaning and migrating database...");
//            flyway.clean();
//            flyway.migrate();
//            System.out.println("Database reset complete ✅");
//
//            // Optional: exit immediately after reset (remove if you want to keep app running)
//            System.exit(0);
//        };
//    }
//}