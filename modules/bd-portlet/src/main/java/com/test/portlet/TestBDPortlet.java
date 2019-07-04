package com.test.portlet;

import com.test.constants.TestBDPortletKeys;

import java.io.IOException;
import java.sql.SQLException;

import com.bd.Connection;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
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
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TestBD",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TestBDPortletKeys.TESTBD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TestBDPortlet extends MVCPortlet {
	
	@Override
	public void init() throws PortletException {
		// TODO Auto-generated method stub
		System.out.println("Je suis initialise !");
		super.init();
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		String nom = (String) renderRequest.getAttribute("nom");
		String prenom = (String) renderRequest.getAttribute("prenom");
		String message = "";
		if (nom == null || prenom == null || Validator.isBlank(prenom) || Validator.isBlank(nom)) {
			super.render(renderRequest, renderResponse);
		} else {
			try {
				Connection.connect();
				Connection.ajout(nom, prenom);
				message = "Connexion etablie !";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "Connexion non etablie !";
			}
			renderRequest.setAttribute("message", message);
			getPortletContext().getRequestDispatcher("/META-INF/resources/result.jsp").forward(renderRequest, renderResponse);
		}
	}
	
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		String nom = ParamUtil.getString(actionRequest, "nom");
		String prenom = ParamUtil.getString(actionRequest, "prenom");
		actionRequest.setAttribute("nom", nom);
		actionRequest.setAttribute("prenom", prenom);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
}