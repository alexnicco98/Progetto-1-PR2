package progetto;

import java.util.Vector;

public class SecureDataContainer<E> implements InterfSecureDataContainer {

    private Vector<Vector<E>> Vecdata;// vettore di vettori contenenti i dati
                                      // corrispondendi ad un id
    private Vector<String> VecId;     //vettore di User
    private Vector<String> Vecpassw;  //Vettore di password
                                      //ogni password corrisponde ad un Id (hanno lo stesso indice)
    public SecureDataContainer(){
        VecId = new Vector<String>(1);
        Vecpassw = new Vector<String>(1);
        Vecdata = new Vector<Vector<E>>(1);
    }

    //Da come risultato true se Id è gia presente, false altrimenti
    public boolean UserDuplicate(String Id){
        if(VecId.contains(Id)==true) return true;
        else return false;
    }

    //stampo gli indice del user e della password se corrispondono
    public  void getIndex(String Id,String passw)throws NullPointerException{
        if (Id == null || passw == null) throw new NullPointerException();
        int i = VecId.indexOf(Id);
        System.out.println(i);
        System.out.println(Vecpassw.indexOf(passw,i));
    }
    // Crea l’identità un nuovo utente della collezione
    public void createUser(String Id, String passw)throws NullPointerException {
        if (Id == null || passw == null) throw new NullPointerException();
        VecId.addElement(Id);
        Vecpassw.addElement(passw);
        Vecdata.addElement(new Vector<E>(1)); //inizializzo il vettore di dati di tipo E
        System.out.println("Utente creato con successo");
    }


    // Rimuove l’utente dalla collezione
    public void RemoveUser(String Id, String passw)throws  NullPointerException{
        if (Id==null||passw==null)throw new NullPointerException();
        int i = VecId.indexOf(Id);
        if(i==Vecpassw.indexOf(passw,i)) { //controllo se la password corrisponde all'id
            Vecpassw.remove(i);
            Vecpassw.trimToSize();
            VecId.remove(i);
            VecId.trimToSize();
            Vecdata.remove(i);
            Vecdata.trimToSize();
            System.out.println("Utente rimmosso con successo");
        }
        else
            System.out.println("Password o User sbagliati");
    }

    // Restituisce il numero degli elementi di un utente presenti nella
    // collezione
    public int getSize(String Owner, String passw)throws NullPointerException{
        if (Owner==null||passw==null)throw new NullPointerException();
        int i = VecId.indexOf(Owner);
        if(i==Vecpassw.indexOf(passw,i)) {  //controllo se la password corrisponde all'id
            Vector aux = Vecdata.elementAt(i);
            return aux.size();              //numero di elementi di tipo E
        }
        else
            System.out.println("Password o User sbagliati");
        return  -1;
    }


}

