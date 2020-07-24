package it.rentalcar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="utente_ruolo")
public class UtenteRuolo implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name="id_utente")
	@OneToMany
	@JoinColumn(name="id_utente")
	//private int idUtente; 
	private List<Utente> utente = new ArrayList<Utente>();
	

	@Column(name="id_ruolo")
	@OneToMany
	@JoinColumn(name="id_ruolo")
	//private int idRuolo;
	private List<Ruolo> ruolo = new ArrayList<Ruolo>();
	
}
