package Electronics.Products.Information;


import Electronics.Products.Information.Entity.Product;
import Electronics.Products.Information.Repository.ProductRepo;
import Electronics.Products.Information.Service.ProductService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.lang.model.util.AbstractElementVisitor6;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTest {
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepo productRepo;
    @Mock
    Product product = new Product();
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void saveProductTest()
    {
        Product product=new Product(1L,"Television",50000L,"LG Company");
        Mockito.when(productRepo.save(product)).thenReturn(product);
        Product product1=productService.addProduct(product);
        assertEquals(product,product1);
    }
@Test
    public void getProductTest()
    {
        Mockito.when(productRepo.findAll()).thenReturn(Stream.of(new Product(2L,"Ac",45000L,"IFB")).collect(Collectors.toList()));
        assertEquals(1,productService.getAllProduct().size());
    }
 @Test
    public void getProductByIdTest()
    {
        Long id=1L;
        Product product1=new Product(1L,"Television",50000L,"LG Company");
        Mockito.when(productRepo.findById(id)).thenReturn(Optional.of(product));
        assertEquals(Optional.of(product), productService.getProductById(id));
    }

    @Test
    public void updateTest()
    {

    }
}
