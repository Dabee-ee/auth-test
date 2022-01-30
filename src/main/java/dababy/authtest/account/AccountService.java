package dababy.authtest.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);

        if ( account == null ) {
            throw new UsernameNotFoundException("Invalid email of password. Please check, " + email);
        }

        return User.builder()
                .username(account.getEmail())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }


    public Account save(AccountRequestDto accountRequestDto) {
        Account account = new Account();

        account.setEmail(accountRequestDto.email);
        account.setUsername(accountRequestDto.username);
        account.setPassword(accountRequestDto.password);
        account.setRole(accountRequestDto.role);

        account.encodePassword(passwordEncoder);

        return accountRepository.save(account);
    }

}
