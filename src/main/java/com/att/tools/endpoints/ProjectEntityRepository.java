package com.att.tools.endpoints;

import com.att.tools.domain.generated.affproject.ProjectStore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;


@Component
public class ProjectEntityRepository
{


    public List<ProjectStore> findProjectsByProjectId(String projectID){

        Assert.notNull(projectID);

        ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
        MongoOperations mongoOperations = (MongoOperations)ctx.getBean("mongoTemplate");


        Query searchIdQuery = new Query(Criteria.where("projectID").regex(projectID));
        System.out.println("Query looks like: " + searchIdQuery.toString());
        List<ProjectStore> result = mongoOperations.find(searchIdQuery, ProjectStore.class);
        return result;
    }


}
