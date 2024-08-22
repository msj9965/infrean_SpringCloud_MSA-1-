package com.example.catalog_service.controller;

import com.example.catalog_service.jpa.CatalogEntity;
import com.example.catalog_service.service.CatalogService;
import com.example.catalog_service.vo.RequestCatalog;
import com.example.catalog_service.vo.ResponseCatalog;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalog-service")
public class CatalogController {
    private final CatalogService catalogService;
    private final Environment env;

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's working in catalog Service on PORT %s",
                env.getProperty("local.server.port"));

    }
    @PostMapping("catalogs")
    public ResponseEntity<ResponseCatalog> createCatalog(@Valid @RequestBody RequestCatalog requestCatalog){
        ResponseCatalog responseCatalog = catalogService.createCatalog(requestCatalog);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseCatalog);

    }

    @GetMapping("catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs(){
        Iterable<CatalogEntity> catalogList = catalogService.getAllCatalogs();

        List<ResponseCatalog> result = new ArrayList<>();
        catalogList.forEach(v->{
            result.add(new ModelMapper().map(v, ResponseCatalog.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
