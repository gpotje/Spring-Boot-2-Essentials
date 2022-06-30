package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.domain.Anime;

@Service
public class AnimeService {

	private static List<Anime> animes;

	static {
		animes = new ArrayList<>(
				List.of(new Anime(1l, "Naruto"), new Anime(2l, "yu-gi-oh"), new Anime(3l, "yu yu haskusho")));
	}

	public List<Anime> listAll() {
		return animes;
	}

	public Anime findById(Long id) {
		return animes.stream().filter(anime -> anime.getId().equals(id)).findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
	}

	public Anime save(Anime anime) {
		anime.setId(ThreadLocalRandom.current().nextLong(3, 10000));
		animes.add(anime);
		return anime;
	}

	public void delete(Long id) {
		animes.remove(findById(id));

	}

	public void replace(Anime anime) {
		delete(anime.getId());
		animes.add(anime);
	}

}
