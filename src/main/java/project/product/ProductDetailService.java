package project.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService {
    private final ProductDetailRepository productDetailRepository;

    @Autowired
    public ProductDetailService(ProductDetailRepository productDetailRepository) {
        this.productDetailRepository = productDetailRepository;
    }

    //Product Details methods
    public List<ProductDetail> getAllProductDetails() {
        return productDetailRepository.findAll();
    }

    public ProductDetail getProductDetailById(Long id) {
        return productDetailRepository.findById(id)
                .orElseThrow(() -> new ProductDetailNotFoundException(id));
    }

    public List<ProductDetail> getProductDetailByDescription(String description) {
        return productDetailRepository.findProductDetailByDescription(description);
    }

    public List<ProductDetail> getProductDetailByComment(String comment) {
        return productDetailRepository.findProductDetailByComment(comment);
    }

    //Create product detail
    public ProductDetail addProductDetail(ProductDetail productDetail) {
        return productDetailRepository.save(productDetail);
    }

    //update product detail
    public ProductDetail updateProductDetail(Long id, ProductDetail productDetail) {
        ProductDetail oldProductDetail = productDetailRepository.findById(id)
                .orElseThrow(() -> new ProductDetailNotFoundException(id));

        oldProductDetail.setDescription(productDetail.getDescription());
        oldProductDetail.setComment(productDetail.getComment());
        return productDetailRepository.save(oldProductDetail);
    }

    //Delete product detail
    public void deleteProductDetailById(Long id) {
        productDetailRepository.deleteById(id);
    }
}
