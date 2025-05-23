package com.example.SpringStudy.apiPayload.exception.handler;

import com.example.SpringStudy.apiPayload.code.BaseErrorCode;
import com.example.SpringStudy.apiPayload.exception.GeneralException;

public class MissionHandler extends  GeneralException{

    public MissionHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}