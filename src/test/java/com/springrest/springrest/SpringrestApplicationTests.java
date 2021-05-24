package com.springrest.springrest;

import com.springrest.springrest.ProductServiceController;
import com.springrest.springrest.dao.ProductsDao;
import com.springrest.springrest.entities.Product;
import com.springrest.springrest.services.ProductService;
import com.springrest.springrest.services.ProductServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@WebMvcTest(value = Product.class)
//@SpringBootTest
public class SpringrestApplicationTests {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
       private ProductService productService;
       // @InjectMocks
       // private ProductServiceImpl productService;
        @Before("")
        public void setUp() throws Exception{
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void testGetProduct() throws Exception {
            Product honey = new Product();
            honey.setId("1");
            honey.setName("Honey");

            Mockito.when(productService.getProduct(Mockito.anyString())).thenReturn(honey);
            Product p = productService.getProduct("1");
            assertEquals("Honey", p.getName());

        }

        @Test
        void testCreateProduct() throws Exception{
            Product Oats = new Product();
            Oats.setId("2");
            Oats.setName("Oats");
            String exampleProductJson = "{\n" +
                    "        \"id\": \"2\",\n" +
                    "        \"name\": \"Oats\"\n" +
                    "    }";

            Mockito.when(productService.addProduct(Mockito.any(Product.class))).thenReturn(Arrays.asList(Oats));
            List<Product> pList = productService.addProduct(Oats);
            assertEquals("Oats", pList.get(0).getName());
        }

/*	@Test
	void testDeleteProduct() {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productService.addProduct(honey);

		Assert.assertEquals("Honey", productsDao.getOne("1"));

	}
	@Test
	void testUpdateProduct() {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productService.addProduct(honey);

		Assert.assertEquals("Honey", productsDao.getOne("1"));

	}*/

    }

