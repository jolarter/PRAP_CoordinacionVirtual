define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/tutor/tutorEditTemplate.html'
], function($, _, Backbone, tutorEditTemplate){

  var TutorEditView = Backbone.View.extend({
    el: $("#content"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( tutorEditTemplate, data );
      $("#content").html(compiledTemplate);
    }

  });

  return TutorEditView;
  
});
