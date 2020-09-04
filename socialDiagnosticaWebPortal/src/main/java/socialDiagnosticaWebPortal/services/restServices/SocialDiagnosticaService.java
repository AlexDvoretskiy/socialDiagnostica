package socialDiagnosticaWebPortal.services.restServices;


import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import socialDiagnosticaWebPortal.config.PasswordEncryptor;
import socialDiagnosticaWebPortal.exceptions.ResponseNotFoundException;
import socialDiagnosticaWebPortal.exceptions.UserAuthException;
import socialDiagnosticaWebPortal.exceptions.UserRegisterException;
import socialDiagnosticaWebPortal.persistence.SystemUser;
import socialDiagnosticaWebPortal.persistence.dto.UserDto;
import socialDiagnosticaWebPortal.persistence.dto.mappers.UserDtoMapper;
import socialDiagnosticaWebPortal.persistence.entites.User;
import socialDiagnosticaWebPortal.services.restServices.response.AuthRequest;
import socialDiagnosticaWebPortal.services.restServices.response.AuthResponse;
import socialDiagnosticaWebPortal.persistence.pojo.DiagnosticCategory;
import socialDiagnosticaWebPortal.utils.session.SessionUtils;

import java.util.Arrays;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class SocialDiagnosticaService {
	private final UserDtoMapper userDtoMapper;
	private final PasswordEncryptor passwordEncryptor;

	@Value("${socialDiagnostica.api.host.register}")
	private String registerQueryUrl;
	@Value("${socialDiagnostica.api.host.request}")
	private String requestQueryUrl;

	public void register(SystemUser systemUser) throws UserRegisterException {
		final String urlRequest = String.format(registerQueryUrl, "register");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<UserDto> request = new HttpEntity<>(userDtoMapper.map(systemUser), headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(urlRequest, request , String.class);

		if(!response.getStatusCode().getReasonPhrase().equals(HttpStatus.OK.getReasonPhrase())) {
			throw new UserRegisterException("Ошибка при регистрации пользователя в сервисе диагностики");
		}
	}

	public String authenticate(User user) throws UserAuthException {
		final String urlRequest = String.format(registerQueryUrl, "auth");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<AuthRequest> request = new HttpEntity<>(getAuthRequestFromUserData(user), headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AuthResponse> response = restTemplate.postForEntity(urlRequest, request, AuthResponse.class);

		if (response.getStatusCode().equals(HttpStatus.OK)) {
			AuthResponse authResponse = response.getBody();
			if (authResponse != null) {
				return authResponse.getToken();
			} else {
				throw new UserAuthException("Ошибка при аутификации пользователя в сервисе диагностики: некорректный ответ с сервера");
			}
		} else {
			throw new UserAuthException("Ошибка при аутификации пользователя в сервисе диагностики: некорректный статус ответа с сервера");
		}
	}

	public List<DiagnosticCategory> getCategoriesWithTests() throws ResponseNotFoundException {
		final String urlRequest = String.format(requestQueryUrl, "getCategoriesWithTests");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(SessionUtils.getToken());

		HttpEntity<?> request = new HttpEntity<Object>(headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<DiagnosticCategory[]> categoryResponseEntity = restTemplate.exchange(urlRequest, HttpMethod.GET, request, DiagnosticCategory[].class);

		DiagnosticCategory[] diagnosticCategories = categoryResponseEntity.getBody();
		if (diagnosticCategories == null || diagnosticCategories.length == 0) {
			throw new ResponseNotFoundException("Ошибка получения ответа от сервиса диагностики: categoryResponse is null");
		}
		return Arrays.asList(diagnosticCategories);
	}

	private AuthRequest getAuthRequestFromUserData(User user) {
		return new AuthRequest(user.getName(), passwordEncryptor.decode(user.getPassword()));
	}
}
