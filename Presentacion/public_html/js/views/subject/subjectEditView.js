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
        
        if(options){
            subjectModel = new SubjectModel({idSubject: options})
            subjectModel.fetch({
                success:function(subject){
                    faculty.fetch({  
                        success:function(fac){
                            that.listFacultys= fac.models;
                             var program = new ProgramCollection();
                            var data = { facultys:that.listFacultys, subjectModel: subject};
                            var compiledTemplate = _.template(subjectEditTemplate,data);
                            that.$el.html(compiledTemplate);
                            $("#programSubject > option").each(function(){
                                //alert(this.text + '' + this.value);
                                //if(this.value == subject.get('program').idProgram){
                                //    this.selected = true;
                                //}
                                this.value = subject.get('program').idProgram;
                                this.text = subject.get('program').name;
                                this.selected = true;
                            });
               
                        },
                        error: function(e){
                            console.log(e);
                        }
                }); 
                 
                }
            });
            
            
        }else{
            faculty.fetch({  
              success:function(fac){
                  that.listFacultys= fac.models;
                   var program = new ProgramCollection();
                  var data = { facultys:that.listFacultys, subjectModel: null};
                  var compiledTemplate = _.template(subjectEditTemplate,data);
                  that.$el.html(compiledTemplate);
                 
               
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
            program: {idProgram:$("#programSubject").val()}
        };
            this.model = new SubjectModel(attr);
            this.model.notSynced = true;
            this.collection.create(attr,{
                    success: function (model) {
                        location.href = "#/ListSubject/";
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
                        $('#programSubject').html('');
                        for(i=0; i< prog.length; i++){
                         if(prog.models[i].get('faculty').idFaculty == $(ev.currentTarget).val()){
                           $('#programSubject').append("<option value='"+prog.models[i].get('idProgram')+"'>"+prog.models[i].get('name')+"</option>");   
                          }   
                        }
                    }
                })
    }
  });

  return SubjectEditView;
  
});
