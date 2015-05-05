define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/message/messageListTemplate.html'
], function($, _, Backbone, messageListTemplate){

  var MessageListView = Backbone.View.extend({
    el: $("#content"),

    render: function(){

      var that = this;
	  //..
      var data = {};
      var compiledTemplate = _.template( messageListTemplate, data );
      $("#content").html(compiledTemplate);
    }

  });

  return MessageListView;
  
});
