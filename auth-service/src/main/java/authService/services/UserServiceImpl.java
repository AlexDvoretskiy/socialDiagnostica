package authService.services;


import authService.persistence.dto.UserDto;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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


	@Override
	@Transactional
	public User findByUserName(String userName) {
		return userRepository.findOneByName(userName);
	}

	@Override
	@Transactional
	public User create(UserDto userDto) {
		User user = new User();

		user.setName(userDto.getUserName());
		user.setFullName(userDto.getFullName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail());
		user.setRoles(Collections.singletonList(roleRepository.findOneByName(DEFAULT_ROLE)));

		userRepository.save(user);
		return user;
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
