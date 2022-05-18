package com.filme.service;

import com.filme.model.Filme;
import com.filme.repository.FilmeRepository;

public class RegraRepository {
    FilmeRepository repository = new FilmeRepository();

    public void salva(Filme filme) {
        if (filme != null) {
            repository.craeteFilme(filme);
        } else {
            System.out.println("Informações invalidas");
        }
    }

    public void atualiza(Filme filme) {
        if (filme != null) {
            repository.updateFilme(filme);
        } else {
            System.out.println("Informações invalidas");
        }
    }

    public void delete(int id) {
        repository.deleteFilme(id);
    }

    public Filme ler(int id) {
       return repository.getFilmeId(id);
    }
}