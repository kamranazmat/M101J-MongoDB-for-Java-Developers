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
