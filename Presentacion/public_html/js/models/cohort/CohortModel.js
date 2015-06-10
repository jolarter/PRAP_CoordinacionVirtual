define([
  'underscore',
  'backbone'
], function(_, Backbone) {

  var CohortModel = Backbone.Model.extend({
        urlRoot: "http://localhost:8080/Logica/webresources/edu.poli.prap.cv.data.cohort/",
        idAttribute: 'idCohort',
        defaults: {
          name: "",
          startDate: "",
          endDate: ""
        },
        toViewJson: function () {
            var result = this.toJSON(); // displayName property is used to render item in the list
            result.displayName = this.get('name');
           return result;
        },
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
            
            if (method == 'create') {
                options.url = 'http://localhost:8080/Logica/webresources/edu.poli.prap.cv.data.cohort/';
            }
            var result = Backbone.sync(method, model, _.extend(options, errorHandler));
            return result;
        }
        
        
    });

    return CohortModel;

});
