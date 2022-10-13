package Electronics.Products.Information.Controller;

import Electronics.Products.Information.Entity.Product;
import Electronics.Products.Information.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    private Product saveProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }


    @GetMapping("/Product")
    private List<Product> getAllProduct()
    {
    return productService.getAllProduct();
    }

@GetMapping
private Optional<Product> getProductById(Long id) {
return productService.getProductById(id);
}
    @PutMapping("/PRODUCT")
    private Product update(@RequestBody Product product, Long id)
    {
        productService.update(product,id);
        return  product;
    }

    @DeleteMapping("/PRODUCT/{id}")
    private void deleteProduct(@PathVariable("id")Long id)
    {
        productService.delete(id);
    }

}