package com.mgr.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="territories")
public class Territory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String territoryId;

	@Column(name="territory_description")
	private String territoryDescription;

	//bi-directional many-to-many association to Employee
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="employee_territories"
		, joinColumns={
			@JoinColumn(name="territory_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="employee_id")
			}
		)
	@JsonIgnore
	private Set<Employee> employees;

	//bi-directional many-to-one association to Region
	@ManyToOne
	@JoinColumn(name="region_id")
	private Region region;

	public Territory() {
	}

	public String getTerritoryId() {
		return this.territoryId;
	}

	public void setTerritoryId(String territoryId) {
		this.territoryId = territoryId;
	}

	public String getTerritoryDescription() {
		return this.territoryDescription;
	}

	public void setTerritoryDescription(String territoryDescription) {
		this.territoryDescription = territoryDescription;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}