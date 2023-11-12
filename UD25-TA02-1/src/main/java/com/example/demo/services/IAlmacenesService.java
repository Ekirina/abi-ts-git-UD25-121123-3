package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Almacenes;

public interface IAlmacenesService {
	public List<Almacenes> listarAlmacenes(); //Listar ALL
	public Almacenes guardarAlmacenes(Almacenes almacenes); //Guardar
	public Almacenes almacenesXID (Long id); //Leer datos de un cliente READ
	public Almacenes actualizarAlmacenes(Almacenes almacenes); //UPDATE
	public void eliminarAlmacenes (Long id); //DELETE
}
