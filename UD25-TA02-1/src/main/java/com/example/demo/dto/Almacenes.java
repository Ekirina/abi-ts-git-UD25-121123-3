package com.example.demo.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="almacenes")
public class Almacenes {
	//Atributos de la entidad almacenes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca último valor e incrementa desde la id final del db
	private Long id;
	@Column(name = "lugar")
	private String lugar;
	@Column(name = "capacidad")
	private Integer capacidad; //Quizás hay que poner el integer en mayúsuculas y el nombre entero
	
	@OneToMany
	@JoinColumn(name="num_referencia")
	private List <Cajas> cajas;
	
	//Constructores
	public Almacenes(Long id, String lugar, Integer capacidad) {
		super();
		this.id = id;
		this.lugar = lugar;
		this.capacidad = capacidad;
	}
	//Getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	//return Cajas
	@JsonIgnore
	@OnetoMany(fetch=FetchType.LAZY, mappedBy = "Cajas")
	public List<Cajas> getCajas() {
		return cajas;
	}

	public void setCajas(List<Cajas> cajas) {
		this.cajas = cajas;
	}
	//Métodos impresión de datos por consola

	@Override
	public String toString() {
		return "Almacenes [id=" + id + ", lugar=" + lugar + ", capacidad=" + capacidad + "]";
	}
	
	
}
