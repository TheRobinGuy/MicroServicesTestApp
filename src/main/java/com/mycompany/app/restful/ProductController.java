package com.mycompany.app.restful;

import com.mycompany.app.aspect.RecordTiming;
import com.mycompany.app.common.ProductDto;
import com.mycompany.app.entities.Product;
import com.mycompany.app.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

  private ProductService productService;

  @Inject
  public ProductController(final ProductService productService) {
    this.productService = productService;
  }

  @RecordTiming
  @RequestMapping(value = "/product/all", method = RequestMethod.GET)
  public List<Product> getProducts() {
    return productService.getProducts();
  }

  @RecordTiming
  @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id) {
    productService.deleteProduct(id);
    return new ResponseEntity("Item deleted", HttpStatus.OK);
  }

  @RecordTiming
  @RequestMapping(value = "/products", method = RequestMethod.DELETE)
  public ResponseEntity<String> deleteProducts() {
    productService.deleteProducts();
    return new ResponseEntity("All items deleted", HttpStatus.OK);
  }

  @RecordTiming
  @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
  public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Integer id) {
    return new ResponseEntity(productService.getById(id), HttpStatus.OK);
  }

  @RecordTiming
  @RequestMapping(value = "/products", method = RequestMethod.POST)
  public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto) {
    return new ResponseEntity(productService.createProduct(dto), HttpStatus.CREATED);
  }

}
