package com.example.SpringStudy.converter;

import com.example.SpringStudy.web.dto.response.TempResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class TempConverter {
    public static TempResponseDTO.TempTestDTO toTempTestDTO(){
        return TempResponseDTO.TempTestDTO.builder()
                .testString("This is Test")
                .build();
    }

    public static TempResponseDTO.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponseDTO.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
