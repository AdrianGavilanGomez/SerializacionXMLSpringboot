package cat.prateducacio.dam.mp06.uf03.p02xml.model.domain;

import java.io.Serializable;

public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Empresa()
	{
		
	}
	public Empresa(String cif, String nom) {
		super();
		this.cif = cif;
		this.nom = nom;
	}

	private String cif;
	private String nom = "Nom Empresa per defecte";

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
