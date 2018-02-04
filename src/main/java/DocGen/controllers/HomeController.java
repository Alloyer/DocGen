package DocGen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alloyer on 12.01.2018.
 */
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/documents")
    public String documents(){ return "documents"; }

    @GetMapping(value = "/goLogin")
    public String goLogin() {return "login"; }

}
