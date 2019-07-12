package com.connexion.portlet;

import com.connexion.constants.ConnexionPortletKeys;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.pharmacie.model.Pharmacien;
import com.pharmacie.model.Assistant;
import com.pharmacie.service.PharmacienService;
import com.pharmacie.service.AssistantService;

import java.io.IOException;
import java.sql.SQLException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

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
		"javax.portlet.name=" + ConnexionPortletKeys.Connexion,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ConnexionPortlet extends MVCPortlet {
	
	@Override
	public void init() throws PortletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		PortletSession session = renderRequest.getPortletSession();
		String statut = (String) session.getAttribute("statutConnexion", PortletSession.APPLICATION_SCOPE);
		if (statut == "0") {
			renderRequest.setAttribute("usernameplaceholder", "Username Incorrect");
			renderRequest.setAttribute("passwordplaceholder", "Password Incorrect");
		}
		else if (statut == "1") {
			System.out.println("Vous etes deconnectez a present !");
			renderRequest.setAttribute("usernameplaceholder", "Username");
			renderRequest.setAttribute("passwordplaceholder", "Password");
			//session.removeAttribute("statut", PortletSession.APPLICATION_SCOPE);
			session.invalidate();
		}
		else {
			renderRequest.setAttribute("usernameplaceholder", "Username");
			renderRequest.setAttribute("passwordplaceholder", "Password");
		}
		super.render(renderRequest, renderResponse);
	}
	  
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		Pharmacien p = null;
		Assistant a = null;
		String username = ParamUtil.getString(actionRequest, "username");
		String password = ParamUtil.getString(actionRequest, "password");
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		PortletURL oPortletUrl = PortletURLFactoryUtil.create(request, "com_test_TestBDPortlet", 33548, PortletRequest.RENDER_PHASE);
		PortletSession session = actionRequest.getPortletSession();
		String portletURL = oPortletUrl.toString();
		try {
			p = PharmacienService.isPharmacien(username, password);
			if (p != null) {
				session.setAttribute("idPharmacien", p.getIdpharmacien(), PortletSession.APPLICATION_SCOPE); 
				session.setAttribute("statutConnexion", "1", PortletSession.APPLICATION_SCOPE);
				actionResponse.sendRedirect(portletURL);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			a = AssistantService.isAssistant(username, password);
			if (a != null) {
				session.setAttribute("idAssistant", a.getIdassistant(), PortletSession.APPLICATION_SCOPE);
				session.setAttribute("statutConnexion", "1", PortletSession.APPLICATION_SCOPE);
				actionResponse.sendRedirect(portletURL);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(a == null && p == null) {
			session.setAttribute("statutConnexion", "0", PortletSession.APPLICATION_SCOPE);
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}



