package com.example.SpringStudy.apiPayload.exception.handler;

import com.example.SpringStudy.apiPayload.code.BaseErrorCode;
import com.example.SpringStudy.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
