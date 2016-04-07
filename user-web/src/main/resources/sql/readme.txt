
//start hsqldb by execute below command
java -cp ../lib/hsqldb.jar org.hsqldb.Server -database.0 testdb -dbname.0 testdbname

//start hsql manager
java -cp ..\lib\hsqldb.jar org.hsqldb.util.DatabaseManager -url jdbc:hsqldb:hsql://localhost/testdbname
