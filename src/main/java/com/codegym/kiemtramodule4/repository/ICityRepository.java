package com.codegym.kiemtramodule4.repository;

import com.codegym.kiemtramodule4.model.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICityRepository extends CrudRepository<City,Long> {
    List<City> findAllByNameContaining(String name);
}
