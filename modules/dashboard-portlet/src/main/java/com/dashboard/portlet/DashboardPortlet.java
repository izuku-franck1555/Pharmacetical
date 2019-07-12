package com.dashboard.portlet;

import com.dashboard.constants.DashboardPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

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
		String statut = (String) session.getAttribute("statutConnexion", PortletSession.APPLICATION_SCOPE);
		Integer id = (Integer) session.getAttribute("idPharmacien", PortletSession.APPLICATION_SCOPE);
		if(id != null) {
			System.out.println("Vous etes un pharmacien ayant pour identifiant : " + id + " et pour statut : " + statut);
		} else {
			id = (Integer) session.getAttribute("idAssistant", PortletSession.APPLICATION_SCOPE);
			System.out.println("Vous etes un assistant ayant pour identifiant : " + id + " et pour statut : " + statut);
		}
		super.render(renderRequest, renderResponse);
	}
	
	
	
	
	
}