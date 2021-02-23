package com.losdesiempre.mypocketeam;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

public class ConnectMongo {
    public static void main(String arg[]){
        //MongoClient client = MongoClients.create("mongodb+srv://dbUser:admin@cluster0.ghsm9.mongodb.net/<dbname>?retryWrites=true&w=majority");
        //MongoDatabase database = client.getDatabase("mypocketeam");

        //Creating a MongoDB client
        MongoClient mongo = MongoClients.create("mongodb://127.0.0.1:27017/");
        //Connecting to the database
        MongoDatabase database = mongo.getDatabase("test");
        //Creating a collection object
        MongoCollection<Document> collection = database.getCollection("teams");
        //Retrieving the documents
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
