package com.filme.repository;

import java.util.ArrayList;
import java.util.List;

import com.filme.config.DatabaseConfig;
import com.filme.model.Filme;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class FilmeRepository {
    public void craeteFilme(Filme filme) {
        Session session = DatabaseConfig.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(filme);
        transaction.commit();
    }

    public void updateFilme(Filme filme) {
        Session session = DatabaseConfig.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(filme);
        transaction.commit();
    }

    public Filme getFilmeId(int id) {
        Session session = DatabaseConfig.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        Filme getFilme = session.get(Filme.class, id);
        transaction.commit();

        return getFilme;
    }

    public void deleteFilme(int id) {
        Session session = DatabaseConfig.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        Filme getFilme = session.get(Filme.class, id);
        session.delete(getFilme);
        transaction.commit();
    }

    public List<Filme> getListFilmes() {
        List<Filme> listFilmes = new ArrayList<Filme>();
        Session session = DatabaseConfig.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        listFilmes = session.createQuery("from filmes").list();
        transaction.commit();

        return listFilmes;
    }
}