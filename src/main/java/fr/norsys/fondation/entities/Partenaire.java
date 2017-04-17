package fr.norsys.fondation.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PARTENAIRE")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idPartenaire")
public class Partenaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PARTENAIRE")
	private int idPartenaire;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "ADRESSE")
	private String adresse;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "NUMERO_TELEPHONE")
	private String numeroTelephone;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	@JoinTable(name = "PARTENAIRE_PROJET", joinColumns = {
			@JoinColumn(referencedColumnName = "ID_PARTENAIRE", name = "ID_PARTENAIRE") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "ID_PROJET", name = "ID_PROJET") })
	@JsonBackReference
	private List<Projet> projets = new ArrayList<Projet>();

	public Partenaire() {
	}

	public Partenaire(int idPartenaire, String nom, String type, String adresse, String email, String numeroTelephone) {
		super();
		this.idPartenaire = idPartenaire;
		this.nom = nom;
		this.type = type;
		this.adresse = adresse;
		this.email = email;
		this.numeroTelephone = numeroTelephone;
	}

	public int getIdPartenaire() {
		return this.idPartenaire;
	}

	public void setIdPartenaire(int idPartenaire) {
		this.idPartenaire = idPartenaire;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroTelephone() {
		return this.numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public List<Projet> getProjets() {
		return this.projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.adresse == null ? 0 : this.adresse.hashCode());
		result = prime * result + (this.email == null ? 0 : this.email.hashCode());
		result = prime * result + this.idPartenaire;
		result = prime * result + (this.nom == null ? 0 : this.nom.hashCode());
		result = prime * result + (this.numeroTelephone == null ? 0 : this.numeroTelephone.hashCode());
		result = prime * result + (this.type == null ? 0 : this.type.hashCode());
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
		Partenaire other = (Partenaire) obj;
		if (this.adresse == null) {
			if (other.adresse != null) {
				return false;
			}
		} else if (!this.adresse.equals(other.adresse)) {
			return false;
		}
		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!this.email.equals(other.email)) {
			return false;
		}
		if (this.idPartenaire != other.idPartenaire) {
			return false;
		}
		if (this.nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!this.nom.equals(other.nom)) {
			return false;
		}
		if (this.numeroTelephone == null) {
			if (other.numeroTelephone != null) {
				return false;
			}
		} else if (!this.numeroTelephone.equals(other.numeroTelephone)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Partenaire [idPartenaire=" + this.idPartenaire + ", nom=" + this.nom + ", type=" + this.type
				+ ", adresse=" + this.adresse + ", email=" + this.email + ", numeroTelephone=" + this.numeroTelephone
				+ ", projets number=" + this.projets.size() + "]";
	}

}
