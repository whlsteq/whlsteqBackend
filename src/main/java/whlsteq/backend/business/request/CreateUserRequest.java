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
    @NotNull(message = "Name cannot be null or blank")
    @NotBlank(message = "Name cannot be null or blank")
    private String name;

    @NotNull(message = "Surname cannot be null or blank")
    @NotBlank(message = "Surname cannot be null or blank")
    private String surname;

    @NotNull(message = "Email cannot be null or blank")
    @NotBlank(message = "Email cannot be null or blank")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null or blank")
    @NotBlank(message = "Password cannot be null or blank")
    @Size(min=8,max = 16, message = "Size must be between 8 and 16")
    private String password;
}
