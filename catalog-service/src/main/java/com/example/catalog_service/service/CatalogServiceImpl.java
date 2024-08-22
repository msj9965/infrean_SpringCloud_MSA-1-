package com.example.catalog_service.service;

import com.example.catalog_service.jpa.CatalogEntity;
import com.example.catalog_service.jpa.CatalogRepository;
import com.example.catalog_service.vo.RequestCatalog;
import com.example.catalog_service.vo.ResponseCatalog;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
@Slf4j
public class CatalogServiceImpl implements CatalogService{

    private final CatalogRepository catalogRepository;

    @Override
    public ResponseCatalog createCatalog(RequestCatalog requestCatalog) {
        ModelMapper modelMapper = new ModelMapper();
        CatalogEntity catalogEntity = modelMapper.map(requestCatalog, CatalogEntity.class);
        catalogRepository.save(catalogEntity);
        ResponseCatalog responseCatalog = modelMapper.map(catalogEntity, ResponseCatalog.class);

        return responseCatalog;

    }

    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
