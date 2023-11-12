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

import com.example.demo.dto.Cajas;
import com.example.demo.services.CajasServiceImpl;

@RestController
@RequestMapping("/api")
public class CajasController {
	@Autowired
	CajasServiceImpl cajasServiceImpl;
	
	@GetMapping("/cajas")
	public List<Cajas> listarCajas(){
		return cajasServiceImpl.listarCajas();
	}
	
	@PostMapping("/cajas")
	public Cajas salvarCajas(@RequestBody Cajas articulos) {
		return cajasServiceImpl.guardarCajas(articulos);
	}
	@GetMapping("/cajas/{id}")
	public Cajas cajasXREF(@PathVariable(name="num_referencia")String num_referencia) {
		Cajas cajas_xref = new Cajas();
		cajas_xref = cajasServiceImpl.cajasXREF(num_referencia);
		System.out.println("Cajas XREF: "+cajas_xref);
		return cajas_xref;
	}
	@PutMapping("/cajas/{id}")
	public Cajas actualizarCajas(@PathVariable(name="num_referencia")String num_referencia, @RequestBody Cajas cajas) {
		Cajas cajas_seleccionado = new Cajas();
		Cajas cajas_actualizado = new Cajas();
		
		cajas_seleccionado = cajasServiceImpl.cajasXREF(num_referencia);
		
		cajas_seleccionado.setContenido(cajas.getContenido());
		cajas_seleccionado.setValor(cajas.getValor());
		cajas_seleccionado.setAlmacenes(cajas.getAlmacenes());
		
		cajas_actualizado = cajasServiceImpl.actualizarCajas(cajas_seleccionado);
		System.out.println("El artículo actualizado es: "+cajas_actualizado);
		
		return cajas_actualizado;
	}
	@DeleteMapping("/cajas/{id}")
	public void eliminarCajas (@PathVariable(name="num_referencia")String num_referencia) {
		cajasServiceImpl.eliminarCajas(num_referencia);
	}
}
	


