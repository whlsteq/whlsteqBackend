package whlsteq.backend.business.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Surname cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String surname;

    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    @Size(min=8,max = 16, message = "Size must be between 8 and 16")
    private String password;
}
