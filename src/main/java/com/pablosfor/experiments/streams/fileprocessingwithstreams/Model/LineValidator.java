package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;


public class LineValidator implements Validator {
    private static final Logger LOGGER = Logger.getLogger(LineValidator.class.getName());

    @Override
    public Stream<Line> validate(Stream<Line> lines, BufferedWriter writer) {
        var validationContext = new ValidationContext();

        return lines.map(l -> { 
            LOGGER.log(Level.INFO, "validation of line {0}", l );

            var errors = l.validate(validationContext);

            if (errors != null && errors.size() > 0){
                errors.stream().forEach(e -> {
                    try {
                        writer.write(e.toString()+"\n");
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
            }

            return l;
        });
        
    }
    
}
