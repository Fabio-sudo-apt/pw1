package com.filme.controller;

import com.filme.model.Filme;
import com.filme.service.RegraRepository;

public class Api {
    RegraRepository regraRepository = new RegraRepository();

    public void salvaFilme(Filme filme){
        regraRepository.salva(filme);
    }

    public void atualizaFilme(Filme filme){
        regraRepository.atualiza(filme);
    }

    public void deleteFilme(int id) {
        regraRepository.delete(id);
    }

    public Filme getFilme(int id) {
       return regraRepository.ler(id);
    }
}
