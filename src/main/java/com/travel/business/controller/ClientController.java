package com.travel.business.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.business.persistence.Client;
import com.travel.business.persistence.Destination;
import com.travel.business.service.ClientService;


@RestController
@RequestMapping("/client")
public class ClientController {
	

		
		@Inject
		@Qualifier("clientServiceImpl")
		private ClientService clientService;
		
		@ResponseBody
		@RequestMapping(value = "/clients", method = RequestMethod.GET, produces = "application/json")
		public List<Client> getClients() throws Exception
		{
			
			try {
				List<Client> clients= clientService.getClientList();
				//clients.stream().forEach(p -> System.out.println("Client="+p.toString()));
				System.out.println("Size:"+clients.size());
				return clients;
			} catch (Exception e) {
				System.err.println(e);
				throw e;
			}
		}
		

		@RequestMapping(value = "/fname/{fn}/lname/{ln}/state/{hs}/country/{hc}", method = RequestMethod.PUT)
		public void createClient(@PathVariable String fn, @PathVariable String ln,  @PathVariable String hs, @PathVariable String hc) throws Exception
		{
            System.out.println("FNAME" + fn);
			try {
				 Client client = new Client();
				 client.setFirstName(fn);
				 client.setLastName(ln);
				 client.setHomeState(hs);
				 client.setHomeCountry(hc);
				 client.setUpdatedBy("PREM");
				 clientService.createClient(client);
			} catch (Exception e) {
				System.err.println(e);
				throw e;
			}
		}
		
		
		@RequestMapping(value = "/fname/{fn}/lname/{ln}", method = RequestMethod.POST)
		public void deleteClient(@PathVariable String fn, @PathVariable String ln) throws Exception
		{
            System.out.println("FNAME: " + fn);
			try {
				 
				 Client client = new Client();
				 client.setFirstName(fn);
				 client.setLastName(ln);
				 client.setUpdatedBy("PREM");
				 
			    clientService.deleteClient(client);
			} catch (Exception e) {
				System.err.println(e);
				throw e;
			}
		}
		
		
		@RequestMapping(value = "/clientid/{id}/fname/{fn}/lname/{ln}/state/{hs}/country/{hc}", method = RequestMethod.POST)
		public Client updateClient(@PathVariable int id , @PathVariable String fn, @PathVariable String ln,  @PathVariable String hs, @PathVariable String hc) throws Exception
		{
            System.out.println("FNAME: " + fn);
			try {
				 
				 Client client = clientService.getClient(id);
				 client.setFirstName(fn);
				 client.setLastName(ln);
				 client.setHomeState(hs);
				 client.setHomeCountry(hc);
				 client.setUpdatedBy("PREM");
				 
				 return clientService.updateClient(client);
			} catch (Exception e) {
				System.err.println(e);
				throw e;
			}
		}
		
		@RequestMapping(value = "/clientId/{id}", method = RequestMethod.GET)
		public Client retrieveClient(@PathVariable int id) throws Exception
		{
            System.out.println("clientId" + id);
			try {

				 return clientService.getClient(id);
			} catch (Exception e) {
				System.err.println(e);
				throw e;
			}
		}
	
		@RequestMapping(value = "/clientId/{id}/lname/{ln}/country/{lc}/travDate/{td}", method = RequestMethod.PUT)
		public void createDestination(@PathVariable int id, @PathVariable String ln,@PathVariable String lc, @PathVariable String td) throws Exception
		{
            System.out.println("clientId" + id);
			try {
				 Destination destination = new Destination();
				 destination.setClientId(id);
				 destination.setLocationName(ln);
				 destination.setLocationCountry(lc);
				 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
				 java.util.Date date = simpleDateFormat.parse(td);
				 destination.setTravelTime(new Timestamp(date.getTime()));
				 destination.setUpdatedBy("PREM");
				 clientService.createDestination(destination);
			} catch (Exception e) {
				System.err.println(e);
				throw e;
			}
		}
		
		
		@RequestMapping(value = "/locationId/{id}/lname/{ln}/country/{lc}/travDate/{td}", method = RequestMethod.POST)
		public Destination updateDestination(@PathVariable int id, @PathVariable String ln,@PathVariable String lc, @PathVariable String td) throws Exception
		{
            System.out.println("locationId: " + id);
			try {
				 
				 Destination destination = clientService.getDestination(id);
				 destination.setLocationName(ln);
				 destination.setLocationCountry(lc);
				 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
				 java.util.Date date = simpleDateFormat.parse(td);
				 destination.setTravelTime(new Timestamp(date.getTime()));
				 destination.setUpdatedBy("PREM");
				 
				 return clientService.updateDestination(destination);
			} catch (Exception e) {
				System.err.println(e);
				throw e;
			}
		}
		
		@RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
		public Destination retrieveDestination(@PathVariable int id) throws Exception
		{
            System.out.println("location" + id);
			try {

				 return clientService.getDestination(id);
			} catch (Exception e) {
				System.err.println(e);
				throw e;
			}
		}
		
		
		
		@RequestMapping(value = "/Destination/ClientId/{id}", method = RequestMethod.GET)
		public List<Destination> getDestinations(@PathVariable int id) throws Exception
		{
            System.out.println("ClientId" + id);
			try {

				 return clientService.getUserDestinations(id);
			} catch (Exception e) {
				System.err.println(e);
				throw e;
			}
		}
		
		
		

}
