define([
  'jquery',
  'underscore',
  'backbone',
  'models/subject/SubjectModel',
  'collections/faculty/FacultyCollection',
  'collections/subject/SubjectCollection',
  'collections/program/ProgramCollection',
  'text!templates/subject/subjectEditTemplate.html'
], function($, _, Backbone, SubjectModel, FacultyCollection, SubjectCollection, ProgramCollection, subjectEditTemplate){

  var SubjectEditView = Backbone.View.extend({
    el:"#content",
    listFacultys: {},
    listPrograms: {},
    render: function(options){
        var that = this;
        var faculty = new FacultyCollection();
        
        if(options.id){
            
        }else{
            faculty.fetch({  
              success:function(fac){
                  that.listFacultys= fac.models;
                   var program = new ProgramCollection();
                  program.fetch({  
                    success:function(prog){
                        that.listPrograms= prog.models;
                        var data = {programs:that.listPrograms, facultys:that.listFacultys};
                        var compiledTemplate = _.template(subjectEditTemplate,data);
                        that.$el.html(compiledTemplate);
                    },
                    error: function(e){
                        console.log(e);
                    }
                });
              },
              error: function(e){
                  console.log(e);
              }
            }); 
        }
    },
    events:{
        'submit #subjectform': 'createSubject',
        'change #facultySubject': 'listProgram'
    },
    createSubject: function(ev){
        this.collection = new SubjectCollection();
        var attr = {
            name:$("#nameSubject").val(), 
            program: {idProgram:$("#programSubject").val()}};
        this.model = new SubjectModel(attr);
        this.model.notSynced = true;
        this.collection.create(attr,{
                    success: function (model) {
                        //router.navigate('#/EditSubject/'+model.id,{triger:true});  
                    }
                }
        );
        return false;
    },
    listProgram: function(ev){
        var program = new ProgramCollection();
                program.fetch({  
                    success:function(prog){
                        for(i=0; i< prog.length; i++){
                         if(prog.models[i].get('faculty').idFaculty == $(ev.currentTarget).val()){
                          
                                console.log(prog.models[i].get('name'))
                          }   
                        }
                    }
                })
    }
  });

  return SubjectEditView;
  
});
