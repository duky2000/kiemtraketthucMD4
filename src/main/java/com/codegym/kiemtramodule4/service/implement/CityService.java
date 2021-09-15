package com.codegym.kiemtramodule4.service.implement;

import com.codegym.kiemtramodule4.model.City;
import com.codegym.kiemtramodule4.repository.ICityRepository;
import com.codegym.kiemtramodule4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CityService implements ICityService {
    @Autowired
    ICityRepository iCityRepository;
    @Override
    public Iterable<City> findAll() {
        return iCityRepository.findAll();
    }

    @Override
    public List<City> findByName(String name) {
        return iCityRepository.findAllByNameContaining(name);
    }

    @Override
    public Optional<City> findById(Long id) {
        return iCityRepository.findById(id);
    }

    @Override
    public void save(City city) {
iCityRepository.save(city);
    }

    @Override
    public void edit(City city) {
iCityRepository.save(city);
    }

    @Override
    public void delete(City city) {
iCityRepository.delete(city);
    }
}
