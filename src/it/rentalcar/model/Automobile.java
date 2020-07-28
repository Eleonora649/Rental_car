package it.rentalcar.model;

import java.io.Serializable;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="automobile")
@NamedQuery(name="Automobile.findAll", query="SELECT a FROM Automobile a")
public class Automobile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_automobile")
	private int idAutomobile;
	
	@Column(name="anno_immatricolazione")
	private int annoImmatricolazione;
	
	@Column(name="casa_costruttrice")
	private String casaCostruttrice;
	
	private String modello;
	private String targa;

	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	@OneToMany(mappedBy="automobile")
	private List<Prenotazione> prenotazione;

	public Automobile() {
	}
	
	public Automobile(String modello, String targa, String casaCostruttrice, int annoImmatricolazione, Categoria categoria) {
		this.modello = modello;
		this.targa = targa;
		this.casaCostruttrice = casaCostruttrice;
		this.annoImmatricolazione = annoImmatricolazione;
		this.categoria=categoria;
	}

	public int getIdAutomobile() {
		return this.idAutomobile;
	}

	public void setIdAutomobile(int idAutomobile) {
		this.idAutomobile = idAutomobile;
	}

	public int getAnnoImmatricolazione() {
		return this.annoImmatricolazione;
	}

	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}

	public String getCasaCostruttrice() {
		return this.casaCostruttrice;
	}

	public void setCasaCostruttrice(String casaCostruttrice) {
		this.casaCostruttrice = casaCostruttrice;
	}

	public String getModello() {
		return this.modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return this.targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotazione;
	}

	public void setPrenotaziones(List<Prenotazione> prenotazione) {
		this.prenotazione = prenotazione;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setAutomobile(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setAutomobile(null);

		return prenotazione;
	}

}