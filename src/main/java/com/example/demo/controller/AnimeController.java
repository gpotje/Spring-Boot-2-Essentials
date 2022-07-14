package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Anime;
import com.example.demo.request.AnimesPostRequestBody;
import com.example.demo.request.AnimesPutRequestBody;
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
	public ResponseEntity<Anime> findById(@PathVariable Long id){
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return ResponseEntity.ok(service.findByIdOrThrowBadRequestException(id));
	}	
	
	@GetMapping("/findByName")
	public ResponseEntity<List<Anime>> findByName(@RequestParam  String name){
		return ResponseEntity.ok(service.findByName(name));
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<Void> replace(@PathVariable AnimesPutRequestBody anime){
		service.replace(anime);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	
	
	@PostMapping
	public ResponseEntity<Anime> save(@RequestBody @Valid  AnimesPostRequestBody anime){
		return new ResponseEntity<>(service.save(anime),HttpStatus.CREATED);
	}
}
