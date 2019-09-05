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
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityTest {
    private ProductGroupEntity group1;
    private ProductGroupEntity group2;
    private ProductEntity product1;
    private ProductEntity product2;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProductRepository productRepository;


    @Before
    public void createSampleDataInTheDatabase() {
        ProductGroupEntity productGroupEntity1 = new ProductGroupEntity();
        productGroupEntity1.setGroupName("test group name 1");
        ProductGroupEntity productGroupEntity2 = new ProductGroupEntity();
        productGroupEntity2.setGroupName("test group name 2");
        ProductEntity productEntity1 = new ProductEntity("test name 1", new BigDecimal("1.11"), "test description 1");
        productEntity1.setProductGroupEntity(productGroupEntity1);
        ProductEntity productEntity2 = new ProductEntity("test name 2", new BigDecimal("2.22"), "test description 2");
        productEntity2.setProductGroupEntity(productGroupEntity1);
        productGroupEntity1.getProducts().add(productEntity1);
        productGroupEntity1.getProducts().add(productEntity2);
        group1 = groupRepository.save(productGroupEntity1);;
        group2 = groupRepository.save(productGroupEntity2);
        product1 = productEntity1;
        product2 = productEntity2;
    }

    @After
    public void cleanUpDatabase() {
        Optional.ofNullable(group1).ifPresent(g -> groupRepository.deleteById(group1.getId()));
        Optional.ofNullable(group2).ifPresent(g -> groupRepository.deleteById(group2.getId()));
    }

    @Test
    public void testCreateGroup() {
        //Given
        ProductGroupEntity productGroupEntity1 = new ProductGroupEntity();
        productGroupEntity1.setGroupName("test group name 3");
        ProductEntity productEntity1 = new ProductEntity("test name 3", new BigDecimal("3.33"), "test description 3");
        productEntity1.setProductGroupEntity(productGroupEntity1);
        ProductEntity productEntity2 = new ProductEntity("test name 4", new BigDecimal("4.44"), "test description 4");
        productEntity2.setProductGroupEntity(productGroupEntity1);
        productGroupEntity1.getProducts().add(productEntity1);
        productGroupEntity1.getProducts().add(productEntity2);
        //When
        Long groupId = groupRepository.save(productGroupEntity1).getId();
        //Then
        Optional<ProductGroupEntity> result = groupRepository.findById(groupId);
        assertTrue(result.isPresent());
        assertEquals("test group name 3", result.get().getGroupName());
        assertTrue(productRepository.findAll().stream().anyMatch(productEntity -> productEntity.getId().equals(productEntity1.getId())));
        assertTrue(productRepository.findAll().stream().anyMatch(productEntity -> productEntity.getId().equals(productEntity2.getId())));
        //CleanUp
        groupRepository.deleteById(groupId);
    }

    @Test
    public void testFindAll() {
        //Given
        //When
        List<ProductGroupEntity> result = groupRepository.findAll();
        //Then
        assertEquals(2, result.size());
    }

    @Test
    public void testFindById() {
        //Given
        //When
        Optional<ProductGroupEntity> result = groupRepository.findById(group2.getId());
        //Then
        assertTrue(result.isPresent());
        assertEquals("test group name 2", result.get().getGroupName());
    }

    @Test
    public void testUpdateGroup() {
        //Given
        //When
        Optional<ProductGroupEntity> result = groupRepository.findById(group2.getId());
        result.get().setGroupName("update group name");
        ProductGroupEntity groupEntity = groupRepository.save(result.get());
        //Then
        assertEquals(group2.getId(), groupEntity.getId());
        assertNotEquals(group2.getGroupName(), result.get().getGroupName());
    }

    @Test
    public void testDeleteAll() {
        //Given
        //When
        groupRepository.deleteById(group1.getId());
        //Then
        assertEquals(1, groupRepository.findAll().size());
        assertFalse(productRepository.findAll().stream().anyMatch(p -> p.getId().equals(product1.getId())));
        assertFalse(productRepository.findAll().stream().anyMatch(p -> p.getId().equals(product2.getId())));
        //CleanUp
        //Set null for method cleanUpDatabase()
        group1 = null;

    }
}
