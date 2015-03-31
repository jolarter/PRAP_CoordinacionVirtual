define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/tutor/tutorListTemplate.html'
], function($, _, Backbone, tutorListTemplate){

  var TutorListView = Backbone.View.extend({
    el: $("#container"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( tutorlistTemplate, data );
      $("#container").html(compiledTemplate);
    }

  });

  return TutorListView;
  
});
