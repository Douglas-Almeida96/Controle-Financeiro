package com.controlefinaceiro.controlefinaceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlefinaceiro.controlefinaceiro.models.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Long>{
}
