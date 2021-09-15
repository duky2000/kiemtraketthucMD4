package com.codegym.kiemtramodule4.service.implement;

import com.codegym.kiemtramodule4.model.Water;
import com.codegym.kiemtramodule4.repository.IWaterRepository;
import com.codegym.kiemtramodule4.service.IWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterService implements IWaterService {
    @Autowired
    IWaterRepository iWaterRepository;
    @Override
    public Iterable<Water> findAll() {
        return iWaterRepository.findAll();
    }
}
