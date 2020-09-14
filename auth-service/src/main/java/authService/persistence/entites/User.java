package authService.persistence.entites;


import authService.persistence.tables.UsersRolesTableDesc;
import authService.persistence.tables.UsersTableDesc;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = UsersTableDesc.SYSTEM_NAME)
public class User implements UserDetails {

	@Id
	@Column(name = UsersTableDesc.ID_FIELD)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name =  UsersTableDesc.NAME_FIELD)
	private String name;

	@Column(name =  UsersTableDesc.FULL_NAME_FIELD)
	private String fullName;

	@Column(name = UsersTableDesc.PASSWORD_FIELD)
	private String password;

	@Column(name = UsersTableDesc.EMAIL_FIELD)
	private String email;

	@Column(name =  UsersTableDesc.APP_TOKEN_FIELD)
	private String appToken;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = UsersRolesTableDesc.SYSTEM_NAME,
			joinColumns = @JoinColumn(name = UsersRolesTableDesc.USER_ID_FIELD),
			inverseJoinColumns = @JoinColumn(name = UsersRolesTableDesc.ROLE_ID_FIELD))
	private List<Role> roles;


	@Builder
	public User(String name, String fullName, String password, String email, String appToken, List<Role> roles) {
		this.name = name;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.appToken = appToken;
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
