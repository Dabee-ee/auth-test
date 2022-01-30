package dababy.authtest.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired AccountService accountService;

    @PostMapping("/newAccount")
    public String newAccount(Model model, @ModelAttribute AccountRequestDto accountRequestDto) {
        if ( accountRequestDto == null ) {
            return null;
        } else {
            Account account = accountService.save(accountRequestDto);

            if ( account != null ) {
                model.addAttribute("title", "success");
                model.addAttribute("message", "successfully created account.");
                model.addAttribute("username", "Thank you," + account.getUsername());
                return "/success";
            }
            return null;
        }
    }

}
