package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FixedWidthLineParserEngine {
    int currentPosition = 0;

    void skip(int length){
        currentPosition+=length;
    }

    String parseString(String src, int length){
        return extractSubstring(src, length).trim();
    }

    Integer parseInt(String src, int length){
        var result = extractSubstring(src, length);
        return Integer.valueOf(result);
    }

    Long parseLong(String src, int length){
        var result = extractSubstring(src, length);
        return Long.valueOf(result);
    }

    LocalDateTime parseDate(String src){
        var result = extractSubstring(src, 16); // Parse date uses 16 char iso format without timezone
        return LocalDateTime.parse(result,DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    private String extractSubstring(String src, int length) {
        var result = src.substring(currentPosition, currentPosition + length);
        currentPosition+=length;
        return result;
    }
}
