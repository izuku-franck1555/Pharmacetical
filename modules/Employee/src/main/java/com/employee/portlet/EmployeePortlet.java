package com.employee.portlet;

import com.employee.constants.EmployeePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeePortletKeys.Employee,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmployeePortlet extends MVCPortlet {
	
	@Override
		public void render(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			// TODO Auto-generated method stub
			System.out.println("Je suis dans le render");
			String test = renderRequest.getParameter("var");
			//System.out.println("La valeur de var est : " + test);
			if(test == null) {
				renderRequest.setAttribute("placeholder1", "Nom");
				renderRequest.setAttribute("placeholder2", "Address");
				this.include("/addEmployee.jsp", renderRequest, renderResponse);
			} else {
				//renderRequest.setAttribute("mvcPath", "/addEmployee.jsp");
				super.render(renderRequest, renderResponse);
			}
			//super.render(renderRequest, renderResponse);
		}
	
	public void addEmployee(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws IOException, PortletException {
		System.out.println("Je suis dans le processAction");
		String employeeName = ParamUtil.getString(actionRequest, "employeeName");
		String employeeAddress = ParamUtil.getString(actionRequest,"employeeAddress");
		Map<String, String> employeeMap = new HashMap<String, String>();
		employeeMap.put("employeeName", employeeName);
		employeeMap.put("employeeAddress", employeeAddress);
		actionRequest.setAttribute("employeeMap", employeeMap);
		actionResponse.getRenderParameters().setValue("var", "Bonjour");
		actionResponse.getRenderParameters().setValue("mvcPath", "/displayEmployee.jsp");
		//include("/displayEmployee.jsp", actionRequest, actionResponse);
		System.out.println("Je quitte le processAction");
		//actionResponse.setRenderParameter("mvcPath","/displayEmployee.jsp");
	}
}