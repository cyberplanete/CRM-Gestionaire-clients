package crm.dao;

import java.util.List;

import crm.entity.ClientClass;


public interface ClientDAO {
	
	public List<ClientClass> getClients();

	public void addClient(ClientClass clientClass);

	public ClientClass getClient(int idClient);

	public void updateClient(ClientClass clientClass);

	public void suppressionClient(ClientClass clientClass);

	

}
