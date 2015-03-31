define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/module/moduleListTemplate.html'
], function($, _, Backbone, moduleListTemplate){

  var ModuleListView = Backbone.View.extend({
    el: $("#container"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( moduleTemplate, data );
      $("#container").html(compiledTemplate);
    }

  });

  return ModuleListView;
  
});
