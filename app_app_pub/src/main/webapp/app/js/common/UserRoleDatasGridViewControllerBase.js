var UserRoleDatasGridViewControllerBase = GridViewControllerBase.extend({
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
  var uiaction_0 = {"type":"DEUIACTION","tag":"New"
};
    this.regUIAction(uiaction_0);
  var uiaction_1 = {"type":"DEUIACTION","tag":"Edit","actiontarget":"SINGLEKEY"
};
    this.regUIAction(uiaction_1);
  var uiaction_2 = {"type":"DEUIACTION","tag":"View","actiontarget":"SINGLEKEY"
};
    this.regUIAction(uiaction_2);
  var uiaction_3 = {"type":"DEUIACTION","tag":"Copy","actiontarget":"SINGLEKEY"
};
    this.regUIAction(uiaction_3);
  var uiaction_4 = {"type":"DEUIACTION","tag":"ToggleRowEdit"
};
    this.regUIAction(uiaction_4);
  var uiaction_5 = {"type":"DEUIACTION","tag":"NewRow"
};
    this.regUIAction(uiaction_5);
  var uiaction_6 = {"type":"DEUIACTION","tag":"Remove","actiontarget":"MULTIKEY"
};
    this.regUIAction(uiaction_6);
  var uiaction_7 = {"type":"DEUIACTION","tag":"ExportExcel"
};
    this.regUIAction(uiaction_7);
  var uiaction_8 = {"type":"DEUIACTION","tag":"Print","actiontarget":"MULTIKEY"
};
    this.regUIAction(uiaction_8);
  var uiaction_9 = {"type":"DEUIACTION","tag":"ExportModel"
};
    this.regUIAction(uiaction_9);
  var uiaction_10 = {"type":"DEUIACTION","tag":"Import"
};
    this.regUIAction(uiaction_10);
  var uiaction_11 = {"type":"DEUIACTION","tag":"ToggleFilter"
};
    this.regUIAction(uiaction_11);
  var uiaction_12 = {"type":"DEUIACTION","tag":"Help"
};
    this.regUIAction(uiaction_12);
}
,onInit:function(){
   arguments.callee.$.onInit.call(this);
   var form=this.getSearchForm();
form.register(new IBizTextField({id:this.getCId2()+'M4',name:'n_userroledatasname_like',form:form,width:100})
);
 
}
,onSearchFormFieldChanged: function (fieldname, field, value) {
   var me=this;
   var form=me.getSearchForm();
}
,getNewDataView:function(arg){
       if(!arg)arg={};
       var newmode=arg.srfnewmode;
       if(!newmode)newmode='';
      if(true){
	var view={
			title: '用户角色数据能力实体编辑视图',
			openMode:'POPUPMODAL',
			 height: 400,
	    	    width: 800,
    	    layout: 'fit',
            maximizable:true,
            viewurl:'/common/userroledataseditview.jsp',
            viewparam:arg
      	};
	return view;
       }
       return null;
    }

,getEditDataView:function(arg){
       if(!arg)arg={};
       var list = [arg.srfeditmode2,arg.srfeditmode];
       for(var i=0;i<2;i++){
          var editmode=list[i];
          if(!editmode)
             continue;
      }
      if(true){
	   return {  title: '用户角色数据能力实体编辑视图', openMode:'POPUPMODAL', height: 400, width: 800,
    	              layout: 'fit',   maximizable:true,   viewurl:'/common/userroledataseditview.jsp',   viewparam:arg  	};
       }
       return null;
    }
   ,isEnableBatchAdd:function(){return true;}
   ,getMPickupView: function (arg)
    {
        if(!arg)arg={};
        var me=this;
        var parentMode=me.getParentMode();
        var tempMode=me.getMDCtrl().tempMode;
        if(!tempMode)
             tempMode=false;
        if ( parentMode.srfder1nid=='DER1N_USERROLEDATAS_USERROLE_USERROLEID'){
arg.srftempmode=false;
            var view={
                modal:true,
    	        title: '数据对象能力实体数据多项选择视图',
    	        height: 0,
    	        width: 0,
    	        layout: 'fit',
                 viewurl:'/common/userroledatampickupview.jsp',
                viewparam:arg
    	     };
	    return view;
        }       

        if (parentMode.srfder1nid=='DER1N_USERROLEDATAS_USERROLEDATA_USERROLEDATAID'){
arg.srftempmode=false;
            var view={
                modal:true,
    	        title: '用户角色实体数据多项选择视图',
    	        height: 0,
    	        width: 0,
    	        layout: 'fit',
                viewurl:'/common/userrolempickupview.jsp',
                viewparam:arg
    	     };
	    return view;
        }
        return null;
     }

,getDefaultCfg:function(cfg){
     var me=this;   
    var config={backendurl:cfg.appctx+'/common/UserRoleDatasGridView.do?'+'srfcid='+cfg.containerid+'&',loaddefault:true
                ,viewurl:'/common/userroledatasgridview.jsp?'+'srfcid='+cfg.containerid+'&'
               ,ctrls:{grid:{multiSelect:true
,enablePaging:true,pageSize:20,forceFit:false
,columns:[
{ "title" : '用户角色',"width":150,"data" :'userrolename',"orderable":true}

,{ "title" : '实体数据能力',"width":150,"data" :'userroledataname',"orderable":true}

,{ "title" : '更新人',"width":150,"data" :'updateman',"orderable":true}

,{ "title" : '更新时间',"width":150,"data" :'updatedate',"orderable":true}
]
},searchForm:{enableAdvanceSearch:false,dename:'USERROLEDATAS'}}};
    return  $.extend({},config,cfg);
}
,doHideParentColumns: function (parentMode)
    {
        var me=this;
        arguments.callee.$.doHideParentColumns.call(this,parentMode);
 
         //关系类型 : DER1N ,主实体 :USERROLE / 用户角色
         if (parentMode.srfparenttype=='DER1N' && parentMode.srfder1nid=='DER1N_USERROLEDATAS_USERROLE_USERROLEID')
         {
              me.hideGridColumn('userrolename');
              return;
         }
         //关系类型 : DER1N ,主实体 :USERROLEDATA / 数据对象能力
         if (parentMode.srfparenttype=='DER1N' && parentMode.srfder1nid=='DER1N_USERROLEDATAS_USERROLEDATA_USERROLEDATAID')
         {
              me.hideGridColumn('userroledataname');
              return;
         }
}
});