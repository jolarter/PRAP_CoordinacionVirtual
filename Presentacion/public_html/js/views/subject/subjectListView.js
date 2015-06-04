define([
  'jquery',
  'underscore',
  'backbone',
  'collections/subject/SubjectCollection',
  'collections/program/ProgramCollection',
  'text!templates/subject/subjectListTemplate.html'
], function($, _, Backbone, SubjectCollection, ProgramCollection, subjectListTemplate ){

  var SubjectListView = Backbone.View.extend({  
    el:"#content",
    
    render: function(){
      var that = this;
      var subject = new SubjectCollection();
      subject.fetch({  
          success:function(sbs){
              var data = {subjects :sbs.models};
              var compiledTemplate = _.template( subjectListTemplate, data);
              that.$el.html(compiledTemplate);
          },
          error: function(e){
              console.log(e);
          }
      });  
    },
  });

  return SubjectListView;
    
});