package socialDiagnosticaWebPortal.config;


import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Component;


@Component
public class PasswordEncryptor implements PasswordEncoder {

	@Value("${spring.security.pass}")
	private String password;
	@Value("${spring.security.salt}")
	private String salt;

	@Override
	public String encode(CharSequence rawPassword) {
		if (StringUtils.isNotEmpty(rawPassword)) {
			TextEncryptor encryptor = Encryptors.text(password, salt);
			return encryptor.encrypt(rawPassword.toString());
		}
		return null;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String dencodePass = decode(encodedPassword);
		return dencodePass.contentEquals(rawPassword);
	}

	public String decode(CharSequence encodePassword) {
		if (StringUtils.isNotEmpty(encodePassword)) {
			TextEncryptor decryptor = Encryptors.text(password, salt);
			return decryptor.decrypt(encodePassword.toString());
		}
		return null;
	}
}
