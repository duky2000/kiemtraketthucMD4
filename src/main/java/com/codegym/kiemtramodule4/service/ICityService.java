package com.codegym.kiemtramodule4.service;

import com.codegym.kiemtramodule4.model.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    Iterable<City> findAll();

    List<City> findByName(String name);

    Optional<City> findById(Long id);

    void save(City city);

    void edit(City city);

    void delete(City city);
}
