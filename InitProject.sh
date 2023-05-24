#Marco Jose Munguia Alva 201931804

#Instalamos la  biblioteca de graficacion de diagramas ER
sudo apt-get install graphviz

#Instalamos maven que sera el encargado de crear nuestro .jar junto con sus dependencias
sudo apt-get install maven

#Compilamos con Maven para crear nuesto archivo .jar
mvn clean package

#Movemos el .jar a nuestro directorio actual
mv target/MyDBMS-1.0-SNAPSHOT-jar-with-dependencies.jar ./

#Iniciamos el programa
java -jar MyDBMS-1.0-SNAPSHOT-jar-with-dependencies.jar

#Borramos el .jar y el ER creado para dejar limpio el proyecto
sudo rm MyDBMS-1.0-SNAPSHOT-jar-with-dependencies.jar

sudo rm dbDiagram.png

