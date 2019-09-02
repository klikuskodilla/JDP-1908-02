package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.entity.GenericEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "getAllGroups")
    public List<GenericEntity> getGroups() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GenericEntity getGroupWithId(Long groupId) {
        return new GenericEntity("test group name");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup")
    public void createGroup(GenericEntity groupDto) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GenericEntity updateGroup(GenericEntity groupDto) {
        return new GenericEntity("edited test group name");
    }

}
