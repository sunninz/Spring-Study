package com.example.SpringStudy.apiPayload.exception.handler;

import com.example.SpringStudy.apiPayload.code.BaseErrorCode;
import com.example.SpringStudy.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
