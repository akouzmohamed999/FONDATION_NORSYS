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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "THEMATIQUE")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idThematique")
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

	public List<Composante> getComposante() {
		return this.composantes;
	}

	public void setComposante(List<Composante> composante) {
		this.composantes = composante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.description == null ? 0 : this.description.hashCode());
		result = prime * result + this.idThematique;
		result = prime * result + (this.intitule == null ? 0 : this.intitule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Thematique other = (Thematique) obj;
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!this.description.equals(other.description)) {
			return false;
		}
		if (this.idThematique != other.idThematique) {
			return false;
		}
		if (this.intitule == null) {
			if (other.intitule != null) {
				return false;
			}
		} else if (!this.intitule.equals(other.intitule)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Thematique [idThematique=" + this.idThematique + ", intitule=" + this.intitule + ", description="
				+ this.description + ", composantes number=" + this.composantes.size() + "]";
	}

}