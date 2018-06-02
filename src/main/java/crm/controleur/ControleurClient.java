package crm.controleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import crm.entity.ClientClass;
import crm.service.ServiceClient;


@Controller
@RequestMapping("/clients")
public class ControleurClient {
	
	//Créer un lien automatiquement grace à cette annotation
	@Autowired
	private ServiceClient serviceClient;

	
	@RequestMapping("/liste")
	public String listClients(Model pageClients) {
		
		//Obenir les clients depuis clientDAO
		List<ClientClass> listClient = serviceClient.GetListClient();
		
		//ajouter les clients à la page clients - listclientjsp est utilisé dans un foreach sur la page list-clients
		pageClients.addAttribute("listClientJSP", listClient);
		
		
		//retourne la liste des clients sur la page jsp suivante
		return "list-clients";
	}
	
	@GetMapping("/formAjoutClientJSP")
	public String ajouterClientMethode(Model modelClient) {
		
		//Creer un attribut Model lier au formulaire ajouter-client.jp
		ClientClass unClientClass = new ClientClass();		
		modelClient.addAttribute("ajoutClientJSP", unClientClass);

		return "ajouter-client";
	}
	
	@PostMapping("/formAjoutClientJSPValider")
	public String sauvegardeClient(@ModelAttribute("ajoutClientJSP") ClientClass clientClass ) {
		
		serviceClient.ajoutClient(clientClass);
		
		return "redirect:/clients/liste/";
		
	}
	
	@GetMapping("/formulaireMAJClient")
	public String miseAJourClient(@RequestParam("idClient")int idClient, Model vueUpdateclient ) {
		
		//Obtenir le client depuis la class service
		ClientClass clientClass =serviceClient.GetClient(idClient);
		
		//Auto complete le formulaire  
		vueUpdateclient.addAttribute("clientUpdateJSP", clientClass);
		//et envoyé sur la page
		return "miseAJour-client";
	}
	
	@PostMapping("/UpdateClientValider")
	public String updateClientValider(@ModelAttribute("UpdateClientValider") ClientClass clientClass ) {
		
		serviceClient.updateClient(clientClass);
		
		return "redirect:/clients/liste/";
		
	}
	
	@GetMapping("/suppressionClient")
	public String suppressionClient(@RequestParam("idClient")int idClient ) {
		

		//Obtenir le client depuis la class service
		ClientClass clientClass =serviceClient.GetClient(idClient);
		
		
		//Obtenir les client depuis la class service- 
		serviceClient.suppressionClient(clientClass);
		
		
		//et envoyé sur la page
		return "redirect:/clients/liste/";
	}
	
	@GetMapping("/formClientRechercheJSP")
	public String rechercherClient(Model modelClient) {
		
		//Creer un attribut Model lier au formulaire ajouter-client.jp
		ClientClass unClientClass = new ClientClass();		
		modelClient.addAttribute("rechercheClientJSP", unClientClass);

		return "rechercher-client";
	}
	
	@PostMapping("/formClientRechercheJSP-Valider")
	public String rechercheClientValider(@ModelAttribute("rechercheClientJSP") ClientClass nom, Model model ) {
		
		List<ClientClass> listClient= serviceClient.GetListClient();
		List<ClientClass> listClientFound = new ArrayList<>();
		
		boolean clientTrouvé=false;

		for (ClientClass clientClass : listClient) {	
		
			if (clientClass.getNom().equalsIgnoreCase(nom.getNom()) ) {
				
				ClientClass unClientClass=serviceClient.GetClient(clientClass.getId());
				listClientFound.add(unClientClass);
				clientTrouvé=true;
			}	
			
		}
		if (clientTrouvé) {
			
			model.addAttribute("listClientFoundJSP",listClientFound);
			
			return "list-client-found";
			
		}else {
			return "list-client-notfound";
		}	
	}
}

