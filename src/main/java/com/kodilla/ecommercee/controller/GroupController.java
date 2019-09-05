package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductGroupDto;
import com.kodilla.ecommercee.entity.GenericEntity;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupMapper mapper;

    @Autowired
    private GroupDbService service;

    @RequestMapping(method = RequestMethod.GET, value = "getAllGroups")
    public List<ProductGroupDto> getGroups() {
        return mapper.mapToProductGroupDtoList(service.getAllGroups());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public ProductGroupDto getGroupWithId(@RequestParam Long groupId) throws ProductGroupNotFoundException {
        return mapper.mapToProductGroupDto(service.getProductGroupById(groupId).orElseThrow(ProductGroupNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody ProductGroupDto groupDto) {
        service.saveGroup(mapper.mapToProductGroupEntity(groupDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public ProductGroupDto updateGroup(@RequestBody ProductGroupDto groupDto) {
        return mapper.mapToProductGroupDto(service.saveGroup(mapper.mapToProductGroupEntity(groupDto)));
    }

}
