package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Anime;
import com.example.demo.service.AnimeService;
import com.example.demo.util.DateUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
	
	private  final DateUtil dateUtil;
	
	private final AnimeService service;
	
	@GetMapping
	public ResponseEntity<List<Anime>> list(){
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return ResponseEntity.ok(service.listAll());
	}	

	@GetMapping("/{id}")
	public ResponseEntity<Anime> FindById(@PathVariable Long id){
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return ResponseEntity.ok(service.findById(id));
	}	
	
	@PostMapping
	public ResponseEntity<Anime> save(@RequestBody Anime anime){
		return new ResponseEntity<>(service.save(anime),HttpStatus.CREATED);
	}
}
