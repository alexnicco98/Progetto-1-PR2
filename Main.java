package progetto;
import java.util.Scanner;

public class Main {
    //funzione per controllare che la password inserita rispetti le specifiche
    private static boolean trypassw(String passw){
        int n=passw.length(),conta=0;
        if(n<4||n>10){    //password più corta di 4 caratteri o più grande di 10
            System.out.println("password non valida,inserire" +
                    " password di lunghezza compresa tra 4 e 10 caratteri");
            return false;
        }
        for (int i= 0; i < n; i++)
            if (Character.isUpperCase(passw.charAt(i)))
                conta++;
        if (conta<1) {
            System.out.println("password non valida,inserire password " +
                    "contenente almeno 1 carattere maiuscolo");
            return false;
        }
        return  true;
    }

    //funzione per controllare che l'id inserito rispetti le specifiche
    private static boolean tryuser(String id){
        int n=id.length(),conta=0;
        if(n<4||n>10){    //user più corto di 4 caratteri o più grande di 10
            System.out.println("user non valido,inserire user di " +
                    "lunghezza compresa tra 4 e 10 caratteri");
            return false;
        }
        for (int i= 0; i < n; i++)
            if (Character.isDigit(id.charAt(i)))
                conta++;
        if (conta<2) {
            System.out.println("user non valido,inserire user contenente almeno 2 cifre");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String id,passw; //gli user e le password li devo gestire nel main oppure
                         // all'interno dei metodi di SecureDataConteiner?
        SecureDataContainer<Integer> Conteiner= new SecureDataContainer<Integer>();
        Scanner tastiera = new Scanner(System.in);
       /* System.out.println("Inserire id:");
        id = tastiera.nextLine();
        while(!tryuser(id)||Conteiner.UserDuplicate(id)) {
            System.out.println("Inserire id che rispetti le specifiche e che non sia già presente:");
            id = tastiera.nextLine();
        }
        System.out.println("Inserire password:");
        passw = tastiera.nextLine();
        while(!trypassw(passw)) {
            System.out.println("Inserire password che rispetti le specifiche:");
            passw = tastiera.nextLine();
        }*/
        id = "Anto98";
        passw = "Anto";
        Conteiner.createUser(id,passw);
        id = "Anto99";
        passw = "Anto";
        Conteiner.createUser(id,passw);
        Conteiner.RemoveUser(id,passw);
        //Conteiner.getIndex(id,passw);

        id = "Anto98";
        passw = "Anto";
        /*System.out.println("Inserire id:");
        id = tastiera.nextLine();
        System.out.println("Inserire password:");
        passw = tastiera.nextLine();*/
        int i = Conteiner.getSize(id,passw);
        if(i!=-1) {
            System.out.println("Elementi di tipo E dell'utente:");
            System.out.println(i);
        }
    }
}
