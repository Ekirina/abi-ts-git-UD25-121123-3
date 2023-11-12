package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cajas")
public class Cajas {
	//Atributos de entidad Cajas
	@Id
	private String num_referencia;
	@Column(name = "contenido")
	private String contenido;
	@Column(name = "valor")
	private Integer valor;
	
	@ManyToOne
	@JoinColumn(name = "codigo_almacen")
	private Almacenes almacenes;
	//constructores
	public Cajas(){
	}
	//@param num_referencia - @param contenido - @param valor - @param codigo_almacen
	public Cajas(String num_referencia, String contenido, Integer valor, Almacenes almacenes) {
		//super();
		this.num_referencia = num_referencia;
		this.contenido = contenido;
		this.valor = valor;
		this.almacenes = almacenes;
	}
	//Getters y setters
	public String getNum_referencia() {
		return num_referencia;
	}
	public void setNum_referencia(String num_referencia) {
		this.num_referencia = num_referencia;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Almacenes getAlmacenes() {
		return almacenes;
	}
	public void setAlmacenes(Almacenes almacenes) {
		this.almacenes = almacenes;
	}
	//Método String
	@Override
	public String toString() {
		return "Cajas [num_referencia=" + num_referencia + ", contenido=" + contenido + ", valor=" + valor
				+ ", almacenes=" + almacenes + "]";
	}
	
}
