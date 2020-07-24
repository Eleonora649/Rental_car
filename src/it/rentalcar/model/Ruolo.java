package it.rentalcar.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="ruolo")
public class Ruolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ruolo")
	private int idRuolo;

	private String descrizione;

	@Column(name="nome_ruolo")
	private String nomeRuolo;

	@ManyToMany
	private List<Utente> utente;

	public Ruolo() {
	}

	public int getIdRuolo() {
		return this.idRuolo;
	}

	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNomeRuolo() {
		return this.nomeRuolo;
	}

	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}

	public List<Utente> getUtentes() {
		return this.utente;
	}

	public void setUtente(List<Utente> utente) {
		this.utente = utente;
	}

}