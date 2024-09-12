package com.ferchauapp.api.mapper;

import com.ferchauapp.api.dto.MunicipalityResponseDTO;
import com.ferchauapp.domain.Municipality;

public class MunicipalityResponseMapper {

    public static MunicipalityResponseDTO toResponseDTO(Municipality entity) {
        if (entity == null) {
            return null;
        }

        MunicipalityResponseDTO responseDTO = new MunicipalityResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setName(entity.getNombre());
        return responseDTO;
    }
}
