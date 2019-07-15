package com.dashboard.portlet;

import com.dashboard.constants.DashboardPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.pharmacie.model.Assistant;
import com.pharmacie.model.Module;
import com.pharmacie.model.Pharmacien;
import com.pharmacie.service.AssistantService;
import com.pharmacie.service.ModuleService;
import com.pharmacie.service.PharmacienService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author franck
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DashboardPortletKeys.Dashboard,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DashboardPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		PortletSession session = renderRequest.getPortletSession();
		Integer idP = (Integer) session.getAttribute("idPharmacien", PortletSession.APPLICATION_SCOPE);
		Integer idA = (Integer) session.getAttribute("idAssistant", PortletSession.APPLICATION_SCOPE);
		if(idP != null) {
			System.out.println("Vous etes un pharmacien ayant pour identifiant : " + idP );
			try {
				Pharmacien p = PharmacienService.getPharmacienWithId(idP);
				renderRequest.setAttribute("personne", p);
				List<Module> list = ModuleService.getPharmacienModuleList();
				renderRequest.setAttribute("list", list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			super.render(renderRequest, renderResponse);
			
		} else if(idA != null) {
			System.out.println("Vous etes un assistant ayant pour identifiant : " + idA);
			try {
				Assistant a = AssistantService.getAssistantWithId(idA);
				renderRequest.setAttribute("personne", a);
				List<Module> list = ModuleService.getAssistantModuleList(idA);
				renderRequest.setAttribute("list", list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			super.render(renderRequest, renderResponse);
		} else {
			System.out.println("Vous devez d' abord vous connectez pour acceder au dashboard !");
			this.include("/redirect.jsp", renderRequest, renderResponse);
		}
	}
}