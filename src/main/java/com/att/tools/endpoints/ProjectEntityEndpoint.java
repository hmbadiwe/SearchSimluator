package com.att.tools.endpoints;


import com.att.tools.domain.generated.affproject.GetAffProjectRequest;
import com.att.tools.domain.generated.affproject.GetAffProjectResponse;

import com.att.tools.domain.generated.affproject.ProjectStore;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class ProjectEntityEndpoint
{
    private ProjectEntityRepository projectEntityRepository = new ProjectEntityRepository();

    private static final String NAMESPACE_URI ="http://affProject.generated.domain.tools.att.com";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAffProjectRequest")
    @ResponsePayload
    public GetAffProjectResponse getProject(@RequestPayload GetAffProjectRequest request){
        GetAffProjectResponse response = new GetAffProjectResponse();
        List<ProjectStore> projectStoreList = projectEntityRepository.findProjectsByProjectId(request.getProjectID());
        for (ProjectStore item : projectStoreList){
            response.getProjectEntry().add(item);
        }
        return response;
    }

}
