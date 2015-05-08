define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/module/moduleEditTemplate.html'
], function($, _, Backbone, moduleEditTemplate){

  var ModuleEditView = Backbone.View.extend({
    el: $("#content"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( moduleEditTemplate, data );
      $("#content").html(compiledTemplate);
    }

  });

  return ModuleEditView;
  
});
