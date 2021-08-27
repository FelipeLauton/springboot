package br.com.stefanini.twodatabases.database;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import br.com.stefanini.twodatabases.configuration.UsersAdapter;
import br.com.stefanini.twodatabases.model.UsersEvent;

public class UsersEventDao extends Dao {

	public static final String EVENTS = "events";

	public UsersEvent save(UsersEvent events) throws Exception {
		try {
			MongoCollection<Document> coll = getBd().getCollection(EVENTS);
			coll.insertOne(UsersAdapter.toDocument(events));
			return events;
		} catch (Exception ex) {
			return null;
		} finally {
			close();
		}
	}

	public List<UsersEvent> findAll() throws Exception {
		MongoCursor<Document> doc = null;
		List<UsersEvent> lista = new ArrayList<UsersEvent>();
		try {
			MongoCollection<Document> collection = getBd().getCollection(EVENTS);
			doc = collection.find().iterator();
			lista.clear();
			while (doc.hasNext()) {
				lista.add(UsersAdapter.getObjects(doc.next()));
			}
			return lista;
		} catch (Exception ex) {
			return null;
		} finally {
			close();
		}
	}
}
