package forms;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor 
@Builder
@Getter
public class userForm {

    private String name;
    private String email;
    private String password;
    private String about;
    private String phoneNumber;


}
