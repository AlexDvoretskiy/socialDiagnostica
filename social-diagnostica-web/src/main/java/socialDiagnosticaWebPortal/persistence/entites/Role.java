package socialDiagnosticaWebPortal.persistence.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import socialDiagnosticaWebPortal.persistence.tables.RolesTableDesc;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@Table(name = RolesTableDesc.SYSTEM_NAME)
public class Role {

	@Id
	@Column(name = RolesTableDesc.ID_FIELD)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = RolesTableDesc.NAME_FIELD)
	private String name;

	public Role(String name) {
		this.name = name;
	}
}
