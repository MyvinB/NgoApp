package com.cts.ngo.service;/*
 *@author Myvin Barboza

 *
 * 1:59 PM 2/27/2020
 */

import com.cts.ngo.model.Ngo;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(Ngo ngo);
}
