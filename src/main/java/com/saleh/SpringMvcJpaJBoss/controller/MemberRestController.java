/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.saleh.SpringMvcJpaJBoss.controller;

import java.util.List;

import com.saleh.SpringMvcJpaJBoss.data.MemberDao;
import com.saleh.SpringMvcJpaJBoss.model.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/members")
public class MemberRestController {
    @Autowired
    private MemberDao memberDao;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Member lookupMemberById(@PathVariable("id") Long id) {
        return memberDao.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Member> listAllMembers() {
        return memberDao.findAllOrderedByName();
    }
    
    
   @RequestMapping(value = "/{id}.xml", method = RequestMethod.GET, produces = "application/xml")
   public @ResponseBody Member lookupMemberByIdAsXml(@PathVariable("id") Long id) {
       return memberDao.findById(id);
   }
}


/*
 * Spring 4.0 introduced @RestController, a specialized version of the controller which is a convenience annotation that does nothing more than add the @Controller and @ResponseBody annotations.
 * By annotating the controller class with @RestController annotation, you no longer need to add @ResponseBody to all the request mapping methods. The @ResponseBody annotation is active by default. 
 */

/*
 * The @ResponseBody annotation tells Spring MVC not to render a model into a view, but rather to write the returned object into the response body. 
 * It does this by using one of Spring’s message converters. Because Jackson 2 is in the classpath, this means that MappingJackson2HttpMessageConverter 
 * will handle the conversion of members to JSON if the request’s Accept header specifies that JSON should be returned.
*/
