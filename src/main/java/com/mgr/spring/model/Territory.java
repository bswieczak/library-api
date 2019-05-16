package com.mgr.spring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the territories database table.
 * 
 */
@Entity
@Table(name="territories")
@NamedQuery(name="Territory.findAll", query="SELECT t FROM Territory t")
public class Territory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String territoryId;

	@Column(name="territory_description")
	private String territoryDescription;

	//bi-directional many-to-many association to Employee
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="employee_territories"
		, joinColumns={
			@JoinColumn(name="territory_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="employee_id")
			}
		)
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