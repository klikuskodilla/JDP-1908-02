package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductEntityTest {
    private ProductGroupEntity group;
    private ProductEntity productEntity;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Before
    public void createSampleDataInTheDatabase() {
        ProductGroupEntity groupEntity = new ProductGroupEntity();
        groupEntity.setGroupName("test group name 1");
        groupRepository.save(groupEntity);
        ProductEntity product = new ProductEntity("test name 1", new BigDecimal("1.11"), "test description 1");
        product.setProductGroupEntity(groupEntity);
        groupEntity.getProducts().add(product);
        group = groupRepository.save(groupEntity);
        productEntity = group.getProducts().get(0);
        ProductEntity product2 = new ProductEntity("test name 2", new BigDecimal("2.22"), "test description 2");
        productRepository.save(product2);
    }

    @After
    public void cleanUpDatabase() {
        groupRepository.deleteById(group.getId());
    }

    @Test
    public void testCreateProductAndFind() {
        //Given
        ProductGroupEntity groupEntity = new ProductGroupEntity();
        groupEntity.setGroupName("test group name 1");
        Long groupId = groupRepository.save(groupEntity).getId();
        ProductEntity productEntity = new ProductEntity("test name 1", new BigDecimal("1.11"), "test description 1");
        productEntity.setProductGroupEntity(groupEntity);
        groupEntity.getProducts().add(productEntity);
        //When
        Long id = productRepository.save(productEntity).getId();
        Optional<ProductEntity> result = productRepository.findById(id);
        //Then
        assertTrue(result.isPresent());
        assertEquals("test name 1", result.get().getName());
        assertEquals(new BigDecimal("1.11"), result.get().getPrice());
        assertEquals("test description 1", result.get().getDescription());
        assertEquals(groupId, result.get().getProductGroupEntity().getId());
        //CleanUp
        groupRepository.deleteById(groupId);
    }

    @Test
    public void testDeleteProductWithoutGroup() {
        //Given
        //When
        group.getProducts().get(0).setProductGroupEntity(null);
        Long productId = productRepository.save(group.getProducts().get(0)).getId();
        group.setProducts(Collections.emptyList());
        productRepository.deleteById(productId);
        //Then
        assertTrue(groupRepository.findById(group.getId()).isPresent());
        assertFalse(productRepository.findById(productId).isPresent());
    }

    @Test
    public void testUpdateProduct() {
        //Given
        //When
        Optional<ProductEntity> result = productRepository.findById(productEntity.getId());
        ProductEntity entity = result.get();
        entity.setName("updated name");
        entity.setPrice(new BigDecimal("2.22"));
        entity.setDescription("updated description");
        entity.setProductGroupEntity(null);
        Long id = productRepository.save(entity).getId();
        //Then
        Optional<ProductEntity> updatedProduct = productRepository.findById(id);
        assertTrue(updatedProduct.isPresent());
        assertEquals(productEntity.getId(), updatedProduct.get().getId());
        assertNotEquals(productEntity.getName(), updatedProduct.get().getName());
        assertNotEquals(productEntity.getPrice(), updatedProduct.get().getPrice());
        assertNotEquals(productEntity.getProductGroupEntity(), updatedProduct.get().getProductGroupEntity());
    }

    @Test
    public void testFindAll() {
        //Given
        //When
        List<ProductEntity> products = productRepository.findAll();
        //Then
        assertEquals(2, products.size());
    }
}
