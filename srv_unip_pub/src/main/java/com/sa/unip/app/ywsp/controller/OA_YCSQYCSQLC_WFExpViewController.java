/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package com.sa.unip.app.ywsp.controller;

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
 * 视图[OA_YCSQYCSQLC_WFExpView]控制类基类
 *
 * !! 不要对此代码进行修改
 */
@Controller
@RequestMapping(value = "/app/ywsp/OA_YCSQYCSQLC_WFExpView.do")
public class OA_YCSQYCSQLC_WFExpViewController extends net.ibizsys.pswf.controller.WFExpViewControllerBase {
    public OA_YCSQYCSQLC_WFExpViewController() throws Exception {
        super();
        this.setId("7ca5c63f3348f394f5e94c6adb491e67");
        this.setCaption("用餐申请");
        this.setTitle("用餐申请工作流导航视图(用餐申请流程)");
        this.setCapLanResTag("DE.LNAME.OA_YCSQ");
        this.setAccessUserMode(2);
        //
        this.setAttribute("UI.CTRL.EXPBAR","TRUE");

        ViewControllerGlobal.registerViewController("/app/ywsp/OA_YCSQYCSQLC_WFExpView.do",this);
        ViewControllerGlobal.registerViewController("com.sa.unip.app.ywsp.controller.OA_YCSQYCSQLC_WFExpViewController",this);
    }


    @Override
    protected void prepareViewParam() throws Exception {
        super.prepareViewParam();
        this.setWFModel(this.getSystemModel().getWFModel("ADE23A90-392B-4847-9284-052BCC1AD79C"));
        this.setDEWF(this.getDEModel().getDEWF("516F0D57-927D-47AC-B952-BC090459E616"));


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





    private com.sa.unip.srv.ywsp.demodel.OA_YCSQDEModel oA_YCSQDEModel;

    public  com.sa.unip.srv.ywsp.demodel.OA_YCSQDEModel getOA_YCSQDEModel() {
        if(this.oA_YCSQDEModel==null) {
            try {
                this.oA_YCSQDEModel = (com.sa.unip.srv.ywsp.demodel.OA_YCSQDEModel)DEModelGlobal.getDEModel("com.sa.unip.srv.ywsp.demodel.OA_YCSQDEModel");
            } catch(Exception ex) {
            }
        }
        return this.oA_YCSQDEModel;
    }

    public  IDataEntityModel getDEModel() {
        return this.getOA_YCSQDEModel();
    }

    public  com.sa.unip.srv.ywsp.service.OA_YCSQService getOA_YCSQService() {
        try {
            return (com.sa.unip.srv.ywsp.service.OA_YCSQService)ServiceGlobal.getService("com.sa.unip.srv.ywsp.service.OA_YCSQService",this.getSessionFactory());
        } catch(Exception ex) {
            return null;
        }
    }

    /* (non-Javadoc)
    * @see net.ibizsys.paas.controller.IViewController#getService()
    */
    @Override
    public IService getService() {
        return getOA_YCSQService();
    }





    /**
     * 准备部件模型
     * @throws Exception
     */
    @Override
    protected void prepareCtrlModels()throws Exception {
        //注册 expbar
        ICtrlModel expBar=(ICtrlModel)getUniPSampleSysModel().createObject("com.sa.unip.app.srv.ywsp.ctrlmodel.OA_YCSQexpbarWFExpBarModel");
        expBar.init(this);
        this.registerCtrlModel("expbar",expBar);
    }

    /**
     * 准备部件处理对象
     * @throws Exception
     */
    @Override
    protected void prepareCtrlHandlers()throws Exception {
        //注册 expbar
        ICtrlHandler expBar = (ICtrlHandler)getUniPSampleSysModel().createObject("com.sa.unip.app.ywsp.ctrlhandler.OA_YCSQYCSQLC_WFExpViewExpBarHandler");
        expBar.init(this);
        this.registerCtrlHandler("expbar",expBar);
    }


    /**
     * 注册界面行为
     * @throws Exception
     */
    @Override
    protected void prepareUIActions()throws Exception {

    }
}