package me.grace.demo.Controller;

import me.grace.demo.models.Product;
import me.grace.demo.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    ProductRepo productRepo;


    @RequestMapping("/")
    public String defaultRequest(Model model){
        String myMessage = "welcome to the invoice App";
        model.addAttribute("messagetest", myMessage);
        return "welcome";
    }

    @RequestMapping("/login")
    public String disLogin(Model model) {
        model.addAttribute("message");
        return "login";
    }


    @GetMapping("/addproduct")
    public String addProduct(Model model) {
        model.addAttribute("newproduct", new Product());
        return "addproduct";
    }

    @PostMapping("/addproduct")
    public String postProduct(@Valid @ModelAttribute("newproduct") Product product, BindingResult bindingResult)
    {
        //System.out.println(product.getDescription());
        //System.out.println(bindingResult.toString());
        if(bindingResult.hasErrors()){
            return "addproduct";
        }
        productRepo.save(product);
        return "result";
    }

    @RequestMapping("/listproduct")
    public String listProduct(Model model) {
        model.addAttribute("message");
        return "listproduct";
    }

    @RequestMapping("/listindependency")
    public String index(Model model) {
        model.addAttribute("message", "The independencies include: 1 web, 2 Thymeleaf, 3 test");
        return "dependencyList";

    }
}
