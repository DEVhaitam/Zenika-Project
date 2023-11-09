# Zenika-Project

Before running the project you have to pay attention to the application.properties file
- If you want to run it on localhost keep : spring.datasource.url=jdbc:mysql://localhost:3306/mydb
- If you want to run it on Docker switch to : spring.datasource.url=jdbc:mysql://mysql-db:3306/mydb

## Endpoints:
- http://localhost:8091/salles/disponibles: to get all the available rooms
- http://localhost:8091/salles/disponibles/nbrePersonnes?nbrePersonnes={nbre}: to get the available rooms by the number of persons
- http://localhost:8091/salles/disponibles/reunion?reunion={typeReunion}: to get the available rooms by type of meeting
- http://localhost:8091/salles/nbrePersonnes/{nbre}: to get all the rooms by the number of persons (not necessarily available)
- http://localhost:8091/salles/typeReunion/{typeReunion}: to get all the rooms by the type of meeting (not necessarily available)
- http://localhost:8091/salles/reservation?nomSalle={nomSalle}: to book a room
- http://localhost:8091/salles/liberation?nomSalle={nomSalle}: to free up a room

  ## When starting the app:
  1. Go to http://localhost:8080/
  2. Connect to phpmyadmin with credentials (myuser, mypassword)
  3. Select the tables one after another
  4. Go to import and import files in data respectively for table reunions and salles
  5. **PS: don't forget to check the 1st option in the Format-specific options section**
  6. Data imported successfully
 
  ## Easy way to go:
  go to the app folder and run: **docker-compose up**
