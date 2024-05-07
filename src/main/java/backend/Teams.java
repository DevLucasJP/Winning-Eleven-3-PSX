package backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seleções")
public class Teams {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nome", nullable = false, unique = true)
	private String name;
	@Column(name = "continente", nullable = false)
	private String region;
	@Column(name = "títulos_mundiais")
	private int wrTrophies = 0;

	public Teams() {
	}

	public Teams(String name, String region) {
		this.name = name;
		this.region = region;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getWrTrophies() {
		return wrTrophies;
	}

	public void setWrTrophies() {
		this.wrTrophies++;
	}
}