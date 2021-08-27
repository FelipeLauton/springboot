package br.com.stefanini.twodatabases.configuration;

import org.bson.Document;

import br.com.stefanini.twodatabases.model.UsersEvent;

public class UsersAdapter {

	public static Document toDocument(UsersEvent event) {
		Document doc = new Document();
		doc.append("code", event.getCode());
		doc.append("event", event.getEvent());
		doc.append("status", event.getStatus());
		doc.append("users", event.getUsers());
		return doc;
	}
	
	public static Document toDocumentUpdate(UsersEvent event) {
		Document doc = new Document();
		doc.append("_id", event.getId());
		doc.append("code", event.getCode());
		doc.append("event", event.getEvent());
		doc.append("status", event.getStatus());
		doc.append("users", event.getUsers());
		return doc;
	}
	
	public static UsersEvent getObjects(Document doc) {
		UsersEvent users = new UsersEvent(doc.get("_id"),
				doc.getString("code"),
				doc.getString("event"),
				doc.getString("status"),
				doc.getString("users")); 
		
		
		return users;
	}
}
