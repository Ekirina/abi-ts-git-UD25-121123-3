package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajasDAO;
import com.example.demo.dto.Cajas;

@Service
public class CajasServiceImpl implements ICajasService {
	@Autowired
	ICajasDAO iCajasDAO;

	@Override
	public List<Cajas> listarCajas() {
		return iCajasDAO.findAll();
	}

	@Override
	public Cajas guardarCajas(Cajas cajas) {
		return iCajasDAO.save(cajas);
	}

	@Override
	public Cajas cajasXREF(String num_referencia) {
		return iCajasDAO.findById(num_referencia).get();

	}

	@Override
	public Cajas actualizarCajas(Cajas cajas) {
		return iCajasDAO.save(cajas);

	}

	@Override
	public void eliminarCajas(String num_referencia) {
		iCajasDAO.deleteById(num_referencia);			
	}

}
