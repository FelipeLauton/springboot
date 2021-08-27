package br.com.stefanini.twodatabases.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Dao {

	public MongoClient client;
	
		public MongoClient getClient() {//modo antigo de trab com mongo
			client = new MongoClient();
			return client;
		}
		
		public MongoDatabase getBd()throws Exception{
			return getClient().getDatabase("bddois");
		}
		
		public void close() throws Exception{
			client.close();
		}
}
