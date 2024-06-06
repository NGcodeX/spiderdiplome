package com.spiderdiplome.repository.dao;

import com.spiderdiplome.models.Notification;

import java.util.List;

public interface NotificationDAO {
    List<Notification> findAll();

    Notification findById(int id);

    void save(Notification notification);

    void update(Notification notification);

    void delete(Notification notification);
}
