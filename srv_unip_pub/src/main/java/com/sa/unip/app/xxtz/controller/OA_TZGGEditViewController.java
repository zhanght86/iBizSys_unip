/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package com.sa.unip.app.xxtz.controller;

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
 * 视图[OA_TZGGEditView]控制类基类
 *
 * !! 不要对此代码进行修改
 */
@Controller
@RequestMapping(value = "/app/xxtz/OA_TZGGEditView.do")
public class OA_TZGGEditViewController extends net.ibizsys.pswf.controller.EditViewControllerBase {
    public OA_TZGGEditViewController() throws Exception {
        super();
        this.setId("f9f4ab5a498eab2277e23a9cca2024ce");
        this.setCaption("通知公告");
        this.setTitle("通知公告编辑视图");
        this.setCapLanResTag("DE.LNAME.OA_TZGG");
        this.setTitleLanResTag("PAGE.TITLE.OA_TZGG.EDITVIEW");
        this.setAccessUserMode(2);
        //
        this.setAttribute("UI.CTRL.FORM","TRUE");
        //显示数据信息栏
        this.setAttribute("UI.SHOWDATAINFOBAR","TRUE");
        //
        this.setAttribute("UI.CTRL.TOOLBAR","TRUE");

        ViewControllerGlobal.registerViewController("/app/xxtz/OA_TZGGEditView.do",this);
        ViewControllerGlobal.registerViewController("com.sa.unip.app.xxtz.controller.OA_TZGGEditViewController",this);
    }


    @Override
    protected void prepareViewParam() throws Exception {
        super.prepareViewParam();
        this.setWFModel(this.getSystemModel().getWFModel("21C2D14F-CB19-468E-A8E2-B1219566CA04"));
        this.setDEWF(this.getDEModel().getDEWF("75B611EE-617F-4D0B-9BB3-DB4B6CF7D339"));


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





    private com.sa.unip.srv.xxtz.demodel.OA_TZGGDEModel oA_TZGGDEModel;

    public  com.sa.unip.srv.xxtz.demodel.OA_TZGGDEModel getOA_TZGGDEModel() {
        if(this.oA_TZGGDEModel==null) {
            try {
                this.oA_TZGGDEModel = (com.sa.unip.srv.xxtz.demodel.OA_TZGGDEModel)DEModelGlobal.getDEModel("com.sa.unip.srv.xxtz.demodel.OA_TZGGDEModel");
            } catch(Exception ex) {
            }
        }
        return this.oA_TZGGDEModel;
    }

    public  IDataEntityModel getDEModel() {
        return this.getOA_TZGGDEModel();
    }

    public  com.sa.unip.srv.xxtz.service.OA_TZGGService getOA_TZGGService() {
        try {
            return (com.sa.unip.srv.xxtz.service.OA_TZGGService)ServiceGlobal.getService("com.sa.unip.srv.xxtz.service.OA_TZGGService",this.getSessionFactory());
        } catch(Exception ex) {
            return null;
        }
    }

    /* (non-Javadoc)
    * @see net.ibizsys.paas.controller.IViewController#getService()
    */
    @Override
    public IService getService() {
        return getOA_TZGGService();
    }





    /**
     * 准备部件模型
     * @throws Exception
     */
    @Override
    protected void prepareCtrlModels()throws Exception {
        //注册 form
        ICtrlModel editForm=(ICtrlModel)getUniPSampleSysModel().createObject("com.sa.unip.app.srv.xxtz.ctrlmodel.OA_TZGGMainEditFormModel");
        editForm.init(this);
        this.registerCtrlModel("form",editForm);
    }

    /**
     * 准备部件处理对象
     * @throws Exception
     */
    @Override
    protected void prepareCtrlHandlers()throws Exception {
        //注册 form
        ICtrlHandler editForm = (ICtrlHandler)getUniPSampleSysModel().createObject("com.sa.unip.app.xxtz.ctrlhandler.OA_TZGGEditViewEditFormHandler");
        editForm.init(this);
        this.registerCtrlHandler("form",editForm);
    }


    /**
     * 注册界面行为
     * @throws Exception
     */
    @Override
    protected void prepareUIActions()throws Exception {
        this.registerUIAction("FSTZGGXX");

    }
}