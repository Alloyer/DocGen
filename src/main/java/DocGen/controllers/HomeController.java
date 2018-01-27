package DocGen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by alloyer on 12.01.2018.
 */
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
}
