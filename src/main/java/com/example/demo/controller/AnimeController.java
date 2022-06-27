package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Anime;
import com.example.demo.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/anime")
@Log4j2
@AllArgsConstructor
public class AnimeController {
	
	private DateUtil dateUtil;
	
	@GetMapping("/list")
	public List<Anime> list(){
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return List.of(new Anime("Naruto"), new Anime("yu-gi-oh"), new Anime("yu yu haskusho"));
	}	

}
