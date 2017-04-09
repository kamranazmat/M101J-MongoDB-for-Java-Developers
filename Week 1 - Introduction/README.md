# Week 1: Introduction

Installing MongoDB for Windows  
Introduction to JSON  

Which of the following value types are defined by the JSON spec?
- Object - Yes
- Array - Yes
- Date
- String - Yes
- Integer
- Number - Yes

**MongoDB** represents *JSON* documents in binary-encoded format called *BSON* behind the scene.
BSON extends the JSON model to provide additional data types, ordered fields, and to be efficient for encoding and decoding within different languages.

#### CRUD
> Create  
> Read  
> Update  
> Delete  

The return value of `find` is not simply an array of documents. It's instead a cursor object.
```sh
> var c = db.movies.find()
> c.hasNext()
true
> c.next()
```

Installing and using **Maven**
```sh
$ mvn -v
$ mvn
$ mvn archetype:generate
.
Define value for property 'groupId': com.mongodb
Define value for property 'artifactId': M101J
.
.
$ cd M101J
```
Using: **IntelliJ IDEA**  
Intro to **FreeMarker Java Template Engine**   
Template File: **.ftl*  

| Template File | + | Java Objects | ---> **<FreeMarker>** ---> | Output |  

Spark Route:
- Jetty server  
- inside Jetty there is Spark Handler  
- within Spark Handler there are one or more routes  

Intro to Class Project - The Blog  
