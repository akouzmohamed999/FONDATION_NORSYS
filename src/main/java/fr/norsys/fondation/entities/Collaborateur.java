package fr.norsys.fondation.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "COLLABORATEUR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COLLABORATEUR")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idCollaborateur")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
public class Collaborateur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_COLLABORATEUR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idCollaborateur;
	@Column(name = "CIN")
	protected String CIN;
	@Column(name = "NOM")
	protected String nom;
	@Column(name = "PRENOM")
	protected String prenom;
	@Column(name = "ADRESSE")
	protected String adresse;
	@Column(name = "NUMERO_TELEPHONE")
	protected String numeroTelephone;
	@Column(name = "EMAIL")
	protected String email;
	@Column(name = "PASSWORD")
	protected String password;
	@Column(name = "DATE_NAISSANCE")
	protected Date dateNaissance;
	@Column(name = "LIEU_NAISSANCE")
	protected String lieuNaissance;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "collaborateurs")
	@JsonIgnore
	protected final List<Activite> activites = new ArrayList<Activite>();

	public Collaborateur() {
	}

	public Collaborateur(int idCollaborateur, String cIN, String nom, String prenom, String adresse,
			String numeroTelephone, String email, String password, Date dateNaissance, String lieuNaissance) {
		super();
		this.idCollaborateur = idCollaborateur;
		this.CIN = cIN;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numeroTelephone = numeroTelephone;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
	}

	public int getIdCollaborateur() {
		return this.idCollaborateur;
	}

	public void setIdCollaborateur(int idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}

	public String getCIN() {
		return this.CIN;
	}

	public void setCIN(String cIN) {
		this.CIN = cIN;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumeroTelephone() {
		return this.numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return this.lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public List<Activite> getActivites() {
		return this.activites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.CIN == null ? 0 : this.CIN.hashCode());
		result = prime * result + (this.adresse == null ? 0 : this.adresse.hashCode());
		result = prime * result + (this.dateNaissance == null ? 0 : this.dateNaissance.hashCode());
		result = prime * result + (this.email == null ? 0 : this.email.hashCode());
		result = prime * result + this.idCollaborateur;
		result = prime * result + (this.lieuNaissance == null ? 0 : this.lieuNaissance.hashCode());
		result = prime * result + (this.nom == null ? 0 : this.nom.hashCode());
		result = prime * result + (this.numeroTelephone == null ? 0 : this.numeroTelephone.hashCode());
		result = prime * result + (this.password == null ? 0 : this.password.hashCode());
		result = prime * result + (this.prenom == null ? 0 : this.prenom.hashCode());
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
		Collaborateur other = (Collaborateur) obj;
		if (this.CIN == null) {
			if (other.CIN != null) {
				return false;
			}
		} else if (!this.CIN.equals(other.CIN)) {
			return false;
		}
		if (this.adresse == null) {
			if (other.adresse != null) {
				return false;
			}
		} else if (!this.adresse.equals(other.adresse)) {
			return false;
		}
		if (this.dateNaissance == null) {
			if (other.dateNaissance != null) {
				return false;
			}
		} else if (!this.dateNaissance.equals(other.dateNaissance)) {
			return false;
		}
		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!this.email.equals(other.email)) {
			return false;
		}
		if (this.idCollaborateur != other.idCollaborateur) {
			return false;
		}
		if (this.lieuNaissance == null) {
			if (other.lieuNaissance != null) {
				return false;
			}
		} else if (!this.lieuNaissance.equals(other.lieuNaissance)) {
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
		if (this.password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!this.password.equals(other.password)) {
			return false;
		}
		if (this.prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!this.prenom.equals(other.prenom)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Collaborateur [idCollaborateur=" + this.idCollaborateur + ", CIN=" + this.CIN + ", nom=" + this.nom
				+ ", prenom=" + this.prenom + ", adresse=" + this.adresse + ", numeroTelephone=" + this.numeroTelephone
				+ ", email=" + this.email + ", password= " + this.password + ", dateNaissance=" + this.dateNaissance
				+ ", lieuNaissance=" + this.lieuNaissance + ", activites number=" + this.activites.size() + "]";
	}

}
