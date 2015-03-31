define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/subject/subjectEditTemplate.html'
], function($, _, Backbone, subjectEditTemplate){

  var SubjectEditView = Backbone.View.extend({
    el: $("#container"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( subjectEditTemplate, data );
      $("#container").html(compiledTemplate);
    }

  });

  return SubjectEditView;
  
});
