define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/tutor/tutorListTemplate.html'
], function($, _, Backbone, tutorlistTemplate){

  var TutorListView = Backbone.View.extend({
    el: $("#content"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( tutorlistTemplate, data );
      $("#content").html(compiledTemplate);
    }

  });

  return TutorListView;
  
});
