package com.gest.ventes.portlet;

import com.gest.ventes.constants.GestionVentesPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import bind.ProduitBasic;
import model.ConnectDB;

/**
 * @author liferay
 */
@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=category.sample",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/Ajouter_vente.jsp",
				"javax.portlet.name=" + GestionVentesPortletKeys.GestionVentes,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
		)
public class GestionVentesPortlet extends MVCPortlet {

	@ProcessAction(name="AfficherVente")
	public void AfficherVente(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		int compteur=ParamUtil.getInteger(request, "conteur");
		int cpt=1;
		int ct=1;
		String tableau="";
		String tableau1="";
		int total=0;
		ProduitBasic vente=new ProduitBasic();
		ArrayList<ProduitBasic> test=new ArrayList<ProduitBasic>() ;
		ArrayList<String> absents = new ArrayList<>();
		while(cpt<=compteur) {
			int qtee=ParamUtil.getInteger(request, "quantiteProd"+cpt);
			try {
				ConnectDB c = new ConnectDB();
				int id=c.existe2(ParamUtil.getString(request, "nomProd"+cpt));
				if(id != -1) {
					int qte=c.getQuantite(id);
					if(qte>=qtee) {
						vente.setPrixProd(c.getPrix(id));
						vente.setNomProd(ParamUtil.getString(request, "nomProd"+cpt));
						vente.setQuantiteProd(qtee);
						test.add(vente);
						total+=vente.getPrixProd()*vente.getQuantiteProd();
						tableau+="<tr>"
								+ "<td>"+vente.getNomProd()
								+ "<input type=\"hidden\" name=\"nomProd"+ct+"\" value=\""+vente.getNomProd()+"\">"+ "</td>"
								+ "<td>"+vente.getQuantiteProd()
								+ "<input type=\"hidden\"  class=\"produit\" name=\"quantiteProd"+ct+"\" value=\""+vente.getQuantiteProd()+"\">"+ "</td>"
								+ "<td>"+vente.getPrixProd()
								+ "</tr>";

						tableau1+="<input type=\"hidden\" name=\"nomProd"+ct+"\" value=\""+vente.getNomProd()+"\">"+ "</td>"
								+ "<input type=\"hidden\"  name=\"quantiteProd"+ct+"\" value=\""+vente.getQuantiteProd()+"\">"+ "</td>";
					}
					ct++;
				}
				else {
					absents.add(ParamUtil.getString(request, "nomProd"+cpt));
				}
				cpt++;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("absents","Produits absents :"+absents);
		request.setAttribute("produit", tableau);
		request.setAttribute("produits", tableau1);
		request.setAttribute("total", total);
		response.getRenderParameters().setValue("mvcPath", "/Affiche_de_la_vente.jsp");
	}



}