define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/message/messageListTemplate.html'
], function($, _, Backbone, messageListTemplate){

  var MessageListView = Backbone.View.extend({
    el: $("#container"),

    render: function(){

      var that = this;
	  //..
	  var data = {};
      var compiledTemplate = _.template( messagelistTemplate, data );
      $("#container").html(compiledTemplate);
    }

  });

  return MessageListView;
  
});
