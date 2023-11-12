package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Cajas;

public interface ICajasService {
	public List<Cajas> listarCajas(); //Listar ALL
	public Cajas guardarCajas(Cajas cajas); //Guardar
	public Cajas cajasXREF (String num_referencia); //Leer datos de un cliente READ
	public Cajas actualizarCajas(Cajas cajas); //UPDATE
	public void eliminarCajas (String num_referencia); //DELETE
}
