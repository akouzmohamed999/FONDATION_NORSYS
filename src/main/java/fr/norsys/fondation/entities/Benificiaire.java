package fr.norsys.fondation.entities;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "BENIFICIAIRE")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idBenificiaire")
public class Benificiaire implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_BENIFICIAIRE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBenificiaire;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@Column(name = "CIN")
	private String CIN;
	@Column(name = "AGE")
	private Integer age;
	@Column(name = "PAYS")
	private String pays;
	@Column(name = "VILLE")
	private String ville;
	@Column(name = "ADRESSE")
	private String adresse;
	@Column(name = "NUMERO_TELEPHONE")
	private String numeroTelephone;
	@ManyToMany(mappedBy = "benificiaires")
	private List<Activite> activites = new ArrayList<Activite>();

	public Benificiaire() {
	}

	public Benificiaire(int idBenificiaire, String nom, String prenom, String cIN, int age, String pays, String ville,
			String adresse, String numeroTelephone) {
		super();
		this.idBenificiaire = idBenificiaire;
		this.nom = nom;
		this.prenom = prenom;
		this.CIN = cIN;
		this.age = age;
		this.pays = pays;
		this.ville = ville;
		this.adresse = adresse;
		this.numeroTelephone = numeroTelephone;
	}

	public Benificiaire(int idBenificiaire, String nom, String prenom, String cIN, String pays, String ville,
			String adresse) {
		super();
		this.idBenificiaire = idBenificiaire;
		this.nom = nom;
		this.prenom = prenom;
		this.CIN = cIN;
		this.pays = pays;
		this.ville = ville;
		this.adresse = adresse;
	}

	public int getIdBenificiaire() {
		return this.idBenificiaire;
	}

	public void setIdBenificiaire(int idBenificiaire) {
		this.idBenificiaire = idBenificiaire;
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

	public String getCIN() {
		return this.CIN;
	}

	public void setCIN(String cIN) {
		this.CIN = cIN;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
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
		result = prime * result + (this.CIN == null ? 0 : this.CIN.hashCode());
		result = prime * result + (this.adresse == null ? 0 : this.adresse.hashCode());
		result = prime * result + this.age;
		result = prime * result + this.idBenificiaire;
		result = prime * result + (this.nom == null ? 0 : this.nom.hashCode());
		result = prime * result + (this.numeroTelephone == null ? 0 : this.numeroTelephone.hashCode());
		result = prime * result + (this.pays == null ? 0 : this.pays.hashCode());
		result = prime * result + (this.prenom == null ? 0 : this.prenom.hashCode());
		result = prime * result + (this.ville == null ? 0 : this.ville.hashCode());
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
		Benificiaire other = (Benificiaire) obj;
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
		if (this.age != other.age) {
			return false;
		}
		if (this.idBenificiaire != other.idBenificiaire) {
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
		if (this.ville == null) {
			if (other.ville != null) {
				return false;
			}
		} else if (!this.ville.equals(other.ville)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Benificiaire [idBenificiaire=" + this.idBenificiaire + ", nom=" + this.nom + ", prenom=" + this.prenom
				+ ", CIN=" + this.CIN + ", age=" + this.age + ", pays=" + this.pays + ", ville=" + this.ville
				+ ", adresse=" + this.adresse + ", numeroTelephone=" + this.numeroTelephone + ", activites number="
				+ this.activites.size() + "]";
	}

}
