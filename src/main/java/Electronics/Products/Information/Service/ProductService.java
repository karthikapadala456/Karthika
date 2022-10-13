package Electronics.Products.Information.Service;

import Electronics.Products.Information.Entity.Product;
import Electronics.Products.Information.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product addProduct(Product product) {
        System.out.println("Getting data from db :  +users ");
        return productRepo.save(product);
    }

    public List<Product> getAllProduct() {
        String product = new String();
        return (List<Product>) productRepo.findAll();
    }



    public Product update(Product product, Long id)
    {

        return productRepo.save(product);
    }
    public void delete(Long id)
    {
        productRepo.deleteById(id);
    }

    public Optional<Product> getProductById(Long id)
    {
     return productRepo.findById(id);
    }
}

