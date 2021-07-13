package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HelloWorld {
    @RequestMapping("/try")
        public String model(Model model) {
            return "hello";

    }
}
