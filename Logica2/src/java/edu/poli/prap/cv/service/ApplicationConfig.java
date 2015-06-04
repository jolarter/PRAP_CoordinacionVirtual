/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poli.prap.cv.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author usuario
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(edu.poli.prap.cv.service.CohortFacadeREST.class);
        resources.add(edu.poli.prap.cv.service.CrossOriginResourceSharingFilter.class);
        resources.add(edu.poli.prap.cv.service.DictionaryFacadeREST.class);
        resources.add(edu.poli.prap.cv.service.FacultyFacadeREST.class);
        resources.add(edu.poli.prap.cv.service.MessageFacadeREST.class);
        resources.add(edu.poli.prap.cv.service.MessageModuleFacadeREST.class);
        resources.add(edu.poli.prap.cv.service.ModuleFacadeREST.class);
        resources.add(edu.poli.prap.cv.service.ProgramFacadeREST.class);
        resources.add(edu.poli.prap.cv.service.SubjectFacadeREST.class);
        resources.add(edu.poli.prap.cv.service.TutorFacadeREST.class);
    }
    
}
