package fr.norsys.fondation.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "CONTACT")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idContact")
public class Contact {

	@Id
	@Column(name = "ID_CONTACT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContact;
	@Column(name = "CIN")
	private String CIN;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@Column(name = "DATE_NAISSANCE")
	private Date dateNaissance;
	@Column(name = "LIEU_NAISSANCE")
	private String lieuNaissance;
	@Column(name = "NUM_TELEPHONE")
	private String numTelephone;
	@Column(name = "PAYS")
	private String pays;
	@Column(name = "ADRESSe")
	private String adresse;
	@Column(name = "TYPE_CONTACT")
	private String typeContact;
	@ManyToMany(mappedBy = "contatcs")
	private List<Activite> activites;

	public int getIdContact() {
		return this.idContact;
	}

	public void setIdContact(int idContact) {
		this.idContact = idContact;
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

	public String getNumTelephone() {
		return this.numTelephone;
	}

	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTypeContact() {
		return this.typeContact;
	}

	public void setTypeContact(String typeContact) {
		this.typeContact = typeContact;
	}

	public List<Activite> getActivites() {
		return this.activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public Contact() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.CIN == null ? 0 : this.CIN.hashCode());
		result = prime * result + (this.activites == null ? 0 : this.activites.hashCode());
		result = prime * result + (this.adresse == null ? 0 : this.adresse.hashCode());
		result = prime * result + (this.dateNaissance == null ? 0 : this.dateNaissance.hashCode());
		result = prime * result + this.idContact;
		result = prime * result + (this.lieuNaissance == null ? 0 : this.lieuNaissance.hashCode());
		result = prime * result + (this.nom == null ? 0 : this.nom.hashCode());
		result = prime * result + (this.numTelephone == null ? 0 : this.numTelephone.hashCode());
		result = prime * result + (this.pays == null ? 0 : this.pays.hashCode());
		result = prime * result + (this.prenom == null ? 0 : this.prenom.hashCode());
		result = prime * result + (this.typeContact == null ? 0 : this.typeContact.hashCode());
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
		Contact other = (Contact) obj;
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
		if (this.idContact != other.idContact) {
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
		if (this.numTelephone == null) {
			if (other.numTelephone != null) {
				return false;
			}
		} else if (!this.numTelephone.equals(other.numTelephone)) {
			return false;
		}
		if (this.pays == null) {
			if (other.pays != null) {
				return false;
			}
		} else if (!this.pays.equals(other.pays)) {
			return false;
		}
		if (this.prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!this.prenom.equals(other.prenom)) {
			return false;
		}
		if (this.typeContact == null) {
			if (other.typeContact != null) {
				return false;
			}
		} else if (!this.typeContact.equals(other.typeContact)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Contact [idContact=" + this.idContact + ", CIN=" + this.CIN + ", nom=" + this.nom + ", prenom="
				+ this.prenom + ", dateNaissance=" + this.dateNaissance + ", lieuNaissance=" + this.lieuNaissance
				+ ", numTelephone=" + this.numTelephone + ", pays=" + this.pays + ", adresse=" + this.adresse
				+ ", typeContact=" + this.typeContact + ", activites number=" + this.activites.size() + "]";
	}

	public Contact(int idContact, String cIN, String nom, String prenom, Date dateNaissance, String lieuNaissance,
			String numTelephone, String pays, String adresse, String typeContact) {
		super();
		this.idContact = idContact;
		this.CIN = cIN;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.numTelephone = numTelephone;
		this.pays = pays;
		this.adresse = adresse;
		this.typeContact = typeContact;
	}

}
