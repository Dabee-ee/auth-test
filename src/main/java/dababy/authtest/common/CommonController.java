package dababy.authtest.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class CommonController {

    @GetMapping("/")
    public String index(Model model, Principal principal) {

        model.addAttribute("title", "index");
        if ( principal == null ){
            model.addAttribute("message", "Hello, Stranger.");
        } else {
            model.addAttribute("message", "Hello, " + principal.getName());
        }

        return "/index";
    }

    @GetMapping("/signUp")
    public String signUp(Model model, Principal principal) {

        model.addAttribute("title", "sign up");
        if ( principal == null ){
            model.addAttribute("message", "Please put information for sign up.");
        } else {
            model.addAttribute("message", principal.getName() + ", Already signed up. ");
        }

        return "/signUp";
    }

    @GetMapping("/user")
    public String user(Model model, Principal principal) {

        model.addAttribute("title", "user");
        model.addAttribute("message", "Hello, " + principal.getName());

        return "/user";
    }


    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {

        model.addAttribute("title", "admin");
        model.addAttribute("message", "Hello, " + principal.getName());

        return "/admin";
    }

    @GetMapping("/myPage")
    public String myPage(Model model, Principal principal) {
        model.addAttribute("title", "my page");
        model.addAttribute("message", principal.getName() + " 's information. ");

        return "/myPage";
    }


}
