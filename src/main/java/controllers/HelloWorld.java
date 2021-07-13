package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloWorld {
    @RequestMapping("/hello")
        public String model(Model model) {
            return "hello";

    }
}
