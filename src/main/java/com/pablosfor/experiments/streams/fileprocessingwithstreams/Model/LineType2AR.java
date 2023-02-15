package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
public class LineType2AR implements Line{
    @Getter
    Integer Id;

    @Getter
    Integer RowCount;

    @Override
    public List<ValidationError> validate(ValidationContext vCtx){
        vCtx.registerInvalid();
        var errors = new ArrayList<ValidationError>();

        if (Id == null){
            vCtx.registerInvalid();
            errors.add(ValidationError.builder()
                .Code(Constants.VALIDATION_ERR_ID_INVALID)
                .Message("El id no puede ser nulo o mayor que 100")
                .build());
        }

        if (RowCount != vCtx.getTotalElements()){
            vCtx.registerInvalid();
            errors.add(ValidationError.builder()
                .Code(Constants.VALIDATION_ERR_FOOTER_COUNT_MISMATCH)
                .Message(MessageFormat.format("La cantidad de {0} elementos indicados por el footer no coincide con los {1} elementos procesados", RowCount, vCtx.getTotalElements()))
                .build());
        }

        return errors;
    }


}
