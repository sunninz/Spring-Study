package com.example.SpringStudy.apiPayload.exception.handler;

import com.example.SpringStudy.apiPayload.code.BaseErrorCode;
import com.example.SpringStudy.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public  FoodCategoryHandler(BaseErrorCode errorCode){
        super(errorCode);
    }

}