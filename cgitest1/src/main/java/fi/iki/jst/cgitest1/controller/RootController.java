package fi.iki.jst.cgitest1.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	@GetMapping("/")
    public String home() {
        return "Path of api is: /person";
    }
}
