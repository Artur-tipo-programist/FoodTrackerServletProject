package ua.external.servlets.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ua.external.servlets.dao.impl.ProductDao;
import ua.external.servlets.entity.Product;
import ua.external.servlets.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceTest {
    private final static Logger logger = LogManager.getLogger();
    ProductService productService;

    private static final Product product = new Product();
    private static final Long ID = new Long(1);

    @Before
    public void setUp() throws Exception {
        logger.info("Start test in productServiceTest");
        productService = Mockito.spy(ProductService.class);
    }

    @After
    public void tearDown() throws Exception {
        logger.info("End test in productServiceTest");
        productService = null;
    }

    @Test
    public void createProduct() throws ServiceException {
        assertFalse(productService.createProduct(product));
    }

    @Test
    public void findAllProductsForUser() throws ServiceException {
        Assert.assertNotNull(productService.findAllProductsForUser(ID));
    }

    @Test
    public void findProductById() throws ServiceException {
        assertNotNull(productService.findProductById(ID).get());
    }

    @Test
    public void updateProduct() throws ServiceException {
        assertTrue(productService.updateProduct(product));
    }

    @Test
    public void deleteProductById() throws ServiceException {
        assertFalse(productService.deleteProductById(ID));
    }

    @Test
    public void findAllProductsForUserByName() throws ServiceException {
        assertNotNull(productService.findAllProductsForUserByName(ID, "L"));
    }
}