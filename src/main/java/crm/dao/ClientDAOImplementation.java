package crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import crm.entity.ClientClass;



@Repository
public class ClientDAOImplementation implements ClientDAO{

@Autowired
private SessionFactory generateurDeSession;

//Retourne la liste des clients au controllerCRM
//@Transactional, il faut utiliser le tag <annotation-driven> de l'espace de nommage tx pour préciser à Spring 
//que les annotations sont utilisées pour la définition des transactions.
//indique au conteneur les méthodes qui doivent s'exécuter dans un contexte transactionnel.
//@Transactional. Enlève l'obligation d'ajouter du code tel que
//Begin transtation , commit transaction….

//Avec projet_crm_spring_hibernate.xml
	@Override
	public List<ClientClass> getClients() {
		
		//Obtenir la session en cours d'hibernate
		Session sessionEnCours =generateurDeSession.getCurrentSession();
		
		//Créer une requete sur la ClassClient pour obtenir la liste
		Query<ClientClass> uneRequete = sessionEnCours.createQuery("from ClientClass order by nom", ClientClass.class);
		
		//Obtenir ke resultat final
		List<ClientClass> listClients = uneRequete.getResultList();
		
		//Retour sous forme de liste
		return listClients;
		
	}

	@Override
	public void addClient(ClientClass clientClass) {
		
		//Obtenir la session en cours d'hibernate
				Session sessionEnCours =generateurDeSession.getCurrentSession();
		
		//Sauvegarde le client.
		sessionEnCours.save(clientClass);
		
	}

	@Override
	public ClientClass getClient(int idClient) {
		
		String idClientSQL = "from ClientClass c where c.id="+idClient;
		
		//Obtenir la session en cours d'hibernate
				Session sessionEnCours =generateurDeSession.getCurrentSession();
				
				//Créer une requete sur la ClassClient pour obtenir la liste
				Query<ClientClass> uneRequete = sessionEnCours.createQuery(idClientSQL, ClientClass.class);
				
				//Obtenir ke resultat final
				ClientClass leClientClass = uneRequete.getSingleResult();
		
		
		return  leClientClass;
	}

	@Override
	public void updateClient(ClientClass clientClass) {
		//Obtenir la session en cours d'hibernate
		Session sessionEnCours =generateurDeSession.getCurrentSession();

		//Sauvegarde le client.
		sessionEnCours.update(clientClass);
		
	}

	@Override
	public void suppressionClient(ClientClass clientClass) {
				
		//Obtenir la session en cours d'hibernate
		Session sessionEnCours =generateurDeSession.getCurrentSession();
		
		//Suppresion du client.
		sessionEnCours.delete(clientClass);

	}



}
