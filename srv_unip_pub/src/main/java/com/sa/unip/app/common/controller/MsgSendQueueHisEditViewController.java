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
 * 视图[MsgSendQueueHisEditView]控制类基类
 *
 * !! 不要对此代码进行修改
 */
@Controller
@RequestMapping(value = "/app/common/MsgSendQueueHisEditView.do")
public class MsgSendQueueHisEditViewController extends net.ibizsys.paas.controller.EditViewControllerBase {
    public MsgSendQueueHisEditViewController() throws Exception {
        super();
        this.setId("73f1022e2f1fc676834a51b896e4e481");
        this.setCaption("消息发送队列（历史）");
        this.setTitle("消息发送队列（历史）实体编辑视图");
        this.setCapLanResTag("DE.LNAME.MSGSENDQUEUEHIS");
        this.setAccessUserMode(2);
        //
        this.setAttribute("UI.CTRL.FORM","TRUE");
        //显示数据信息栏
        this.setAttribute("UI.SHOWDATAINFOBAR","TRUE");
        //
        this.setAttribute("UI.CTRL.TOOLBAR","TRUE");

        ViewControllerGlobal.registerViewController("/app/common/MsgSendQueueHisEditView.do",this);
        ViewControllerGlobal.registerViewController("com.sa.unip.app.common.controller.MsgSendQueueHisEditViewController",this);
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





    private net.ibizsys.psrt.srv.common.demodel.MsgSendQueueHisDEModel msgSendQueueHisDEModel;

    public  net.ibizsys.psrt.srv.common.demodel.MsgSendQueueHisDEModel getMsgSendQueueHisDEModel() {
        if(this.msgSendQueueHisDEModel==null) {
            try {
                this.msgSendQueueHisDEModel = (net.ibizsys.psrt.srv.common.demodel.MsgSendQueueHisDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.MsgSendQueueHisDEModel");
            } catch(Exception ex) {
            }
        }
        return this.msgSendQueueHisDEModel;
    }

    public  IDataEntityModel getDEModel() {
        return this.getMsgSendQueueHisDEModel();
    }

    public  net.ibizsys.psrt.srv.common.service.MsgSendQueueHisService getMsgSendQueueHisService() {
        try {
            return (net.ibizsys.psrt.srv.common.service.MsgSendQueueHisService)ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.MsgSendQueueHisService",this.getSessionFactory());
        } catch(Exception ex) {
            return null;
        }
    }

    /* (non-Javadoc)
    * @see net.ibizsys.paas.controller.IViewController#getService()
    */
    @Override
    public IService getService() {
        return getMsgSendQueueHisService();
    }





    /**
     * 准备部件模型
     * @throws Exception
     */
    @Override
    protected void prepareCtrlModels()throws Exception {
        //注册 form
        ICtrlModel editForm=(ICtrlModel)getUniPSampleSysModel().createObject("com.sa.unip.app.srv.common.ctrlmodel.MsgSendQueueHisMain2EditFormModel");
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
        ICtrlHandler editForm = (ICtrlHandler)getUniPSampleSysModel().createObject("com.sa.unip.app.common.ctrlhandler.MsgSendQueueHisEditViewEditFormHandler");
        editForm.init(this);
        this.registerCtrlHandler("form",editForm);
    }


    /**
     * 注册界面行为
     * @throws Exception
     */
    @Override
    protected void prepareUIActions()throws Exception {

    }
}