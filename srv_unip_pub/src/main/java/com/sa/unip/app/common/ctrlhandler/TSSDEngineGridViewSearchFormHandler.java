/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package com.sa.unip.app.common.ctrlhandler;


import java.util.ArrayList;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;

import com.sa.unip.app.srv.common.ctrlmodel.TSSDEngineDefaultSearchFormModel;
import net.ibizsys.psrt.srv.common.demodel.TSSDEngineDEModel;
import net.ibizsys.psrt.srv.common.service.TSSDEngineService;
import net.ibizsys.psrt.srv.common.dao.TSSDEngineDAO;
import net.ibizsys.psrt.srv.common.entity.TSSDEngine;

import net.ibizsys.paas.ctrlmodel.ISearchFormModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.SDAjaxActionResult;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.ctrlhandler.IFormItemHandler;
import net.ibizsys.paas.ctrlhandler.IFormItemUpdateHandler;

public class TSSDEngineGridViewSearchFormHandler extends net.ibizsys.paas.ctrlhandler.SearchFormHandlerBase {

    protected TSSDEngineDefaultSearchFormModel searchformModel = null;
    public TSSDEngineGridViewSearchFormHandler()  {
        super();
    }

    @Override
    protected void onInit() throws Exception {
        searchformModel  = (TSSDEngineDefaultSearchFormModel)this.getViewController().getCtrlModel("searchform");
        super.onInit();
    }

    @Override
    protected ISearchFormModel getSearchFormModel() {
        return this.getRealSearchFormModel();
    }

    protected TSSDEngineDefaultSearchFormModel getRealSearchFormModel() {
        return this.searchformModel ;
    }

    protected TSSDEngineService getRealService() {
        return (TSSDEngineService)this.getViewController().getService();
    }

    /**
    * 准备部件成员处理对象
     * @throws Exception
     */
    @Override
    protected void prepareCtrlItemHandlers()throws Exception {
        super.prepareCtrlItemHandlers();

        ISystemRuntime iSystemRuntime = (ISystemRuntime)this.getSystemModel();


    }

}