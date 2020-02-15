package com.ravar.sikka.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class convertToHash {
    private String inputString;
    public convertToHash(String input){
        this.inputString = input;
    }
    public String getHash(){
        String result = DigestUtils.sha256Hex(inputString);
        return result;
    }
}
