define([
  'underscore',
  'backbone',
  'models/message/MessageModel'

  
], function(_, Backbone, MessageModel){

     
         
       var MessageCollection = Backbone.Collection.extend({
             model: MessageModel,

        url: "http://localhost:8080/Logica/webresources/edu.poli.prap.cv.data.message/",
        sync: function (method, model, options) {
            options || (options = {});
            var errorHandler = {
                error: function (jqXHR, textStatus, errorThrown) {
                    // TODO: put your error handling code here
                    // If you use the JS client from the different domain
                    // (f.e. locally) then Cross-origin resource sharing 
                    // headers has to be set on the REST server side.
                    // Otherwise the JS client has to be copied into the
                    // some (f.e. the same) Web project on the same domain
                    alert('Unable to fulfil the request');
                }}
            
            var result = Backbone.sync(method, model, _.extend(options, errorHandler));
            return result;
        }
    });

  return MessageCollection;

});