package com.pablosfor.experiments.streams.fileprocessingwithstreams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.FixedWidthParser;
import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.LineValidator;
import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.Parser;
import com.pablosfor.experiments.streams.fileprocessingwithstreams.Model.Validator;

@SpringBootApplication
public class FileProcessingWithStreamsApplication {

	@Bean
	Parser getParser() {
		return new FixedWidthParser();
	}

	@Bean
	Validator getValidator() {
		return new LineValidator();
	}

	public static void main(String[] args) {
		SpringApplication.run(FileProcessingWithStreamsApplication.class, args);
	}

}
