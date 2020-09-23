package authService.services;


import authService.persistence.entites.Role;
import authService.persistence.entites.User;
import authService.repositories.RoleRepository;
import authService.repositories.UserRepository;
import authService.services.interfaces.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
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


	@Override
	@Transactional
	public User findByUserName(String userName) {
		return userRepository.findOneByName(userName);
	}

	@Override
	@Transactional
	public void create(User user) {
		User existing = userRepository.findOneByName(user.getUsername());
		if (existing != null) {
			throw new IllegalArgumentException("Пользователь с данным именем уже существует: " + existing.getUsername());
		}

		String hash = passwordEncoder.encode(user.getPassword());
		user.setPassword(hash);

		userRepository.save(user);
		log.info("Новый пользователь был создан: {}", user.getUsername());
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findOneByName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Некорректное имя пользователя или пароль");
		}
		return user;
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
