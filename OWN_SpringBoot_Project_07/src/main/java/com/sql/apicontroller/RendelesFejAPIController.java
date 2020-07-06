package com.sql.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sql.model.RendelesByDateAndName;
import com.sql.model.RendelesByGreatherThen;
import com.sql.model.RendelesFejTermekLista;
import com.sql.service.RendelesFejService;

@RequestMapping("rendelesfej")
@RestController
public class RendelesFejAPIController {
	
	private RendelesFejService rendelesFejService;

	@Autowired
	public void setRendelesFejService(RendelesFejService rendelesFejService) {
		this.rendelesFejService = rendelesFejService;
	}

	@GetMapping(path = "countProductsOrderdByCustomers")
	public List<RendelesFejTermekLista> countProductsOrderdByCustomers(){
		
		return rendelesFejService.countProductsOrderdByCustomers();
	}
	
	@GetMapping("findOrderByNameAndDate/{date1}/{date2}/{userId}")
	public List<RendelesByDateAndName>  findOrderByNameAndDate(@PathVariable("date1")String date1, 
			@PathVariable("date2")String date2, @PathVariable("userId") Integer userId ){
		
		return rendelesFejService.findOrderByNameAndDate(userId, date1, date2);
	}
	@GetMapping("findOrderThatOneTypeProductQTYIsGreatherThanX/{date1}/{date2}/{productcode}/{qty}")
	public List<RendelesByGreatherThen> findOrderThatOneTypeProductQTYIsGreatherThanX(@PathVariable("date1")String date1, @PathVariable("date2") String date2,
			@PathVariable("productcode")String productcode,@PathVariable("qty") Integer qty){
		
		return rendelesFejService.findOrderThatOneTypeProductQTYIsGreatherThanX(date1, date2, productcode, qty);
	}
}
