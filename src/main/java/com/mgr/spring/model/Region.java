package com.mgr.spring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the region database table.
 * 
 */
@Entity
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer regionId;

	private String regionDescription;

	//bi-directional many-to-one association to Territory
	@OneToMany(mappedBy="region", fetch=FetchType.EAGER)
	private Set<Territory> territories;

	public Region() {
	}

	public Integer getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionDescription() {
		return this.regionDescription;
	}

	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
	}

	public Set<Territory> getTerritories() {
		return this.territories;
	}

	public void setTerritories(Set<Territory> territories) {
		this.territories = territories;
	}

	public Territory addTerritory(Territory territory) {
		getTerritories().add(territory);
		territory.setRegion(this);

		return territory;
	}

	public Territory removeTerritory(Territory territory) {
		getTerritories().remove(territory);
		territory.setRegion(null);

		return territory;
	}

}