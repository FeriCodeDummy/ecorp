package si.feri.ris.ecorp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Projects {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String description;
	private double funds;

	@ManyToMany(mappedBy = "projects")
	@JsonIgnore
	private List<Company> companies;

	@ManyToMany
	@JoinTable(
			name = "project_has_employees",
			joinColumns = @JoinColumn(name = "fk_project"),
			inverseJoinColumns = @JoinColumn(name = "fk_user")
	)
	@JsonIgnore
	Collection<Users> employees;

	public void assignEmployee(Users employee) {
		throw new UnsupportedOperationException();
	}

	public void removeEmployee(Users employee) {
		throw new UnsupportedOperationException();
	}

	public int changeFunds(double aAmount) {
		throw new UnsupportedOperationException();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Collection<Users> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Users> employees) {
		this.employees = employees;
	}
}
