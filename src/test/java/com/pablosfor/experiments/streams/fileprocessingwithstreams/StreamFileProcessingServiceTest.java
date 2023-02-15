package com.pablosfor.experiments.streams.fileprocessingwithstreams;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.Line;
import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.ObjectUploadProcessor;
import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.Parser;
import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.StringStreamProvider;
import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.Validator;

@SpringBootTest
public class StreamFileProcessingServiceTest {
	@Autowired
	StreamFileProcessingService processor;

	@MockBean
    private StringStreamProvider stringStreamProvider;

    @MockBean
    private ObjectUploadProcessor objectUploadProcessor;

	
    @Test
	void processWithStream() throws IOException {
        String texto = 
            "00000001Firt person                             000001472023-02-15T06:08\n" +
            "00000001The second                              000002292022-11-13T21:17\n" +
            "00000001Third with special chars ñ´!            000042782021-05-11T14:23\n" +
            "00000001Ohter person                            000000782021-05-11T14:23\n" +
            "0000000200000003";
        var streamLines = new java.io.BufferedReader(new StringReader(texto)).lines();

		when(stringStreamProvider.getStreams()).thenReturn(streamLines);
		
		processor.process();
	}
}
