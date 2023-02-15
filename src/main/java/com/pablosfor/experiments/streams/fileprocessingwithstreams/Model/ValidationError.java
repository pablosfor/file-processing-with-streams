package com.pablosfor.experiments.streams.fileprocessingwithstreams.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
public class ValidationError {
    @Getter
    public String Code;

    @Getter
    public String Message;
}
