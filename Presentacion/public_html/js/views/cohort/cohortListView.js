define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/cohort/cohortListTemplate.html'
], function($, _, Backbone, cohortListTemplate){

  var CohortListView = Backbone.View.extend({
    el: $("#content"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( cohortListTemplate, data );
      $("#content").html(compiledTemplate);
    }

  });

  return CohortListView;
  
});
