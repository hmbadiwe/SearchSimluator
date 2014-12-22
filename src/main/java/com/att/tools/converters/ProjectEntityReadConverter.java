package com.att.tools.converters;

import com.att.tools.domain.generated.affproject.Characterstics;
import com.att.tools.domain.generated.affproject.ProjectStore;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;


public class ProjectEntityReadConverter implements Converter<DBObject, ProjectStore>
{

    @Override
    public ProjectStore convert(DBObject dbObject)
    {
        ProjectStore returnedPE = new ProjectStore();


        returnedPE.setProjectID(dbObject.get("projectID").toString());
        returnedPE.setType(dbObject.get("type").toString());
        returnedPE.setName(dbObject.get("name").toString());
        returnedPE.setAction(dbObject.get("action").toString());
        returnedPE.setPriority(dbObject.get("priority").toString());
        returnedPE.setPlannedStartDate(dbObject.get("plannedStartDate").toString());
        returnedPE.setPlannedCompletionDate(dbObject.get("plannedCompletionDate").toString());
        returnedPE.setStartDate(dbObject.get("startDate").toString());
        returnedPE.setPlanID(dbObject.get("planID").toString());
        returnedPE.setStatus(dbObject.get("status").toString());
        BasicDBList charList = (BasicDBList) dbObject.get("characteristics");

        for (int i = 0; i< charList.size(); i++){
            Characterstics temChara = new Characterstics();
            BasicDBObject pulledBasicDBObject = new BasicDBObject();
            pulledBasicDBObject = (BasicDBObject)charList.get(i);
            temChara.setName(pulledBasicDBObject.getString("name"));
            temChara.setValue(pulledBasicDBObject.getString("value"));
            returnedPE.getCharacterstics().add(temChara);
        }
        return returnedPE;
    }
}

