package com.spiderdiplome.repository.dao;

import com.spiderdiplome.models.Candidature;
import java.util.List;

public interface CandidatureDAO {
    List<Candidature> findAll();
    Candidature findById(int id);
    void save(Candidature candidature);
    void update(Candidature candidature);
    void delete(Candidature candidature);
}
