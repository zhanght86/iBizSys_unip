<%@page contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="p" scope="page" class="net.ibizsys.paas.web.VCPage" />
<% if(!p.init(pageContext,"/app/common/DEDataChgPickupView.do")){return;}%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ibiz5" uri="http://www.ibizsys.cn/tags"%>
<c:set var="web" value="${pageContext.request.contextPath}" />
<c:set var="ctx" value="${pageContext.request.contextPath}/app" />
<c:set var="ctx2" value="${pageContext.request.contextPath}/app" />
<% String strEmbed = (p.isEmbed()?"true":"");String strCId=p.getCId();pageContext.setAttribute("cid",strCId);String strIFChild=(p.isIFChild()?"true":"false");String strLocale=p.getLocalization().toLowerCase();pageContext.setAttribute("locale",strLocale);%>
<%if (!p.isEmbed()) {%>
<!DOCTYPE html>
<html lang="zh-CN">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
<%@include file="../../lib/lib-common-style.jsp"%>
<%@include file="../../lib/lib-user-style.jsp"%>
<%@include file="../../lib/depickupgridviewlib-style.jsp"%>
<%@include file="../../lib/depickupviewlib-style.jsp"%>
<%}%>
<jsp:include page="../../templ/depickupview.jsp" flush="true" >
	<jsp:param name="controller" value="/app/common/DEDataChgPickupView.do"/>
	<jsp:param name="parturl" value="../jsp/common/dedatachgpickupview_part.jsp"/>
	<jsp:param name="cid" value="<%=p.getCId()%>"/>
	<jsp:param name="embed" value="<%=strEmbed%>"/>
        <jsp:param name="ifchild" value="<%=strIFChild%>"/>
</jsp:include>
<%if (!p.isEmbed()) {%>
<%@include file="../../lib/lib-common-script.jsp"%>
<%@include file="../../lib/lib-user-script.jsp"%>
<%@include file="../../lib/depickupgridviewlib-script.jsp"%>
<%@include file="../../lib/depickupviewlib-script.jsp"%>
<script src='${ctx}/js/common/DEDataChgPickupGridViewControllerBase.js?v=251_20171123142453' type='text/javascript'></script>
<script src='${ctx}/js/common/DEDataChgPickupGridViewController.js?v=251_20171123142453' type='text/javascript'></script>
<script src='${ctx}/js/common/DEDataChgPickupViewControllerBase.js?v=251_20171123142453' type='text/javascript'></script>
<script src='${ctx}/js/common/DEDataChgPickupViewController.js?v=251_20171123142453' type='text/javascript'></script>
<script>
var controller = null;
function getController()
{
   return controller;
}
jQuery(document).ready(function(){
        controller = new DEDataChgPickupViewController({appctx:'${ctx2}',webctx:'${web}'});
	controller.init({parentMode:<%=p.getParentMode()%>,parentData:<%=p.getParentData()%>});
});
</script>
</body>
</html>
<%}%>