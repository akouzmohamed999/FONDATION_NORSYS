package fr.norsys.fondation.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "ACTIVITE")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idActivite")
public class Activite implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ACTIVITE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idActivite;
	@Column(name = "INTITULE")
	private String intitule;
	@Column(name = "DATE_ACTIVITE")
	private Date dateActivite;
	@Column(name = "DUREE_ACTIVITE")
	private String dureeActivite;
	@Column(name = "ETAT")
	private String etat;
	@Column(name = "LIEU")
	private String lieu;
	@ManyToOne(targetEntity = Collaborateur.class)
	@JoinColumn(name = "ID_GERANT")
	private Collaborateur gerant;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Projet.class)
	@JoinColumn(name = "ID_PROJET")
	private Projet projet;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	@JoinTable(name = "COLLABORATEUR_ACTIVITE", joinColumns = {
			@JoinColumn(referencedColumnName = "ID_ACTIVITE", name = "ID_ACTIVITE") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "ID_COLLABORATEUR", name = "ID_COLLABORATEUR") })
	private List<Collaborateur> collaborateurs;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	@JoinTable(name = "CONATCT_ACTIVITE", joinColumns = {
			@JoinColumn(referencedColumnName = "ID_ACTIVITE") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "ID_CONTACT") })
	private List<Contact> contatcs;

	public int getIdActivite() {
		return this.idActivite;
	}

	public void setIdActivite(int idActivite) {
		this.idActivite = idActivite;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDateActivite() {
		return this.dateActivite;
	}

	public void setDateActivite(Date dateActivite) {
		this.dateActivite = dateActivite;
	}

	public String getDureeActivite() {
		return this.dureeActivite;
	}

	public void setDureeActivite(String dureeActivite) {
		this.dureeActivite = dureeActivite;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getLieu() {
		return this.lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Collaborateur getGerant() {
		return this.gerant;
	}

	public void setGerant(Collaborateur gerant) {
		this.gerant = gerant;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Collaborateur> getCollaborateurs() {
		return this.collaborateurs;
	}

	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public List<Contact> getContatcs() {
		return this.contatcs;
	}

	public void setContatcs(List<Contact> contatcs) {
		this.contatcs = contatcs;
	}

	public Activite() {
	}

	public Activite(int idActivite, String intitule, Date dateActivite, String dureeActivite, String etat, String lieu,
			Collaborateur gerant, Projet projet) {
		super();
		this.idActivite = idActivite;
		this.intitule = intitule;
		this.dateActivite = dateActivite;
		this.dureeActivite = dureeActivite;
		this.etat = etat;
		this.lieu = lieu;
		this.gerant = gerant;
		this.projet = projet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.collaborateurs == null ? 0 : this.collaborateurs.hashCode());
		result = prime * result + (this.contatcs == null ? 0 : this.contatcs.hashCode());
		result = prime * result + (this.dateActivite == null ? 0 : this.dateActivite.hashCode());
		result = prime * result + (this.dureeActivite == null ? 0 : this.dureeActivite.hashCode());
		result = prime * result + (this.etat == null ? 0 : this.etat.hashCode());
		result = prime * result + (this.gerant == null ? 0 : this.gerant.hashCode());
		result = prime * result + this.idActivite;
		result = prime * result + (this.intitule == null ? 0 : this.intitule.hashCode());
		result = prime * result + (this.lieu == null ? 0 : this.lieu.hashCode());
		result = prime * result + (this.projet == null ? 0 : this.projet.hashCode());
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
		Activite other = (Activite) obj;
		if (this.collaborateurs == null) {
			if (other.collaborateurs != null) {
				return false;
			}
		} else if (!this.collaborateurs.equals(other.collaborateurs)) {
			return false;
		}
		if (this.contatcs == null) {
			if (other.contatcs != null) {
				return false;
			}
		} else if (!this.contatcs.equals(other.contatcs)) {
			return false;
		}
		if (this.dateActivite == null) {
			if (other.dateActivite != null) {
				return false;
			}
		} else if (!this.dateActivite.equals(other.dateActivite)) {
			return false;
		}
		if (this.dureeActivite == null) {
			if (other.dureeActivite != null) {
				return false;
			}
		} else if (!this.dureeActivite.equals(other.dureeActivite)) {
			return false;
		}
		if (this.etat == null) {
			if (other.etat != null) {
				return false;
			}
		} else if (!this.etat.equals(other.etat)) {
			return false;
		}
		if (this.gerant == null) {
			if (other.gerant != null) {
				return false;
			}
		} else if (!this.gerant.equals(other.gerant)) {
			return false;
		}
		if (this.idActivite != other.idActivite) {
			return false;
		}
		if (this.intitule == null) {
			if (other.intitule != null) {
				return false;
			}
		} else if (!this.intitule.equals(other.intitule)) {
			return false;
		}
		if (this.lieu == null) {
			if (other.lieu != null) {
				return false;
			}
		} else if (!this.lieu.equals(other.lieu)) {
			return false;
		}
		if (this.projet == null) {
			if (other.projet != null) {
				return false;
			}
		} else if (!this.projet.equals(other.projet)) {
			return false;
		}
		return true;
	}

}
