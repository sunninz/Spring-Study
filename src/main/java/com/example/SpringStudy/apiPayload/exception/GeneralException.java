package com.example.SpringStudy.apiPayload.exception;

import com.example.SpringStudy.apiPayload.code.BaseErrorCode;
import com.example.SpringStudy.apiPayload.code.ErrorResonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorResonDTO getErrorReason(){
        return this.code.getReason();
    }

    public ErrorResonDTO getErrorReasonHttpStatus(){
        return this.code.getResponseHttpStatus();
    }
}
