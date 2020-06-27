package com.sql.apicontroller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sql.model.Rendeles;
import com.sql.model.RendelesNev;
import com.sql.service.RendelesService;

@RestController
@RequestMapping("rendeles")
public class RendelesAPIController {
	
	private RendelesService rendelesService;
	
	@Autowired
	public void setRendelesService(RendelesService rendelesService) {
		this.rendelesService = rendelesService;
	}

	@GetMapping(path = "/{date1}/{date2}/{searchchar}")
	public List<Rendeles> findOrderByCharByDate(@PathVariable("date1") String date1,@PathVariable("date2") String date2, @PathVariable("searchchar") char searchchar,HttpServletResponse response) {

		 return rendelesService.findOrderByCharByDate(searchchar, date1, date2);
	}
	
	@GetMapping(path = "/deadline/{date}")
	public List<Rendeles> findProductsUntilDeadline(@PathVariable("date") String date,HttpServletResponse response) {

		 return rendelesService.findProductsUntilDeadline(date);
	}
	
	@GetMapping(path = "/remained")
	public Integer totalPiecesRemainUndelivered() {

		 return rendelesService.totalPiecesRemainUndelivered();
	}
	
	@GetMapping(path = "/findOrderByTwoProductsFromOrder/{product1}/{product2}")
	public List<RendelesNev> findOrderByTwoProductsFromOrder(@PathVariable("product1") String product1 ,@PathVariable("product2") String product2,HttpServletResponse response){
		
		return rendelesService.findOrderByTwoProductsFromOrder(product1, product2);
	}
	
}
