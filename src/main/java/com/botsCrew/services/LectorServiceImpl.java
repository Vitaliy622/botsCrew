package com.botsCrew.services;

import com.botsCrew.models.Lector;
import com.botsCrew.repositories.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorServiceImpl {

    @Autowired
    private final LectorRepository lectorRepository;

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    public List<Lector> saveAllLectors(List<Lector> lectorList) {
        return lectorRepository.saveAll(lectorList);
    }
}
