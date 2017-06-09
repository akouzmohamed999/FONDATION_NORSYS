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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	@ManyToMany
	@JoinTable(name = "COLLABORATEUR_ACTIVITE", joinColumns = {
			@JoinColumn(referencedColumnName = "ID_COLLABORATEUR", name = "ID_COLLABORATEUR") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "ID_ACTIVITE", name = "ID_ACTIVITE") })
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
		result = prime * result + ((CIN == null) ? 0 : CIN.hashCode());
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idCollaborateur;
		result = prime * result + ((lieuNaissance == null) ? 0 : lieuNaissance.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((numeroTelephone == null) ? 0 : numeroTelephone.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Collaborateur other = (Collaborateur) obj;
		if (CIN == null) {
			if (other.CIN != null)
				return false;
		} else if (!CIN.equals(other.CIN))
			return false;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idCollaborateur != other.idCollaborateur)
			return false;
		if (lieuNaissance == null) {
			if (other.lieuNaissance != null)
				return false;
		} else if (!lieuNaissance.equals(other.lieuNaissance))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numeroTelephone == null) {
			if (other.numeroTelephone != null)
				return false;
		} else if (!numeroTelephone.equals(other.numeroTelephone))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Collaborateur [idCollaborateur=" + idCollaborateur + ", CIN=" + CIN + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + ", numeroTelephone=" + numeroTelephone + ", email=" + email
				+ ", password=" + password + ", dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance
				+ "]";
	}

	
}
