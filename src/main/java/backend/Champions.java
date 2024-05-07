package backend;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import inf.Dao;

@Entity
@Table(name = "campeões")
public class Champions {

	@Id
	@Column(unique = true)
	private int id;
	@OneToMany
	@JoinTable(name = "campeões_mundiais", joinColumns = @JoinColumn(name = "id_de_campeão", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_de_seleção", referencedColumnName = "id"))
	private List<Teams> wrChampions = new ArrayList<>();
	@Column(name = "número_de_títulos")
	private int numberOfTitles;

	public Champions() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Teams> getWrChampions() {
		return wrChampions;
	}

	public void setWrChampions(int i, Champions newChamp) {
		Dao<Teams> tDao = new Dao<>(Teams.class);
		Dao<Champions> cpDao = new Dao<>(Champions.class);

		List<Teams> teams = tDao.getList();
		Teams tempTeam = teams.get(i - 1);
		tempTeam.setWrTrophies();

		tDao.alter(tempTeam);

		if (newChamp.getId() != tempTeam.getId()) {
			newChamp.setId(tempTeam.getId());
			newChamp.getWrChampions().add(tempTeam);
		}

		newChamp.setNumberOfTitles(tempTeam.getWrTrophies());

		cpDao.alter(newChamp);

		tDao.closeDao();
		cpDao.closeDao();
	}

	public int getNumberOfTitles() {
		return numberOfTitles;
	}

	public void setNumberOfTitles(int numberOfTitles) {
		this.numberOfTitles = numberOfTitles;
	}
}