package com.sdarm.meetingregistration.controller;

import com.sdarm.meetingregistration.dto.apartment.ApartmentResponse;
import com.sdarm.meetingregistration.facade.ApartmentFacade;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/public/registration/apartments")
@OpenAPIDefinition(tags = {@Tag(name = "public"), @Tag(name = "registration"), @Tag(name = "apartments")})
@Slf4j
@RequiredArgsConstructor
public class PublicApartmentController {

    private final ApartmentFacade apartmentFacade;

    @GetMapping
    public List<ApartmentResponse> getAll(@RequestParam(value = "isAvailableOnly", required = false, defaultValue = "false") boolean isAvailableOnly) {
        log.info("Get all apartments");

        return apartmentFacade.getAll(isAvailableOnly);
    }
}
