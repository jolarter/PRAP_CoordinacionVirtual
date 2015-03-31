define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/message/messageEditTemplate.html'
], function($, _, Backbone, messageEditTemplate){

  var MessageEditView = Backbone.View.extend({
    el: $("#container"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( messageEditTemplate, data );
      $("#container").html(compiledTemplate);
    }

  });

  return MessageEditView;
  
});
