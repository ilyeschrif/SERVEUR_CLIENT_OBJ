package ClientPackage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

public static void main(String [] args)
{

try{
     //connexion au serveur en utilisant "localhost" et le port 1234
     Socket sk = new Socket("localhost",1234);

     // flux de sortie pour envoyer des objets au serveur
     ObjectOutputStream out = new ObjectOutputStream(sk.getOutputStream());

     // saisie de l'utilisateur
     Scanner sc = new Scanner(System.in);
     System.out.println("donner ent1: ");
     int ent1=sc.nextInt();
     sc.nextLine();
     System.out.println("donner oper: ");
     String oper=sc.nextLine();

     System.out.println("donner ent2:");
     int ent2=sc.nextInt();

    // objet Calculatrice avec les valeurs saisies
    Calculatrice cal = new Calculatrice(ent1,oper,ent2);

     // Envoie de l'objet Calculatrice au serveur
     out.writeObject(cal);

    // flux d'entrée pour recevoir des objets du serveur
    ObjectInputStream ios = new ObjectInputStream(sk.getInputStream());

    //l'affiche de résultat renvoyé par le serveur
    System.out.println("\nresultat : "+((Calculatrice)ios.readObject()).getRes());

    // Fermeture de flux de sortie et le socket client
    out.close();
    sk.close();
}
catch(Exception e)
{
    System.out.println(e.getMessage());
}



}



}
