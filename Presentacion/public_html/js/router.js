// Filename: router.js
define([
  'jquery',
  'underscore',
  'backbone',
  'views/cohort/cohortEditView',
  'views/cohort/cohortListView',
  'views/message/messageEditView',
  'views/message/messageListView',
  'views/module/moduleEditView',
  'views/module/moduleListView',
  'views/subject/subjectEditView',
  'views/subject/subjectListView',
  'views/tutor/tutorEditView',
  'views/tutor/tutorListView'
], function($, _, Backbone, CohortListView, CohortEditView, MessageEditView, 
	MessageListView, ModuleEditView, ModuleListView, SubjectEditView, 
	SubjectListView, TutorEditView, TutorListView) 
        {
  
  var AppRouter = Backbone.Router.extend({
    routes: {
      // Define some URL routes
      'ListMessage/':				'showListMessage',
      'EditMessage/':				'showEditMessage',
      'ListMessage/:from/:to':     'showListMessage',
      'EditMessage/:id':			'showEditMessage',
	  'ListModule/':				'showListModule',
      'ListModule/:from/:to':		'showlistModule',
	  'EditModule/' :				'showEditModule',
      'EditModule/:id':			'showEditModule',
	  'ListTutor/':				'showListTutor',
      'ListTutor/:from/:to':		'showlistTutor',
	  'EditTutor/':				'showEditTutor',
      'EditTutor/:id':				'showEditTutor',
	  'ListCohort/':				'showListCohort',
      'ListCohort/:from/:to':		'showListCohort',
	  'EditCohort/':				'showEditCohort',
      'EditCohort/:id':			'showEditCohort',
	  'ListSubject/':				'showListSubject',
      'ListSubject/:from/:to':		'showListSubject',
	  'EditSubject/':				'showEditSubject',
      'EditSubject/:id':			'showEditSubject',

      // Default
      //'/*actions': 'defaultAction'
    }
  });
  
  var initialize = function(){

    var app_router = new AppRouter;
    
    app_router.on('route:showListMessage', function(from, to){
        f = from || 0;
        t = to || 20;
        var view = new MessageListView();
        view.render(f,t);

    });

    app_router.on('route:showEditMessage', function(id){
        id = id || 0;
        var view = new MessageEditView();
        view.render(id);
    });

    app_router.on('route:showListModule', function(from, to){
	f = from || 0;
	t = to || 20;
        var view = new ModuleListView();
        view.render(f,t);
    });

    app_router.on('route:showEditModule', function(id){
	id = id || 0;
        var view = new ModuleEditView();
        view.render(id);
    });


  
      app_router.on('route:showListTutor', function(from, to){
	f = from || 0;
	t = to || 20;
        var view = new TutorListView();
        view.render(f,t);
    });


    app_router.on('route:showEditTutor', function(id){
	id = id || 0;
        var view = new TutorEditView();
        view.render(id);
    });



    app_router.on('route:showListCohort', function(from, to){
	f = from || 0;
	t = to || 20;
        var view = new CohortListView();
        view.render(f,t);
    });

    app_router.on('route:showEditCohort', function(id){
        id = id || 0;
        var view = new CohortEditView();
        view.render(id);
    });

    app_router.on('route:showListSubject', function(from, id){
        f = from || 0;
	t = to || 20;
        var view = new SubjectListView();
        view.render(f,t);
    });

    app_router.on('route:showEditSubject', function(id){
        id = id || 0;
        var view = new SubjectEditView();
        view.render(id);
    });

    app_router.on('route:defaultAction', function (actions) {
       console.log('OMG');
       // We have no matching route, lets display the home page 
        //var homeView = new HomeView();
        //homeView.render();
    });

    // Unlike the above, we don't call render on this view as it will handle
    // the render call internally after it loads data. Further more we load it
    // outside of an on-route function to have it loaded no matter which page is
    // loaded initially.
    //var footerView = new FooterView();

    Backbone.history.start();
  };
  return { 
    initialize: initialize
  };
});
