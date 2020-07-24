package it.rentalcar.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_categoria")
	private int idCategoria;

	private String nome;

	@OneToMany(mappedBy="categoria")
	private List<Automobile> automobiles;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Automobile> getAutomobiles() {
		return this.automobiles;
	}

	public void setAutomobiles(List<Automobile> automobiles) {
		this.automobiles = automobiles;
	}

	public Automobile addAutomobile(Automobile automobile) {
		getAutomobiles().add(automobile);
		automobile.setCategoria(this);

		return automobile;
	}

	public Automobile removeAutomobile(Automobile automobile) {
		getAutomobiles().remove(automobile);
		automobile.setCategoria(null);

		return automobile;
	}

}