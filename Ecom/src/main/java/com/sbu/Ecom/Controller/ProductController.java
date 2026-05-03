package com.sbu.Ecom.Controller;

import com.sbu.Ecom.Model.Product;
import com.sbu.Ecom.Service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProdService prodService;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(prodService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{Id}")
    public ResponseEntity<Product> getProductById(@PathVariable int Id){
        Product product = prodService.getProduct(Id);
        if(product.getProdId() > 0){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        Product product = prodService.getProduct(productId);
        if(product.getProdId() > 0){
            return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product savedProduct = null;
        try {
            savedProduct = prodService.addProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product/{Id}")
    public ResponseEntity<?> updateProduct(@PathVariable int productId, @RequestPart Product product, @RequestPart MultipartFile imageFile){
        Product updateProduct = null;
        try{
            updateProduct = prodService.addProduct(product,imageFile);
            return new ResponseEntity<>(updateProduct, HttpStatus.OK);
        }catch(IOException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    //Returns Message
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId){
        Product product = prodService.getProduct(productId);
        if(product != null){
            prodService.deleteProduct(productId);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(String keyword){
        List<Product> product = prodService.searchProduct(keyword);
        if(product!=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
