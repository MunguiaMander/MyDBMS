#Marco Jose Munguia Alva 201931804

#Instalamos lo necesario
sudo apt-get install graphviz

#Compilamos con Maven para crear nuesto archivo .jar
mvn clean package

#Movemos el .jar a nuestro directorio actual
mv target/MyDBMS-1.0-SNAPSHOT-jar-with-dependencies.jar ./

#Iniciamos el programa
java -jar MyDBMS-1.0-SNAPSHOT-jar-with-dependencies.jar
