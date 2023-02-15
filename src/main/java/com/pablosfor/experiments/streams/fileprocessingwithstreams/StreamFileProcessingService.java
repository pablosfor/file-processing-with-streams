package com.pablosfor.experiments.streams.fileprocessingwithstreams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.Line;
import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.ObjectUploadProcessor;
import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.Parser;
import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.StringStreamProvider;
import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.Validator;

@Service
public class StreamFileProcessingService {
    @Autowired
    private StringStreamProvider stringStreamProvider;

    @Autowired
    private Parser parser;

    @Autowired
    private Validator validator;

    @Autowired
    private ObjectUploadProcessor objectUploadProcessor;

    private static final Logger LOGGER = Logger.getLogger(StreamFileProcessingService.class.getName());

    void process() throws IOException{
        BufferedWriter errorResultStream = new BufferedWriter(new FileWriter("error.out"));

        Stream<String> strings = stringStreamProvider.getStreams();
        Stream<Line> lines = parser.parseStream(strings);
        lines = validator.validate(lines, errorResultStream);
        objectUploadProcessor.process(lines);

        // Next code is only for example. forEach method it's a stream terminator one, so it makes the stream to be processed. 
        // Running the related test you could see with logs how streams is process row by row, and you could see the generated error file.
        // In real use case we would:
        // - Upload the line serialized to OS.
        // - Change the error result stream to wrie 
        lines.forEach(l -> 
            LOGGER.log(Level.INFO, "processing line {0}", l )
        );
        errorResultStream.close();
        





//Source: https://stackoverflow.com/questions/5950557




    }
}
