package ServerPackage;

import ClientPackage.Calculatrice;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String [] args)
    {
        try {

            // creation de ServerSocket qui écoute sur le port 1234
            ServerSocket ssk = new ServerSocket(1234);

            // Attends qu'un client se connecte et accepte la connexion
            Socket sk = ssk.accept();

            // flux d'entrée pour recevoir des objets du client
            ObjectInputStream ois = new ObjectInputStream(sk.getInputStream());

            // Lire l'objet Calculatrice envoyé par le client
            Calculatrice cal = (Calculatrice)ois.readObject();

            // Récupèrer les valeurs de l'objet Calculatrice
            int ent1=cal.getEnt1();
            int ent2=cal.getEnt2();
            String oper=cal.getOper();

            int res=0;
            switch (oper) {
                case "+":
                    res = ent1 + ent2;
                    break;
                case "-":
                    res = ent1 - ent2;
                    break;
                case "*":
                    res = ent1 * ent2;
                    break;
                case "/":
                    res = ent1 / ent2;
                    break;

            }
            
            // Met à jour le résultat dans l'objet Calculatrice
            cal.setRes(res);
            // flux de sortie pour envoyer l'objet Calculatrice avec le résultat au client
            ObjectOutputStream oos = new ObjectOutputStream(sk.getOutputStream());
            oos.writeObject(cal);

            sk.close();
            ssk.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }



    }

}
