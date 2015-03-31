define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/tutor/tutorEditTemplate.html'
], function($, _, Backbone, tutorEditTemplate){

  var TutorEditView = Backbone.View.extend({
    el: $("#container"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( tutorEditTemplate, data );
      $("#container").html(compiledTemplate);
    }

  });

  return TutorEditView;
  
});
