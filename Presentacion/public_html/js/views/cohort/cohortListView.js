define([
    'jquery',
    'underscore',
    'backbone',
    'collections/cohort/CohortCollection',
    'text!templates/cohort/cohortListTemplate.html'
], function ($, _, Backbone, CohortCollection, cohortListTemplate)
{

    var CohortListView = Backbone.View.extend({
                el: "#content",
                render: function (){
                    var that = this;
                    var cohort2 = new CohortCollection();
                    cohort2.fetch({
                        success: function(cohorts){
                            var data = {cohorts: cohorts.models};
                            var compiledTemplate = _.template(cohortListTemplate, data);
                            that.$el.html(compiledTemplate);
                        }
                    });
                }
            });
    return CohortListView;

});

 
