package hello.core.controller;

import hello.core.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // HTTP GET
    // http://localhost:8080/hello
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "!!!!!!!!!!!!!!");
        return "hello";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Product helloApi(@RequestParam("name") String name,
                            @RequestParam("price") int price,
                            @RequestParam("stock") int stock) {
        Product water = new Product();
        water.setName(name);
        water.setPrice(price);
        water.setStock(stock);

        return water;
    }
}
