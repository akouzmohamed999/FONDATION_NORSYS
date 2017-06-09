package fr.norsys.fondation.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "THEMATIQUE")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idThematique")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
public class Thematique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_THEMATIQUE")
	private int idThematique;

	@Column(name = "INTITULE")
	private String intitule;

	@Column(name = "DESCRIPTION")
	private String description;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "thematique")
	@JsonIgnore
	private List<Composante> composantes = new ArrayList<Composante>();

	public Thematique() {
	}

	public Thematique(int idThematique, String intitule, String description) {
		super();
		this.idThematique = idThematique;
		this.intitule = intitule;
		this.description = description;
	}

	public int getIdThematique() {
		return this.idThematique;
	}

	public void setIdThematique(int idThematique) {
		this.idThematique = idThematique;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Composante> getComposantes() {
		return this.composantes;
	}

	public void setComposantes(List<Composante> composantes) {
		this.composantes = composantes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + idThematique;
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thematique other = (Thematique) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idThematique != other.idThematique)
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Thematique [idThematique=" + idThematique + ", intitule=" + intitule + ", description=" + description
				+ "]";
	}

	
}
