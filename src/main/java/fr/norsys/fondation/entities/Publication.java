package fr.norsys.fondation.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PUBLICATION")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "@idPublication")
// @JsonIdentityInfo(generator = JSOGGenerator.class)
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PUBLICATION")
	private int idPublication;

	@Column(name = "TITRE")
	private String titre;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@Lob
	@Column(name = "PHOTO")
	private byte[] photo;
	
	@Column(name="VISIBLE")
	private boolean visible;

	@ManyToOne
	@JoinColumn(name = "ID_PROJET")
	private Projet projet;

	public Publication() {
	}

	public Publication(int idPublication, String titre, String description, byte[] photo, Projet projet) {
		super();
		this.idPublication = idPublication;
		this.titre = titre;
		this.description = description;
		this.photo = photo;
		this.projet = projet;
	}

	public int getIdPublication() {
		return this.idPublication;
	}

	public void setIdPublication(int idPublication) {
		this.idPublication = idPublication;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.description == null ? 0 : this.description.hashCode());
		result = prime * result + this.idPublication;
		result = prime * result + Arrays.hashCode(this.photo);
		result = prime * result + (this.projet == null ? 0 : this.projet.hashCode());
		result = prime * result + (this.titre == null ? 0 : this.titre.hashCode());
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
		Publication other = (Publication) obj;
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!this.description.equals(other.description)) {
			return false;
		}
		if (this.idPublication != other.idPublication) {
			return false;
		}
		if (!Arrays.equals(this.photo, other.photo)) {
			return false;
		}
		if (this.projet == null) {
			if (other.projet != null) {
				return false;
			}
		} else if (!this.projet.equals(other.projet)) {
			return false;
		}
		if (this.titre == null) {
			if (other.titre != null) {
				return false;
			}
		} else if (!this.titre.equals(other.titre)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Publication [idPublication=" + this.idPublication + ", titre=" + this.titre + ", description="
				+ this.description + ", projet=" + this.projet + "]";
	}

}
