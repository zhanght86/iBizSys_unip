var OA_YCSQEditViewControllerBase = EditViewControllerBase.extend({
        construct: function(config) {
    if(!config)config={};
    if(!config.appctx)config.appctx='';
    if(!config.containerid)config.containerid='';
    arguments.callee.$.construct.call(this,this.getDefaultCfg(config));
    this.regCodeLists(config);
    this.regUICounters(config);
    this.regUIActions(config);
    this.regUpdatePanels(config);
    this.regControllers(config);
}
,regCodeLists:function(config)
{
}
,regUICounters:function(config)
{
}
,regUpdatePanels:function(config)
{
     var me=this;
}
,regControllers:function(config)
{
  var cid=config.containerid;
    if(cid!='')cid=cid+'_';
}
,regUIActions:function(config)
{
  var uiaction_0 = {"type":"DEUIACTION","tag":"Save"
};
    this.regUIAction(uiaction_0);
  var uiaction_1 = {"type":"DEUIACTION","tag":"SaveAndNew"
};
    this.regUIAction(uiaction_1);
  var uiaction_2 = {"type":"DEUIACTION","tag":"SaveAndExit"
};
    this.regUIAction(uiaction_2);
  var uiaction_3 = {"type":"DEUIACTION","tag":"RemoveAndExit","actiontarget":"SINGLEKEY"
};
    this.regUIAction(uiaction_3);
  var uiaction_4 = {"type":"DEUIACTION","tag":"SaveAndStart"
};
    this.regUIAction(uiaction_4);
  var uiaction_5 = {"type":"DEUIACTION","tag":"ViewWFStep","actiontarget":"SINGLEKEY"
};
    this.regUIAction(uiaction_5);
  var uiaction_6 = {"type":"DEUIACTION","tag":"New"
};
    this.regUIAction(uiaction_6);
  var uiaction_7 = {"type":"DEUIACTION","tag":"Copy","actiontarget":"SINGLEKEY"
};
    this.regUIAction(uiaction_7);
  var uiaction_8 = {"type":"DEUIACTION","tag":"Print","actiontarget":"SINGLEKEY"
};
    this.regUIAction(uiaction_8);
  var uiaction_9 = {"type":"DEUIACTION","tag":"FirstRecord","actiontarget":"SINGLEKEY"
};
    this.regUIAction(uiaction_9);
  var uiaction_10 = {"type":"DEUIACTION","tag":"PrevRecord","actiontarget":"SINGLEKEY"
};
    this.regUIAction(uiaction_10);
  var uiaction_11 = {"type":"DEUIACTION","tag":"NextRecord","actiontarget":"SINGLEKEY"
};
    this.regUIAction(uiaction_11);
  var uiaction_12 = {"type":"DEUIACTION","tag":"LastRecord","actiontarget":"SINGLEKEY"
};
    this.regUIAction(uiaction_12);
  var uiaction_13 = {"type":"DEUIACTION","tag":"Help"
};
    this.regUIAction(uiaction_13);
}
,getDefaultCfg:function(cfg){
    var me=this;     
    var config={backendurl:cfg.appctx+'/ywsp/OA_YCSQEditView.do?'+'srfcid='+cfg.containerid+'&'
                ,viewurl:'/ywsp/oa_ycsqeditview.jsp?'+'srfcid='+cfg.containerid+'&'
               ,ctrls:{form:{}}};
    return  $.extend({},config,cfg);
}  
,onInit:function(){
   arguments.callee.$.onInit.call(this);
   var form=this.getForm();
form.register(new IBizHiddenField({id:this.getCId2()+'M1e',name:'srfupdatedate'}));
form.register(new IBizHiddenField({id:this.getCId2()+'M1d',name:'srforikey'}));
form.register(new IBizHiddenField({id:this.getCId2()+'M1c',name:'srfkey'}));
form.register(new IBizHiddenField({id:this.getCId2()+'M1b',name:'srfmajortext'}));
form.register(new IBizHiddenField({id:this.getCId2()+'M1a',name:'srftempmode'}));
form.register(new IBizHiddenField({id:this.getCId2()+'M19',name:'srfuf'}));
form.register(new IBizHiddenField({id:this.getCId2()+'M18',name:'srfdeid'}));
form.register(new IBizHiddenField({id:this.getCId2()+'M17',name:'srfsourcekey'}));
form.register(new IBizHiddenField({id:this.getCId2()+'M5',name:'orguserid'}));
form.register(new IBizHiddenField({id:this.getCId2()+'M6',name:'orgusername'}));
form.register(new IBizHiddenField({id:this.getCId2()+'M16',name:'oa_ycsqid'}));
form.register(new IBizFormGroup({id:this.getCId2()+'M4',name:'group1',titleBarCloseMode:'0',form:form}));
form.register(new IBizHiddenField({id:this.getCId2()+'M5',name:'orguserid',form:form}));
form.register(new IBizHiddenField({id:this.getCId2()+'M6',name:'orgusername',form:form}));
form.register(new IBizTextField({id:this.getCId2()+'M7',name:'djr',allowBlank:false,form:form}));
form.register(new IBizTextField({id:this.getCId2()+'M8',name:'lkdw',allowBlank:false,form:form}));
form.register(new IBizTextField({id:this.getCId2()+'M9',name:'ycdd',allowBlank:false,form:form}));
form.register(new IBizDateField({id:this.getCId2()+'Ma',name:'ycsj',fmt:'YYYY-MM-DD HH:mm:ss',allowBlank:false,form:form,width:160}));
form.register(new IBizDateField({id:this.getCId2()+'Mb',name:'djsj',fmt:'YYYY-MM-DD HH:mm:ss',allowBlank:false,form:form,width:160}));
form.register(new IBizDateField({id:this.getCId2()+'Mc',name:'sqsj',fmt:'YYYY-MM-DD HH:mm:ss',allowBlank:false,form:form,width:160}));
form.register(new IBizDateField({id:this.getCId2()+'Md',name:'cfsj',fmt:'YYYY-MM-DD HH:mm:ss',allowBlank:false,form:form,width:160}));
form.register(new IBizDateField({id:this.getCId2()+'Me',name:'fhsj',fmt:'YYYY-MM-DD HH:mm:ss',allowBlank:false,form:form,width:160}));
form.register(new IBizTextAreaField({id:this.getCId2()+'Mf',name:'bz',form:form}));
form.register(new IBizFormGroup({id:this.getCId2()+'M11',name:'group2',titleBarCloseMode:'0',form:form}));
form.register(new IBizSpanField({id:this.getCId2()+'M12',name:'createman',form:form}));
form.register(new IBizSpanField({id:this.getCId2()+'M13',name:'createdate',form:form}));
form.register(new IBizSpanField({id:this.getCId2()+'M14',name:'updateman',form:form}));
form.register(new IBizSpanField({id:this.getCId2()+'M15',name:'updatedate',form:form}));

}
,onFormFieldChanged: function (fieldname, field, value) {
   var me=this;
   var form=me.getForm();
}
});