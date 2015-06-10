define([
  'jquery',
  'underscore',
  'backbone',
  'collections/module/ModuleCollection',
  'text!templates/module/moduleListTemplate.html'
], function($, _, Backbone, ModuleCollection, moduleTemplate){

  var ModuleListView = Backbone.View.extend({
    el:"#content",

    render: function(){
      var that = this;
      var module = new ModuleCollection();
      module.fetch({
          success:function(md){
               var data = {modules: md.model};
               var compiledTemplate = _.template( moduleTemplate, data );
               that.$el.html(compiledTemplate);
          }
      }); 
    },

  });
  return ModuleListView;
});
