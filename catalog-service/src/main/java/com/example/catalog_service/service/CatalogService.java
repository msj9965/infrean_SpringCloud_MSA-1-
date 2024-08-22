package com.example.catalog_service.service;

import com.example.catalog_service.jpa.CatalogEntity;
import com.example.catalog_service.vo.RequestCatalog;
import com.example.catalog_service.vo.ResponseCatalog;

public interface CatalogService {
    ResponseCatalog createCatalog(RequestCatalog requestCatalog);
    Iterable<CatalogEntity> getAllCatalogs();
}
