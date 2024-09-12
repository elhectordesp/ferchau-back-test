package com.ferchauapp.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ferchauapp.api.dto.MunicipalityResponseDTO;
import com.ferchauapp.application.MunicipalityService;

@RestController
public class MunicipalityController {
  private final MunicipalityService municipalityService;

  public MunicipalityController(MunicipalityService municipalityService) {
    this.municipalityService = municipalityService;
  }

  @GetMapping("/municipalities")
  public List<MunicipalityResponseDTO> getMunicipalities(@RequestParam String name) {
    return municipalityService.getMunicipalitiesByName(name);
  }
  
}
