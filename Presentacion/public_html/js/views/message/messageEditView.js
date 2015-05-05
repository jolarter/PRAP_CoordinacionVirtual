define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/message/messageEditTemplate.html'
], function($, _, Backbone, messageEditTemplate){

  var MessageEditView = Backbone.View.extend({
    render: function(){
      console.log("Se modifica el content");
      var compiledTemplate = _.template( messageEditTemplate, {} );
      $("#content").html(compiledTemplate);
    }

  });

  return MessageEditView;
  
});
