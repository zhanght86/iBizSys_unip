/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package com.sa.unip.app.jcsj.controller;

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
 * 视图[OA_HYSRedirectView]控制类基类
 *
 * !! 不要对此代码进行修改
 */
@Controller
@RequestMapping(value = "/app/jcsj/OA_HYSRedirectView.do")
public class OA_HYSRedirectViewController extends net.ibizsys.paas.controller.RedirectViewControllerBase {
    public OA_HYSRedirectViewController() throws Exception {
        super();
        this.setId("3cc8a76087048820f3d8fc8fecbbd82a");
        this.setCaption("会议室");
        this.setTitle("会议室数据重定向视图");
        this.setCapLanResTag("DE.LNAME.OA_HYS");
        this.setTitleLanResTag("PAGE.TITLE.OA_HYS.REDIRECTVIEW");
        this.setAccessUserMode(2);

        ViewControllerGlobal.registerViewController("/app/jcsj/OA_HYSRedirectView.do",this);
        ViewControllerGlobal.registerViewController("com.sa.unip.app.jcsj.controller.OA_HYSRedirectViewController",this);
    }


    @Override
    protected void prepareViewParam() throws Exception {
        super.prepareViewParam();

        this.setEnableWorkflow(true);

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





    private com.sa.unip.srv.jcsj.demodel.OA_HYSDEModel oA_HYSDEModel;

    public  com.sa.unip.srv.jcsj.demodel.OA_HYSDEModel getOA_HYSDEModel() {
        if(this.oA_HYSDEModel==null) {
            try {
                this.oA_HYSDEModel = (com.sa.unip.srv.jcsj.demodel.OA_HYSDEModel)DEModelGlobal.getDEModel("com.sa.unip.srv.jcsj.demodel.OA_HYSDEModel");
            } catch(Exception ex) {
            }
        }
        return this.oA_HYSDEModel;
    }

    public  IDataEntityModel getDEModel() {
        return this.getOA_HYSDEModel();
    }

    public  com.sa.unip.srv.jcsj.service.OA_HYSService getOA_HYSService() {
        try {
            return (com.sa.unip.srv.jcsj.service.OA_HYSService)ServiceGlobal.getService("com.sa.unip.srv.jcsj.service.OA_HYSService",this.getSessionFactory());
        } catch(Exception ex) {
            return null;
        }
    }

    /* (non-Javadoc)
    * @see net.ibizsys.paas.controller.IViewController#getService()
    */
    @Override
    public IService getService() {
        return getOA_HYSService();
    }





    /**
     * 准备部件模型
     * @throws Exception
     */
    @Override
    protected void prepareCtrlModels()throws Exception {
    }

    /**
     * 准备部件处理对象
     * @throws Exception
     */
    @Override
    protected void prepareCtrlHandlers()throws Exception {
    }


    /**
     * 注册界面行为
     * @throws Exception
     */
    @Override
    protected void prepareUIActions()throws Exception {

    }
}