define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/module/moduleListTemplate.html'
], function($, _, Backbone, moduleTemplate){

  var ModuleListView = Backbone.View.extend({
    el: $("#content"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( moduleTemplate, data );
      $("#content").html(compiledTemplate);
    }

  });

  return ModuleListView;
  
});
