define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/subject/subjectEditTemplate.html'
], function($, _, Backbone, subjectEditTemplate){

  var SubjectEditView = Backbone.View.extend({
    render: function(){
      var compiledTemplate = _.template( subjectEditTemplate, {} );
      $("#content").html(compiledTemplate);
    }

  });

  return SubjectEditView;
  
});
