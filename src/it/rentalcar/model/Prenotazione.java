package it.rentalcar.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="prenotazione")
@NamedQuery(name="Prenotazione.findAll", query="SELECT p FROM Prenotazione p")
public class Prenotazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_prenotazione")
	private int idPrenotazione;

	@Column(name="fine_prenotazione")
	private Date finePrenotazione;

	@Column(name="inizio_prenotazione")
	private Date inizioPrenotazione;

	@ManyToOne
	@JoinColumn(name="id_utente")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name="id_automobile")
	private Automobile automobile;

	public Prenotazione() {
	}

	public Prenotazione(Date inizioPrenotazione, Date finePrenotazione, Utente utente, Automobile automobile) {
		this.inizioPrenotazione=inizioPrenotazione;
		this.finePrenotazione=finePrenotazione;
		this.utente=utente;
		this.automobile=automobile;
	}

	public int getIdPrenotazione() {
		return this.idPrenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public Date getFinePrenotazione() {
		return this.finePrenotazione;
	}

	public void setFinePrenotazione(Date finePrenotazione) {
		this.finePrenotazione = finePrenotazione;
	}

	public Date getInizioPrenotazione() {
		return this.inizioPrenotazione;
	}

	public void setInizioPrenotazione(Date inizioPrenotazione) {
		this.inizioPrenotazione = inizioPrenotazione;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Automobile getAutomobile() {
		return this.automobile;
	}

	public void setAutomobile(Automobile automobile) {
		this.automobile = automobile;
	}

}