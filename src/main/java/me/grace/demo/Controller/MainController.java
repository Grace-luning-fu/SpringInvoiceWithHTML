package me.grace.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/index")
    public String defaultRequest() {
        return "Welcome";
    }

    @RequestMapping("/login")
    public @ResponseBody
    String disLogin() {
        return "login";
    }

    @RequestMapping("/addproduct")
    public @ResponseBody
    String addProduct() {
        return "addproduct";
    }

    @RequestMapping("/listproduct")
    public @ResponseBody
    String listProduct() {
        return "Thanks for shopping with us!";
    }

    @RequestMapping("/listindependency")
    public String index(Model model) {
        model.addAttribute("message", "The independencies includes: 1 web, 2 Thymeleaf, 3 test");
        return "List";

    }
}
