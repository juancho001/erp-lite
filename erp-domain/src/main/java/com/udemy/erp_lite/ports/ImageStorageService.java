package com.udemy.erp_lite.ports;


import com.udemy.erp_lite.product.ProductImage;

public interface ImageStorageService {

    ProductImage upload(String imageName, byte[] imageData);
    void delete(ProductImage img);
    byte[] download(ProductImage img);
}