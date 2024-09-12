package com.ferchauapp.application;

import java.util.List;

import com.ferchauapp.api.dto.MunicipalityResponseDTO;

public interface MunicipalityService {
  List<MunicipalityResponseDTO> getMunicipalitiesByName(String name);
}
