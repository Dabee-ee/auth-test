package dababy.authtest.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired AccountService accountService;

    @Autowired AccountRepository accountRepository;

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

    @GetMapping("/{email}")
    public String findAccount(Model model, @PathVariable String email) {
        Account account = accountRepository.findByEmail(email);

        model.addAttribute("account", account);

        return "/myPage";
    }

    @PostMapping("/{email}")
    public String modifyAccount(Model model, @PathVariable String email, AccountRequestDto accountRequestDto) {
        Account account = accountService.modify(email, accountRequestDto);

        model.addAttribute("account", account);

        return "redirect:/";
    }


}
