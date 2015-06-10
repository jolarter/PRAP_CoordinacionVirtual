define([
    'jquery',
    'underscore',
    'backbone',
    'models/cohort/CohortModel',
    'collections/cohort/CohortCollection',
    'text!templates/cohort/cohortEditTemplate.html',
    'bootstrap',
    'libs/bootstrap/bootstrap-datetimepicker.min'
], function ($, _, Backbone,CohortModel,CohortCollection, cohortEditTemplate) {

    var CohortEditView = Backbone.View.extend({
        el: "#content",
        render: function () {
            var that = this;
            var data = {};
            var compiledTemplate = _.template(cohortEditTemplate, data);
            $("#content").html(compiledTemplate);
//            $('#datetimepicker6').datetimepicker();
//            $('#datetimepicker7').datetimepicker();
//            $("#datetimepicker6").on("dp.change", function (e) {
//            $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
//            });
//            $("#datetimepicker7").on("dp.change", function (e) {
//            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
//            });
            that.$el.html(compiledTemplate);
        },
        events: {
            'submit #cohortForm': 'safeCohort'
            
        },
        safeCohort: function (ev) {
     this.collection = new CohortCollection();
     var attr={
         name:$("#nameCohort").val(),
         startDate:$("#startDate").val(),
          endDate:$("#endDate").val(),
     };
     this.model=new CohortModel(attr);
          //  var cohortDetails = $(ev.currentTarget).serializeObject();
          //  this.model.notSynced= true;
            this.collection.create(attr,{
               success: function (model) {
         //         router.navigate("index.html#/ListCohort/",{trigger: true})         
          
                   console.log(model);
               
               }
            });
          




         //  console.log(cohortDetails);
 return false;
        }

    });
//    $.fn.serializeObject = function () {
//        var o = {};
//        var a = this.serializeArray();
//        $.each(a, function () {
//            if (o[this.name] !== undefinded) {
//                if (!o[this.name].push) {
//                    o[this.name] = [o[this.name]];
//                }
//                o[this.name].push(this.value || '');
//            } else {
//                o[this.name] = this.value || '';
//            }
//        });
//        return o;
//    };
    return CohortEditView;

});
