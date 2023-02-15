package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
public class LineType1AR implements Line{
    @Getter
    Integer Id;

    @Getter
    String Name;

    @Getter
    Long Code;

    @Getter
    LocalDateTime CheckDate;

    @Override
    public List<ValidationError> validate(ValidationContext vCtx){
        vCtx.incrementElements(1);
        var errors = new ArrayList<ValidationError>();

        if (Id == null){
            vCtx.registerInvalid();
            errors.add(ValidationError.builder()
                .Code(Constants.VALIDATION_ERR_ID_INVALID)
                .Message("El id no puede ser nulo")
                .build());
        }

        if (Code > 1000){
            vCtx.registerInvalid();
            errors.add(ValidationError.builder()
                .Code(Constants.VALIDATION_ERR_CODE_INVALID)
                .Message("El campo code no puede ser mayor a mil")
                .build());
        }

        return errors;
    }
    
}
