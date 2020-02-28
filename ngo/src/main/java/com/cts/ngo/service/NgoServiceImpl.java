package com.cts.ngo.service;/*
 *@author Myvin Barboza

 *
 * 12:26 PM 2/27/2020
 */

import com.cts.ngo.model.Ngo;
import com.cts.ngo.repository.NgoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;


@Service
public class NgoServiceImpl implements NgoService {

    @Autowired
    NgoRepository ngoRepository;

    public boolean saveNgo(Ngo ngo) {
        ngoRepository.save(ngo);
        return true;
    }

    @Override
    public Ngo findByNameAndPassword(String name, String password) {
        return ngoRepository.findByNameAndPassword(name, password);
    }

    @Override
    public boolean updateNgo(Ngo ngo, int id) {
        Ngo tempNgo = ngoRepository.findById(id).orElse(null);
        tempNgo.setLocation(ngo.getLocation() == "" ? tempNgo.getLocation() : ngo.getLocation());
        tempNgo.setName(ngo.getName() == "" ? tempNgo.getName() : ngo.getName());
        tempNgo.setPassword(ngo.getPassword()==""?tempNgo.getPassword():ngo.getPassword());
        ngoRepository.save(tempNgo);
        return true;
    }

    @Override
    public boolean deleteNgo(int id) {
        Ngo tempNgo=ngoRepository.findById(id).orElse(null);
        ngoRepository.delete(tempNgo);
        return true;
    }


}
