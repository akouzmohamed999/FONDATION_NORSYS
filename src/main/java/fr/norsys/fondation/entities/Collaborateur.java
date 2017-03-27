package fr.norsys.fondation.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COLLABORATEUR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COLLABORATOR")
public class Collaborateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_COLLABORATEUR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCollaborateur;
	@Column(name = "CIN")
	private String CIN;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@Column(name = "ADRESSE")
	private String adresse;
	@Column(name = "NUMERO_TELEPHONE")
	private String numeroTelephone;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "DATE_NAISSANCE")
	private Date dateNaissance;
	@Column(name = "LIEU_NAISSANCE")
	private String lieuNaissance;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "collaborateurs")
	private List<Activite> activites;

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

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public Collaborateur(String cIN, String nom, String prenom, String adresse, String numeroTelephone, String email,
			Date dateNaissance, String lieuNaissance) {
		super();
		this.CIN = cIN;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numeroTelephone = numeroTelephone;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
	}

	public Collaborateur() {
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
		if (this.activites == null) {
			if (other.activites != null) {
				return false;
			}
		} else if (!this.activites.equals(other.activites)) {
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
				+ ", email=" + this.email + ", dateNaissance=" + this.dateNaissance + ", lieuNaissance="
				+ this.lieuNaissance + ", activites=" + this.activites + "]";
	}

}
