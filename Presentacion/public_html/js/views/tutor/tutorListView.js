define([
  'jquery',
  'underscore',
  'backbone',
  'collections/tutor/TutorCollection',
  'text!templates/tutor/tutorListTemplate.html'
], function($, _, Backbone, TutorCollection, tutorlistTemplate){

  var TutorListView = Backbone.View.extend({
    el:"#content",

    render: function(){
      var that = this;
      var tutor = new TutorCollection();
      tutor.fetch({
          success:function(ttr){
              var data = {tutors :ttr.models};
              var compiledTemplate = _.template( tutorlistTemplate, data);
              that.$el.html(compiledTemplate);
          }
      });  
    }
  });
  return TutorListView;
  
});
