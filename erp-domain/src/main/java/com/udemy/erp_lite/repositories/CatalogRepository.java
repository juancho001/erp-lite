package com.udemy.erp_lite.repositories;

import com.udemy.erp_lite.catalog.CatalogItem;
import com.udemy.erp_lite.catalog.CatalogType;

import javax.xml.catalog.Catalog;
import java.util.List;
import java.util.Optional;

/**
 * Port read-only for Catalog
 */
public interface CatalogRepository {

    Optional<Catalog> findByType(CatalogType type);

    List<CatalogItem> findItemsByType(CatalogType type);

    Optional<CatalogItem> findItemByTypeAndCode(CatalogType type, String code);
}