package com.spiderdiplome.repository.dao;

import com.spiderdiplome.models.Document;

import java.util.List;

public interface DocumentDAO {
    Document findById(int id);

    List<Document> findAll();

    void save(Document document);

    void update(Document document);

    void delete(Document document);
}