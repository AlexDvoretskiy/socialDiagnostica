package socialDiagnosticaWebPortal.persistence.entites;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import socialDiagnosticaWebPortal.persistence.tables.UsersRolesTableDesc;
import socialDiagnosticaWebPortal.persistence.tables.UsersTableDesc;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = UsersTableDesc.SYSTEM_NAME)
public class User {

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
}
