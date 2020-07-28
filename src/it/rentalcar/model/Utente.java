package it.rentalcar.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "Utente")
@Table(name="utente")
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="id_utente")
	private int idUtente;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_di_nascita")
	private Date dataDiNascita;
	
	@OneToMany(mappedBy="utente")
	private List<Prenotazione> prenotazione;

	@ManyToMany
	@JoinTable(name="utente_ruolo", joinColumns={@JoinColumn(name="id_utente")}, 
				inverseJoinColumns={@JoinColumn(name="id_ruolo")})
	private List<Ruolo> ruolo;

	public Utente() {
	}
	
	public Utente(String nome, String cognome, Date data, String email, String password) {
		this.nome=nome;
		this.cognome=cognome;
		this.dataDiNascita=data;
		this.email=email;
		this.password=password;
	}
	
	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return this.dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Prenotazione> getPrenotazione() {
		return this.prenotazione;
	}

	public void setPrenotazione(List<Prenotazione> prenotazione) {
		this.prenotazione = prenotazione;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotazione().add(prenotazione);
		prenotazione.setUtente(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotazione().remove(prenotazione);
		prenotazione.setUtente(null);

		return prenotazione;
	}

	public List<Ruolo> getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(List<Ruolo> ruolo) {
		this.ruolo = ruolo;
	}

}