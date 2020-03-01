package com.cts.ngo.service;/*
 *@author Myvin Barboza

 *
 * 12:26 PM 2/27/2020
 */

import com.cts.ngo.model.Ngo;
import com.cts.ngo.repository.NgoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
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
    public Ngo getNgo(String id) {
    return ngoRepository.findById(id);
    }


    @Override
    public boolean updateNgo(Ngo ngo, String id) {
        Ngo tempNgo = ngoRepository.findById(id);
        tempNgo.setLocation(ngo.getLocation().equals("") ? tempNgo.getLocation() : ngo.getLocation());
        tempNgo.setName(ngo.getName().equals("") ? tempNgo.getName() : ngo.getName());
        System.out.println(tempNgo.toString()+"temp");
        System.out.println(ngo.toString());
        ngoRepository.save(tempNgo);
        return true;
    }



    @Override
    public boolean deleteNgo(String id) {
        Ngo tempNgo=ngoRepository.findById(id);
        ngoRepository.delete(tempNgo);
        return true;
    }


}
