package com.spiderdiplome.repository.dao;

import com.spiderdiplome.models.Universite;

import java.util.List;

public interface UniversiteDAO {
    Universite findById(int id);

    List<Universite> findAll();

    void save(Universite universite);

    void update(Universite universite);

    void delete(Universite universite);
}
