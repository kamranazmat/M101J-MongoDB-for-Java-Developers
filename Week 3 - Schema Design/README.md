# Week 2: Schema Design  

Application-Driven Schema:  
In MongoDB it's more important to keep the data in a way that's conductive to the application using the data.  

Basic facts:  
- MongoDB supports "Rich Documents"  
- Pre-join data for fast access  
- No Mongo joins  
- There are no constraints  
- Atomic operations (but no transactions)  
- No declared Schema (may have pretty similar structure)  

What's the single most important factor in designing your application schema within MongoDB?  
- Matching the data access patterns of the application  

Embedding is a good option as there is no guarantee that the collections are linked properly together.  

Well, atomic operations mean that when you work on a single document and that work will be completed before anyone else sees the document.  
There are three different approaches that can be taken to overcome a lack of transactions:  
- restructure: restructure the code so that you are working within a single document and taking advantage of the atomic operations that we offer within that document.  
- implement some sort of locking in software (creating critical section, use semaphores)  
- tolerate: tolerate a little bit of inconsistency  

One-to-on relations:  
What's a good reason you might want to keep two documents that are related to each other one-to-one in separate collections?  
- to reduce the working set size of the application  
- because the combined size of the documents would be larger than 16MB  

One-to-many relations:  
- true linking  
If it's true one-to-many then two collections works best with linking. And if it's just one to few, well, then you could probably get away with a single collection.  

Many-to-many relations  

One of the reasons that linking and embedding works so well within MongoDB is because of the existence of a feature called **multikey** indexes.  
```sh
> db.students.find()
{"_id" : 0, "name": "Andrew Erlichson", "teachers": [0, 1]}
{"_id" : 1, "name": "Richard Kreuter", "teachers": [0, 1, 3]}
{"_id" : 1, "name": "Eliot Horowitz", "teachers": [1, 2, 3]}
{"_id" : 1, "name": "Mark Heinrich", "teachers": [0, 3]}
> db.teachers.find()
{"_id" : 0, "name": "Mark Horowitz"}
{"_id" : 1, "name": "John Hennessy"}
{"_id" : 2, "name": "Bruce Wolley"}
{"_id" : 3, "name": "James Plummer"}
```  
To add multikey index on the teachers key, we do the following:  
```sh
> db.students.ensureIndex({"teachers": 1})
```  

Benefits of Embedding:  
- Improved "read performance"
- One round trip to the DB  

One classic problem from the world of schema design is how do you represent a tree inside the database !!  
- one solution that works well is listing all the ancestors in order (in an array)  

When to denormalize ?[will most of the time depend upon the access patter and performance]  
(keeping in mind: As long as we don't duplicate data, we don't open ourselves up to modification anomalies)  
- 1:1 -- embed
- 1:many -- embed (many to one)
- many:many -- link

What is ODM ?  
- Object Document Mapper
- ODM sits between the application code and the driver so that you tell the ODM how to handle your classes. You just hand off your objects to the ODM and then the ODM speaks to the driver.  

Morphia: The Java Object Document Mapper for MongoDB  
