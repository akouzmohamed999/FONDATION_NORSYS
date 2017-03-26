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

@Entity
@Table(name = "ACTIVITE")
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
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Collaborateur.class)
	@JoinColumn(name = "ID_GERANT")
	private Collaborateur gerant;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Projet.class)
	@JoinColumn(name = "ID_PROJET")
	private Projet projet;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "COLLABORATEUR_ACTIVITE", joinColumns = {
			@JoinColumn(referencedColumnName = "ID_ACTIVITE") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "ID_COLLABORATEUR") })
	private List<Collaborateur> collaborateurs;

	@ManyToMany(fetch = FetchType.LAZY)
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

	public List<Collaborateur> getCollaborateurs() {
		return this.collaborateurs;
	}

	public void setCollaborateurs(List<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Activite() {
	}

	public Collaborateur getGerant() {
		return this.gerant;
	}

	public void setGerant(Collaborateur gerant) {
		this.gerant = gerant;
	}

	public List<Contact> getContatcs() {
		return this.contatcs;
	}

	public void setContatcs(List<Contact> contatcs) {
		this.contatcs = contatcs;
	}

	public Activite(String intitule, Date dateActivite, String dureeActivite, String etat, String lieu,
			Collaborateur gerant, Projet projet, List<Collaborateur> collaborateurs) {
		super();
		this.intitule = intitule;
		this.dateActivite = dateActivite;
		this.dureeActivite = dureeActivite;
		this.etat = etat;
		this.lieu = lieu;
		this.gerant = gerant;
		this.projet = projet;
		this.collaborateurs = collaborateurs;
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

	@Override
	public String toString() {
		return "Activite [idActivite=" + this.idActivite + ", intitule=" + this.intitule + ", dateActivite="
				+ this.dateActivite + ", dureeActivite=" + this.dureeActivite + ", etat=" + this.etat + ", lieu="
				+ this.lieu + ", gerant=" + this.gerant + ", projet=" + this.projet + ", collaborateurs="
				+ this.collaborateurs + ", contatcs=" + this.contatcs + "]";
	}

}
