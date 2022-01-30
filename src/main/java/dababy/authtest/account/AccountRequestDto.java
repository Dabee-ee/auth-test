package dababy.authtest.account;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AccountRequestDto {

    @NotNull
    public String email;
    @NotNull
    public String username;
    @NotNull
    public String password;
    @NotNull
    public String role;


}
