package com.spiderdiplome.repository.dao;

import com.spiderdiplome.models.HistoriqueConnexion;

import java.util.List;

public interface HistoriqueConnexionDAO {
    void create(HistoriqueConnexion historiqueConnexion);

    HistoriqueConnexion read(int id);

    void update(HistoriqueConnexion historiqueConnexion);

    void delete(HistoriqueConnexion historiqueConnexion);

    List<HistoriqueConnexion> readAll();
}