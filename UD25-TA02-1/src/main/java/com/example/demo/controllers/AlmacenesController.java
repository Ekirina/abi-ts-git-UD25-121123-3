package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Almacenes;
import com.example.demo.services.AlmacenesServiceImpl;

@RestController
@RequestMapping("/api")
public class AlmacenesController {
	@Autowired
	AlmacenesServiceImpl almacenesServiceImpl;
	@GetMapping("/almacenes")
	public List<Almacenes> listarAlmacenes(){
		return almacenesServiceImpl.listarAlmacenes();
	}
	                                                
	@PostMapping("/almacenes")
	public Almacenes salvarAlmacenes(@RequestBody Almacenes almacenes) {
		return almacenesServiceImpl.guardarAlmacenes(almacenes);
	}
	@GetMapping("/almacenes/{id}")
	public Almacenes almacenesXID(@PathVariable(name="id")Long id) {
		Almacenes almacenes_xid = new Almacenes();
		almacenes_xid = almacenesServiceImpl.almacenesXID(id);
		System.out.println("Almacenes XID: "+almacenes_xid);
		return almacenes_xid;
	}
	@PutMapping("/almacenes/{id}")
	public Almacenes actualizarAlmacenes(@PathVariable(name="id")Long id, @RequestBody Almacenes almacenes) {
		Almacenes almacenes_seleccionado = new Almacenes();
		Almacenes almacenes_actualizado = new Almacenes();
		
		almacenes_seleccionado = almacenesServiceImpl.almacenesXID(id);
		
		almacenes_seleccionado.setLugar(almacenes.getLugar());
		almacenes_seleccionado.setCapacidad(almacenes.getCapacidad());
		
		almacenes_actualizado = almacenesServiceImpl.actualizarAlmacenes(almacenes_seleccionado);
		System.out.println("El almacén actualizado es: "+almacenes_actualizado);
		
		return almacenes_actualizado;
	}
	@DeleteMapping("/almacenes/{id}")
	public void eliminarAlmacenes (@PathVariable(name="id")Long id) {
		almacenesServiceImpl.eliminarAlmacenes(id);
	}
	
}