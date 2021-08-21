package com.controlefinaceiro.controlefinaceiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlefinaceiro.controlefinaceiro.models.Gasto;
import com.controlefinaceiro.controlefinaceiro.repository.GastoRepository;

@Service
public class GastoServiceImpl implements GastoService {

	@Autowired
	GastoRepository gastoRepository;
	
	@Override
	public List<Gasto> findAll() {
		return gastoRepository.findAll();
	}

	@Override
	public Gasto findById(long id) {
		return gastoRepository.findById(id).get();
	}

	@Override
	public Gasto save(Gasto gasto) {
		return gastoRepository.save(gasto);
	}
	
	@Override
	public double TotalGasto(){
		return gastoRepository.findAll().stream()
        .mapToDouble(Gasto::getValor)
        .sum();
	}

	@Override
	public void delete(Long id) {
		gastoRepository.deleteById(id);
	}

	@Override
	public Gasto edit(Gasto gasto) {
		return gastoRepository.save(gasto);
	}
}
