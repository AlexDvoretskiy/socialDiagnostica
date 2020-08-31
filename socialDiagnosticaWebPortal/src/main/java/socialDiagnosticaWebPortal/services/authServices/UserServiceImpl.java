package socialDiagnosticaWebPortal.services.authServices;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import socialDiagnosticaWebPortal.persistence.SystemUser;
import socialDiagnosticaWebPortal.persistence.entites.Role;
import socialDiagnosticaWebPortal.persistence.entites.User;
import socialDiagnosticaWebPortal.repositories.RoleRepository;
import socialDiagnosticaWebPortal.repositories.UserRepository;
import socialDiagnosticaWebPortal.services.authServices.interfaces.UserService;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


@Slf4j
@Service
public class UserServiceImpl implements UserService {
	private static final String DEFAULT_ROLE = "ROLE_USER";

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private AuthService authService;

	@Override
	@Transactional
	public User findByUserName(String userName) {
		return userRepository.findOneByName(userName);
	}

	@Override
	@Transactional
	public User getCurrentUser() {
		return userRepository.findOneByName(authService.getCurrentUsername());
	}

	@Override
	@Transactional
	public void create(SystemUser systemUser) {
		User user = new User();

		user.setName(systemUser.getUserName());
		user.setFullName(systemUser.getFullName());
		user.setPassword(passwordEncoder.encode(systemUser.getPassword()));
		user.setEmail(systemUser.getEmail());
		user.setRoles(Collections.singletonList(roleRepository.findOneByName(DEFAULT_ROLE)));

		userRepository.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findOneByName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
