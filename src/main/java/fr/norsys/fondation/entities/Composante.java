package fr.norsys.fondation.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "COMPOSANTE")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idComposante")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
public class Composante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPOSANTE")
	private int idComposante;

	@Column(name = "INTITULE")
	private String intitule;

	@ManyToOne
	@JoinColumn(name = "ID_THEMATIQUE")
	private Thematique thematique;

	@ManyToOne
	@JoinColumn(name = "ID_PROJET")
	private Projet projet;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "composante")
	@JsonIgnore
	private List<Activite> activites = new ArrayList<Activite>();

	public Composante() {
	}

	public Composante(int idComposante, String intitule, Thematique thematique, Projet projet) {
		super();
		this.idComposante = idComposante;
		this.intitule = intitule;
		this.thematique = thematique;
		thematique.getComposantes().add(this);
		this.projet = projet;
		projet.getComposantes().add(this);
	}

	public int getIdComposante() {
		return this.idComposante;
	}

	public void setIdComposante(int idComposante) {
		this.idComposante = idComposante;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Thematique getThematique() {
		return this.thematique;
	}

	public void setThematique(Thematique thematique) {
		this.thematique = thematique;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Activite> getActivites() {
		return this.activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.idComposante;
		result = prime * result + (this.intitule == null ? 0 : this.intitule.hashCode());
		result = prime * result + (this.projet == null ? 0 : this.projet.hashCode());
		result = prime * result + (this.thematique == null ? 0 : this.thematique.hashCode());
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
		Composante other = (Composante) obj;
		if (this.idComposante != other.idComposante) {
			return false;
		}
		if (this.intitule == null) {
			if (other.intitule != null) {
				return false;
			}
		} else if (!this.intitule.equals(other.intitule)) {
			return false;
		}
		if (this.projet == null) {
			if (other.projet != null) {
				return false;
			}
		} else if (!this.projet.equals(other.projet)) {
			return false;
		}
		if (this.thematique == null) {
			if (other.thematique != null) {
				return false;
			}
		} else if (!this.thematique.equals(other.thematique)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Composante [idComposante=" + this.idComposante + ", intitule=" + this.intitule + ", thematique="
				+ this.thematique + ", projet=" + this.projet + ", activites number=" + this.activites.size() + "]";
	}

}
