define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/cohort/cohortListTemplate.html'
], function($, _, Backbone, cohortListTemplate){

  var CohortListView = Backbone.View.extend({
    el: $("#container"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( cohortListTemplate, data );
      $("#container").html(compiledTemplate);
    }

  });

  return CohortListView;
  
});
