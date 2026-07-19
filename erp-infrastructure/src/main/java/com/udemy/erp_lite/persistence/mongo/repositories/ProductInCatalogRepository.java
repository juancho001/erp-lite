package com.udemy.erp_lite.persistence.mongo.repositories;

import com.udemy.erp_lite.persistence.mongo.documents.ProductInCatalogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductInCatalogRepository extends MongoRepository<ProductInCatalogDocument, String> {
}
