package com.filme;

import com.filme.controller.Api;
import com.filme.model.Filme;

public class App {
    public static void main(String[] args) {
        Filme filme = new Filme();
        Filme filme1 = new Filme();


        Api api = new Api();

        filme.setTitulo("Vingadores");
        filme.setData("10/02/2000");
        filme.setDuracao(120);
        filme.setPreco(7.9);

        filme1.setTitulo("test");
        filme1.setData("11/02/2000");
        filme1.setDuracao(220);
        filme1.setPreco(10);

        api.salvaFilme(filme);
        api.salvaFilme(filme1);

        api.atualizaFilme(filme);

        Filme filmeTest = api.getFilme(filme.getId());

        System.out.println(filmeTest.getTitulo());

        api.deleteFilme(filme1.getId());
    }
}
