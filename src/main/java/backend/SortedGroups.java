package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import inf.Dao;

@Entity
@Table(name = "grupos_sorteados")
public class SortedGroups {

	@Id
	private int id;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinTable(name = "seleções_classificadas", joinColumns = @JoinColumn(name = "id_de_copa", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_de_seleção", referencedColumnName = "id"))
	private List<Teams> qualifiedTeams = new ArrayList<Teams>();
	@Column(name = "grupo")
	private int group;

	public SortedGroups() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Teams> getQualifiedTeams() {
		return qualifiedTeams;
	}

	public void setQualifiedTeams(List<Teams> qualifiedTeams) {
		this.qualifiedTeams = qualifiedTeams;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public void sortGroups() {
		Dao<Teams> tDao = new Dao<>(Teams.class);
		Dao<SortedGroups> sgDao = new Dao<>(SortedGroups.class);

		Random random = new Random();

		List<Integer> sortedNumbers = new ArrayList<>();

		int g = 1;
		for (int i = 1; i <= 32; i++) {

			SortedGroups sg = new SortedGroups();

			int r;

			do {

				r = random.nextInt(40) + 1;
			} while (sortedNumbers.contains(r));

			sortedNumbers.add(r);
			Teams team = tDao.getById(r);

			sg.setId(i);
			sg.getQualifiedTeams().add(team);
			sg.setGroup(g);

			sgDao.alter(sg);
			r = 0;

			if (g < 8) {
				g++;
			} else {
				g = 1;
			}
		}

		tDao.closeDao();
		sgDao.closeDao();
	}
}