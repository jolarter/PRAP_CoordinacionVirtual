define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/subject/subjectListTemplate.html'
], function($, _, Backbone, subjectListTemplate){

  var SubjectListView = Backbone.View.extend({
    el: $("#content"),

    render: function(){

      var that = this;
	  //..
      var data = {};
      var compiledTemplate = _.template( subjectListTemplate, data);
      $("#content").html(compiledTemplate);
    }

  });

  return SubjectListView;
  
});
