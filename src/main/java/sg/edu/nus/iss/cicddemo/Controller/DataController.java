package sg.edu.nus.iss.cicddemo.controller;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DataController {

    private final Faker faker = new Faker();

    @GetMapping("/")
    public String home() {
        return "Welcome to CI/CD Demo with Snyk Security Scanning!";
    }

    @GetMapping("/user")
    public Map<String, String> getRandomUser() {
        Map<String, String> user = new HashMap<>();
        user.put("name", faker.name().fullName());
        user.put("email", faker.internet().emailAddress());
        user.put("city", faker.address().city());
        user.put("company", faker.company().name());
        return user;
    }

    @GetMapping("/quote")
    public Map<String, String> getRandomQuote() {
        Map<String, String> quote = new HashMap<>();
        quote.put("quote", faker.shakespeare().hamletQuote());
        quote.put("author", faker.book().author());
        return quote;
    }

    @GetMapping("/health")
    public Map<String, String> healthCheck() {
        Map<String, String> health = new HashMap<>();
        health.put("status", "UP");
        health.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return health;
    }
}