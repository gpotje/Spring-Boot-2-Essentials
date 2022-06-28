package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Anime;

@Service
public class AnimeService {
	
	public List<Anime> listAll(){
		return List.of(new Anime(1l,"Naruto"), new Anime(2l,"yu-gi-oh"), new Anime(3l,"yu yu haskusho"));
	}

}
