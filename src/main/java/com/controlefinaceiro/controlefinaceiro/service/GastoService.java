package com.controlefinaceiro.controlefinaceiro.service;

import java.util.List;


import com.controlefinaceiro.controlefinaceiro.models.Gasto;


public interface GastoService {
	
	List<Gasto> findAll();
	Gasto findById(long id);
	Gasto save(Gasto gasto);
	void delete(Long id);
	Gasto edit(Gasto gasto);
	double TotalGasto();
	
}
