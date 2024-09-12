package com.ferchauapp.application;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ferchauapp.api.dto.MunicipalityResponseDTO;
import com.ferchauapp.api.mapper.MunicipalityResponseMapper;
import com.ferchauapp.domain.Municipality;
import com.ferchauapp.infrastructure.AemetClient;
import com.ferchauapp.infrastructure.mapper.MunicipalityMapper;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {
  private final AemetClient aemetClient;

  public MunicipalityServiceImpl(AemetClient aemetClient) {
    this.aemetClient = aemetClient;
  }

  @Override
  public List<MunicipalityResponseDTO> getMunicipalitiesByName(String name) {
    Predicate<Municipality> byName = municipality -> municipality.getNombre().toLowerCase().contains(name.toLowerCase());
    
    List<Municipality> municipalities = aemetClient.getAllMunicipalities().stream()
        .map(MunicipalityMapper::toEntity) // Convertir DTO a entidad
        .filter(byName)
        .collect(Collectors.toList());

    return municipalities.stream()
        .map(MunicipalityResponseMapper::toResponseDTO) // Convertir entidad a ResponseDTO
        .collect(Collectors.toList());
  }

}
