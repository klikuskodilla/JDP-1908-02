package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.entity.ProductGroupEntity;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupDbService {
    @Autowired
    private GroupRepository groupRepository;

    public List<ProductGroupEntity> getAllGroups() {
        return groupRepository.findAll();
    }

    public Optional<ProductGroupEntity> getProductGroupById(final Long groupId) {
        return groupRepository.findById(groupId);
    }

    public ProductGroupEntity saveGroup(final ProductGroupEntity groupEntity) {
        return groupRepository.save(groupEntity);
    }
}
