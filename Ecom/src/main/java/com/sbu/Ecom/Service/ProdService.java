package com.sbu.Ecom.Service;

import com.sbu.Ecom.Model.Product;
import com.sbu.Ecom.Repository.prodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProdService {
    @Autowired
    private prodRepo repo;
    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProduct(int Id) {
        return repo.findById(Id).orElse(new Product(-1));
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return repo.save(product);
    }

    public void deleteProduct(int productId) {
        repo.deleteById(productId);
    }

    public List<Product> searchProduct(String keyword) {
        return repo.searchProduct(keyword);
    }
}
