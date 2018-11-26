package com.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bean.Emp;

@RestController
@RequestMapping("/boot/v2/feign")
public class FeignController {

	private static final Logger logger = LoggerFactory.getLogger(FeignController.class);
	
	/**
	 * Post
	 */
	@PostMapping("/singleParam")
	public Object post(@RequestBody Map<String, String> param) {
		logger.info("Map<String, String> param: {}", param);
		return param;
	}
	
	@PostMapping("/doubleParam")
	public Object post(@RequestBody Map<String, String> parama, Map<String, String> paramb) {
		logger.info("Map<String, String> parama: {} , Map<String, String> paramb: {} ", parama, paramb);
		Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
		result.put("parama", parama);
		result.put("paramb", paramb);
		return result;
	}
	
	
	/**
	 * Get
	 */
	@GetMapping
	public Object get(Emp emp) {
		logger.info("Emp emp: {}", emp.toString());
		return emp;
	}
	
	@GetMapping("/pathId/{id}")
	public Object getPath(@PathVariable String id) {
		logger.info("String id: {}", id);
		return id;
	}
	
	@GetMapping("/paramId")
	public Object getParam(@RequestParam String id) {
		logger.info("String id: {}", id);
		return id;
	}
	
	/**
	 * Put
	 */
	@PutMapping("{id}")
	public Object put(@PathVariable String id, @RequestBody Map<String, String> param) {
		logger.info("String id: {} ,Map<String, String> param: {}", id, param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", id);
		result.put("param", param);
		return result;
	}
	
	/**
	 * Delete
	 */
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable String id) {
		logger.info("String id: {}", id);
		return id;
	}
	
}
