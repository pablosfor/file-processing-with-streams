package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import lombok.Builder;
import lombok.Getter;

public class ValidationContext {
    @Getter
    private int totalElements;

    @Getter
    private boolean valid = true;

    // Should be made thread safe
    public void incrementElements(int quantity){
        totalElements += quantity;
    }    

    public void registerInvalid(){
        valid = false;
    }    
}
