/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package com.sa.unip.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import net.ibizsys.paas.appmodel.AppModelGlobal;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.controller.ViewControllerGlobal;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;


import com.sa.unip.srv.UniPSampleSysModel;
import com.sa.unip.app.appAppModel;


/**
 * 视图[OrgUserUX_GridView2]控制类基类
 *
 * !! 不要对此代码进行修改
 */
@Controller
@RequestMapping(value = "/app/common/OrgUserUX_GridView2.do")
public class OrgUserUX_GridView2Controller extends net.ibizsys.paas.controller.GridViewControllerBase {
    public OrgUserUX_GridView2Controller() throws Exception {
        super();
        this.setId("742a3692441bac6d81774c53f645810a");
        this.setCaption("组织人员");
        this.setTitle("组织人员表格视图");
        this.setAccessUserMode(2);
        //支持快速搜索
        this.setAttribute("UI.ENABLEQUICKSEARCH","TRUE");
        //
        this.setAttribute("UI.CTRL.GRID","TRUE");
        //
        this.setAttribute("UI.CTRL.SEARCHFORM","TRUE");
        //
        this.setAttribute("UI.CTRL.TOOLBAR","TRUE");
        //支持搜常规索
        this.setAttribute("UI.ENABLESEARCH","TRUE");

        ViewControllerGlobal.registerViewController("/app/common/OrgUserUX_GridView2.do",this);
        ViewControllerGlobal.registerViewController("com.sa.unip.app.common.controller.OrgUserUX_GridView2Controller",this);
    }


    @Override
    protected void prepareViewParam() throws Exception {
        super.prepareViewParam();


    }

    private UniPSampleSysModel uniPSampleSysModel;

    public  UniPSampleSysModel getUniPSampleSysModel() {
        if(this.uniPSampleSysModel==null) {
            try {
                this.uniPSampleSysModel = (UniPSampleSysModel)SysModelGlobal.getSystem("com.sa.unip.srv.UniPSampleSysModel");
            } catch(Exception ex) {
            }
        }
        return this.uniPSampleSysModel;
    }

    @Override
    public  ISystemModel getSystemModel() {
        return this.getUniPSampleSysModel();
    }


    private appAppModel appAppModel;
    public  appAppModel getappAppModel() {
        if(this.appAppModel==null) {
            try {
                this.appAppModel = (appAppModel)AppModelGlobal.getApplication("com.sa.unip.app.appAppModel");
            } catch(Exception ex) {
            }
        }
        return this.appAppModel;
    }

    @Override
    public  IApplicationModel  getAppModel() {
        return this.getappAppModel();
    }





    private com.sa.unip.srv.subsys.demodel.OrgUserDEModel orgUserDEModel;

    public  com.sa.unip.srv.subsys.demodel.OrgUserDEModel getOrgUserDEModel() {
        if(this.orgUserDEModel==null) {
            try {
                this.orgUserDEModel = (com.sa.unip.srv.subsys.demodel.OrgUserDEModel)DEModelGlobal.getDEModel("com.sa.unip.srv.subsys.demodel.OrgUserDEModel");
            } catch(Exception ex) {
            }
        }
        return this.orgUserDEModel;
    }

    public  IDataEntityModel getDEModel() {
        return this.getOrgUserDEModel();
    }

    public  com.sa.unip.srv.subsys.service.OrgUserService getOrgUserService() {
        try {
            return (com.sa.unip.srv.subsys.service.OrgUserService)ServiceGlobal.getService("com.sa.unip.srv.subsys.service.OrgUserService",this.getSessionFactory());
        } catch(Exception ex) {
            return null;
        }
    }

    /* (non-Javadoc)
    * @see net.ibizsys.paas.controller.IViewController#getService()
    */
    @Override
    public IService getService() {
        return getOrgUserService();
    }





    /**
     * 准备部件模型
     * @throws Exception
     */
    @Override
    protected void prepareCtrlModels()throws Exception {
        //注册 grid
        ICtrlModel grid=(ICtrlModel)getUniPSampleSysModel().createObject("com.sa.unip.app.srv.common.ctrlmodel.OrgUserUX_Main2GridModel");
        grid.init(this);
        this.registerCtrlModel("grid",grid);
        //注册 searchform
        ICtrlModel searchForm=(ICtrlModel)getUniPSampleSysModel().createObject("com.sa.unip.app.srv.common.ctrlmodel.OrgUserDefaultSearchFormModel");
        searchForm.init(this);
        this.registerCtrlModel("searchform",searchForm);
    }

    /**
     * 准备部件处理对象
     * @throws Exception
     */
    @Override
    protected void prepareCtrlHandlers()throws Exception {
        //注册 grid
        ICtrlHandler grid = (ICtrlHandler)getUniPSampleSysModel().createObject("com.sa.unip.app.common.ctrlhandler.OrgUserUX_GridView2GridHandler");
        grid.init(this);
        this.registerCtrlHandler("grid",grid);
        //注册 searchform
        ICtrlHandler searchForm = (ICtrlHandler)getUniPSampleSysModel().createObject("com.sa.unip.app.common.ctrlhandler.OrgUserUX_GridView2SearchFormHandler");
        searchForm.init(this);
        this.registerCtrlHandler("searchform",searchForm);
    }


    /**
     * 注册界面行为
     * @throws Exception
     */
    @Override
    protected void prepareUIActions()throws Exception {

    }
}