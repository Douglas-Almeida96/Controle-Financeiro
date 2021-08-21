package com.controlefinaceiro.controlefinaceiro.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.controlefinaceiro.controlefinaceiro.models.Gasto;
import com.controlefinaceiro.controlefinaceiro.service.GastoService;




@Controller
public class GastoController {
	
	@Autowired
	private GastoService gastoService;
	
	@RequestMapping(value = "/gastos", method = RequestMethod.GET)
	public ModelAndView getGastos() {
		ModelAndView mv = new ModelAndView("gastos");
		List<Gasto> gastos = gastoService.findAll();
		double total = gastoService.TotalGasto();
		mv.addObject("gastos", gastos);
		mv.addObject("total", total);
		return mv;
		
	}
	
	@RequestMapping(value = "/gastos/{id}", method = RequestMethod.GET)
	public ModelAndView getGastosDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("gastosDetails");
		Gasto gasto = gastoService.findById(id);
		mv.addObject("gasto", gasto);
 				
		return mv;
		
	} 
	
	@RequestMapping(value = "/novoGasto", method = RequestMethod.GET)
	public String form() {
		return "formGasto";
	}
	

	@RequestMapping(value = "/novoGasto", method = RequestMethod.POST)
	public String saveGasto(@Valid Gasto gasto, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/novoGasto";
		}
		gasto.setData(LocalDate.now());
		gastoService.save(gasto);
		return "redirect:/gastos";
	}
	
	
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
	public String deleteGasto(@PathVariable("id") long id){
		gastoService.delete(id);
		return "redirect:/gastos";
	}
	
	@RequestMapping(value = "/alterar/{id}", method = RequestMethod.GET)
	public ModelAndView getGastosEdit(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("gastosEdit");
		Gasto gasto = gastoService.findById(id);
		mv.addObject("gasto", gasto);
 			
		return mv;
		
	} 
	
	@RequestMapping(value = "/alterar/{id}", method = RequestMethod.POST)
	public String EditdeleteGasto(@Valid Gasto gasto, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()) {
			return "redirect:/alterar/{id}";
		}
		gastoService.edit(gasto);
		return "redirect:/gastos/{id}";
	}
	
}
