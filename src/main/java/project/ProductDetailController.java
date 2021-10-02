package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductDetailController {
    private final ProductDetailService productDetailService;

    @Autowired
    public ProductDetailController(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @GetMapping("/productDetails")
    public List<ProductDetail> getAllProductDetails() {
        return productDetailService.getAllProductDetails();
    }

    @GetMapping("/productDetails/id/{id}")
    public ProductDetail getProductDetailById(@PathVariable Long id){
        return productDetailService.getProductDetailById(id);
    }

    @GetMapping("/productDetails/description/{description}")
    public List<ProductDetail> getProductDetailByDescription(@PathVariable String description){
        return productDetailService.getProductDetailByDescription(description);
    }

    @GetMapping("/productDetails/comment/{comment}")
    public List<ProductDetail> getCustomerByAddress(@PathVariable String comment){
        return productDetailService.getProductDetailByComment(comment);
    }

    @PostMapping("/addProductDetail")
    public ProductDetail createProductDetail(@RequestBody ProductDetail productDetail) {
        return productDetailService.addProductDetail(productDetail);
    }

    @PutMapping("/productDetails/{id}")
    public ProductDetail updateProductDetail(@PathVariable(value = "id") Long id, @RequestBody ProductDetail productDetail) throws ProductDetailNotFoundException {
        return productDetailService.updateProductDetail(id, productDetail);
    }

    @DeleteMapping("/productDetails/{id}")
    public void deleteProductDetail(@PathVariable Long id) {
        productDetailService.deleteProductDetailById(id);
    }
}
