var UserRoleDataPickupGridViewControllerBase = PickupGridViewControllerBase.extend({
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
     /*数据对象能力部门数据范围*/
     this.regCodeList(new IBizCodeList({id: 'uniPSample_URDSecDR',datas:[{text:'当前部门',value:'1',realtext:'当前部门'},{text:'上级部门',value:'2',realtext:'上级部门'},{text:'下级部门',value:'4',realtext:'下级部门'}]}));
     /*是否*/
     this.regCodeList(new IBizCodeList({id: 'uniPSample_YesNo',datas:[{text:'是',value:'1',realtext:'是'},{text:'否',value:'0',realtext:'否'}]}));
     /*数据对象能力机构数据范围*/
     this.regCodeList(new IBizCodeList({id: 'uniPSample_URDOrgDR',datas:[{text:'当前机构',value:'1',realtext:'当前机构'},{text:'上级机构',value:'2',realtext:'上级机构'},{text:'下级机构',value:'4',realtext:'下级机构'}]}));
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
}
,onInit:function(){
   arguments.callee.$.onInit.call(this);
   var form=this.getSearchForm();
form.register(new IBizTextField({id:this.getCId2()+'M4',name:'n_userroledataname_like',form:form,width:100})
);

}
,onSearchFormFieldChanged: function (fieldname, field, value) {
   var me=this;
   var form=me.getSearchForm();
}
,getDefaultCfg:function(cfg){
     var me=this;   
    var config={backendurl:cfg.appctx+'/common/UserRoleDataPickupGridView.do?'+'srfcid='+cfg.containerid+'&',loaddefault:true
                ,viewurl:'/common/userroledatapickupgridview.jsp?'+'srfcid='+cfg.containerid+'&'
               ,ctrls:{grid:{multiSelect:true
,enablePaging:true,pageSize:20,forceFit:false
,columns:[
{ "title" : '数据对象',"width":150,"data" :'dename',"orderable":true}

,{ "title" : '能力名称',"width":150,"data" :'userroledataname',"orderable":true}

,{ "title" : '机构数据类型',"width":150,"data" :'orgdr',"orderable":true,'render':function(data,type,row){return me.rendergrid_orgdr(data,type,row,me);}}

,{ "title" : '部门数据类型',"width":150,"data" :'secdr',"orderable":true,'render':function(data,type,row){return me.rendergrid_secdr(data,type,row,me);}}

,{ "title" : '全部数据',"width":150,"data" :'isalldata',"orderable":true,'render':function(data,type,row){return me.rendergrid_isalldata(data,type,row,me);}}

,{ "title" : '备注',"data" :'memo',"orderable":true}

,{ "title" : '更新人',"width":150,"data" :'updateman',"orderable":true}

,{ "title" : '更新时间',"width":150,"data" :'updatedate',"orderable":true}
]
},searchForm:{enableAdvanceSearch:false,dename:'USERROLEDATA'}}};
    return  $.extend({},config,cfg);
}
,doHideParentColumns: function (parentMode)
    {
        var me=this;
        arguments.callee.$.doHideParentColumns.call(this,parentMode);
 
         //关系类型 : DER1N ,主实体 :ORG / 组织机构
         if (parentMode.srfparenttype=='DER1N' && parentMode.srfder1nid=='DER1N_USERROLEDATA_ORG_DSTORGID')
         {
              return;
         }
         //关系类型 : DER1N ,主实体 :DATAENTITY / 实体
         if (parentMode.srfparenttype=='DER1N' && parentMode.srfder1nid=='DER1N_USERROLEDATA_DATAENTITY_DEID')
         {
              me.hideGridColumn('dename');
              return;
         }
         //关系类型 : DER1N ,主实体 :ORGSECTOR / 组织部门
         if (parentMode.srfparenttype=='DER1N' && parentMode.srfder1nid=='DER1N_USERROLEDATA_ORGSECTOR_DSTORGSECTORID')
         {
              return;
         }
}
    ,rendergrid_orgdr:function(data,type,row,me){
        return me.renderCodeList_NumOr('uniPSample_URDOrgDR',data,'未定义','、');
    }
    ,rendergrid_secdr:function(data,type,row,me){
        return me.renderCodeList_NumOr('uniPSample_URDSecDR',data,'未定义','、');
    }
    ,rendergrid_isalldata:function(data,type,row,me){
           return me.renderCodeList_Normal('uniPSample_YesNo',data,'未定义');
    }
});