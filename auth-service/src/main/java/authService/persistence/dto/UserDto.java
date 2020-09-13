package authService.persistence.dto;


import authService.utils.validation.ValidEmail;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@Builder
public class UserDto {
	private static final String requiredMsg = "обязательно для заполнения";

	@Size(min = 3, message = "минимум 3 символа")
	private String userName;

	@Size(min = 3, message = "минимум 3 символа")
	private String fullName;

	@ValidEmail(message = "некорректный email адрес")
	@Size(min = 1, message = requiredMsg)
	private String email;

	@Size(min = 5, message = "минимум 5 символов")
	@Size(max = 25, message = "максимум 20 символов")
	@Pattern(regexp = "^[0-9a-zA-Z!@#$%^&*].*", message = "некорректный формат пароля")
	private String password;
}
