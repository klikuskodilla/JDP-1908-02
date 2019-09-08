package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
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
    public void preparationOfSampleDataForTheDatabase() {
        group1 = new ProductGroupEntity();
        group1.setGroupName("test group name 1");
        group2 = new ProductGroupEntity();
        group2.setGroupName("test group name 2");
        product1 = new ProductEntity("test name 1", new BigDecimal("1.11"), "test description 1");
        product2 = new ProductEntity("test name 2", new BigDecimal("2.22"), "test description 2");
    }

    @Test
    public void testCreateGroup() {
        //Given
        product1.setProductGroupEntity(group1);
        product2.setProductGroupEntity(group1);
        group1.getProducts().add(product1);
        group1.getProducts().add(product2);
        //When
        Long groupId = groupRepository.save(group1).getId();
        //Then
        Optional<ProductGroupEntity> result = groupRepository.findById(groupId);
        assertTrue(result.isPresent());
        assertEquals("test group name 1", result.get().getGroupName());
        assertTrue(productRepository.findAll().stream().anyMatch(productEntity -> productEntity.getId().equals(product1.getId())));
        assertTrue(productRepository.findAll().stream().anyMatch(productEntity -> productEntity.getId().equals(product2.getId())));
        //CleanUp
        groupRepository.deleteById(groupId);
    }

    @Test
    public void testFindAll() {
        //Given
        product1.setProductGroupEntity(group1);
        product2.setProductGroupEntity(group1);
        group1.getProducts().add(product1);
        group1.getProducts().add(product2);
        Long group1Id = groupRepository.save(group1).getId();
        Long group2Id = groupRepository.save(group2).getId();
        //When
        List<ProductGroupEntity> result = groupRepository.findAll();
        //Then
        assertEquals(2, result.size());
        //CleanUp
        groupRepository.deleteById(group1Id);
        groupRepository.deleteById(group2Id);
    }

    @Test
    public void testFindById() {
        //Given
        product1.setProductGroupEntity(group1);
        product2.setProductGroupEntity(group1);
        group1.getProducts().add(product1);
        group1.getProducts().add(product2);
        Long group1Id = groupRepository.save(group1).getId();
        Long group2Id = groupRepository.save(group2).getId();
        //When
        Optional<ProductGroupEntity> result = groupRepository.findById(group2Id);
        //Then
        assertTrue(result.isPresent());
        assertEquals("test group name 2", result.get().getGroupName());
        //CleanUp
        groupRepository.deleteById(group1Id);
        groupRepository.deleteById(group2Id);
    }

    @Test
    public void testUpdateGroup() {
        //Given
        product1.setProductGroupEntity(group1);
        product2.setProductGroupEntity(group1);
        group1.getProducts().add(product1);
        group1.getProducts().add(product2);
        groupRepository.save(group1);
        groupRepository.save(group2);
        //When
        Optional<ProductGroupEntity> result = groupRepository.findById(group2.getId());
        result.get().setGroupName("update group name");
        ProductGroupEntity groupEntity = groupRepository.save(result.get());
        //Then
        assertEquals(group2.getId(), groupEntity.getId());
        assertEquals("update group name", result.get().getGroupName());
        //CleanUp
        groupRepository.deleteById(group1.getId());
        groupRepository.deleteById(group2.getId());

    }

    @Test
    public void testDeleteGroupAndProducts() {
        //Given
        product1.setProductGroupEntity(group1);
        product2.setProductGroupEntity(group1);
        group1.getProducts().add(product1);
        group1.getProducts().add(product2);
        groupRepository.save(group1);
        groupRepository.save(group2);
        //When
        groupRepository.deleteById(group1.getId());
        //Then
        assertEquals(1, groupRepository.findAll().size());
        assertFalse(productRepository.findAll().stream().anyMatch(p -> p.getId().equals(product1.getId())));
        assertFalse(productRepository.findAll().stream().anyMatch(p -> p.getId().equals(product2.getId())));
        //CleanUp
        groupRepository.deleteById(group2.getId());
    }
}
