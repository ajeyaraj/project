/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    List<ProductDetail> findProductDetailByDescription(String description);
    List<ProductDetail> findProductDetailByComment(String comment);

}
