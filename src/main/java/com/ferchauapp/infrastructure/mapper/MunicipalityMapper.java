package com.ferchauapp.infrastructure.mapper;

import com.ferchauapp.domain.Municipality;
import com.ferchauapp.infrastructure.dto.MunicipalityDTO;

public class MunicipalityMapper {

    public static Municipality toEntity(MunicipalityDTO dto) {
        if (dto == null) {
            return null;
        }

        Municipality entity = new Municipality();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
