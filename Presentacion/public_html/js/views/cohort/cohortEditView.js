define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/cohort/cohortEditTemplate.html'
], function($, _, Backbone, cohortEditTemplate){

  var CohortEditView = Backbone.View.extend({
    el: $("#content"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( cohortEditTemplate, data );
      $("#content").html(compiledTemplate);
    }

  });

  return CohortEditView;
  
});
