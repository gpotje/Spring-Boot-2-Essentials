package com.example.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.domain.Anime;
import com.example.demo.repository.AnimeRepository;
import com.example.demo.request.AnimesPostRequestBody;
import com.example.demo.request.AnimesPutRequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeService {

	private final AnimeRepository repository;

	public List<Anime> listAll() {
		return repository.findAll();
	}
	
	public List<Anime> findByName(String name) {
		return repository.findByName(name);
	}

	public Anime findByIdOrThrowBadRequestException(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
	}

	public Anime save(AnimesPostRequestBody anime) {
		return repository.save(Anime.builder().name(anime.getName()).build());
	}

	public void delete(Long id) {
		repository.delete(findByIdOrThrowBadRequestException(id));

	}

	public void replace(AnimesPutRequestBody anime) {
		Anime savedAnime = findByIdOrThrowBadRequestException(anime.getId());
		repository.save(Anime.builder().id(savedAnime.getId()).name(anime.getName()).build());
	}

}
