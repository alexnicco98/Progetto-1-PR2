package progetto;

import java.util.NoSuchElementException;
import java.util.Vector;

public class SecureDataContainer<E> implements InterfSecureDataContainer<E> {

    private Vector<Vector<E>> Vecdata;// vettore di vettori contenenti i dati
                                      // corrispondendi ad un id
    private Vector<String> VecId;     //vettore di User
    private Vector<String> Vecpassw;  //Vettore di password
    private E data;

    //ogni password corrisponde ad un Id (hanno lo stesso indice)
    public SecureDataContainer(){
        VecId = new Vector<String>(1);
        Vecpassw = new Vector<String>(1);
        Vecdata = new Vector<Vector<E>>(1);
    }

    //funzione che fa il controllo d'identità
    private boolean checkCredenziali(String Id,String passw){
        int i = VecId.indexOf(Id);
        if(i==Vecpassw.indexOf(passw,i))
            return true;
        return false;
    }

    //Da come risultato true se Id è gia presente, false altrimenti
    public boolean UserDuplicate(String Id){
        if(VecId.contains(Id)==true) return true;
        else return false;
    }

    //stampo gli indice del user e della password se corrispondono( NON NECESSARIA)
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
        if(checkCredenziali(Id,passw)) { //controllo se la password corrisponde all'id
            int i = VecId.indexOf(Id);
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
        if(checkCredenziali(Owner,passw)) {  //controllo se la password corrisponde all'id
            Vector aux = Vecdata.elementAt(VecId.indexOf(Owner));
            return aux.size();              //numero di elementi di tipo E
        }
        else
            System.out.println("Password o User sbagliati");
        return  -1;
    }

    // Inserisce il valore del dato nella collezione
    // se vengono rispettati i controlli di identità
    public boolean put(String Owner, String passw, E data)throws NullPointerException{
        if (Owner==null||passw==null||data==null)throw new NullPointerException();
        if(checkCredenziali(Owner,passw)) {
            Vector<E> aux = Vecdata.elementAt(VecId.indexOf(Owner)); //uso il vettore aux per inserire
            aux.addElement(data);                                    //elementi di tipo E
            System.out.println(Owner+" ha inserito: "+data);
            return true;
        }
        else
            System.out.println("Password o User sbagliati");
        return false;
    }

    // Ottiene una copia del valore del dato nella collezione
    // se vengono rispettati i controlli di identità
    public E get(String Owner, String passw, E data)throws NullPointerException, NoSuchElementException {
        if (Owner==null||passw==null||data==null)throw new NullPointerException();
        if(checkCredenziali(Owner,passw)) {
            Vector aux = Vecdata.elementAt(VecId.indexOf(Owner));
            if(!aux.contains(data))throw new NoSuchElementException("Dato non presente");
            int i = aux.indexOf(data);
            E el = (E) aux.get(i);
            return el;
        }
        else
            System.out.println("Password o User sbagliati");
        return data;  //non so cosa deve restituire se arriva qui
    }

    // Rimuove il dato nella collezione
    // se vengono rispettati i controlli di identità
    public E remove(String Owner, String passw, E data)throws NullPointerException, NoSuchElementException{
        if (Owner==null||passw==null||data==null)throw new NullPointerException();
        if(checkCredenziali(Owner,passw)) {
            Vector aux = Vecdata.elementAt(VecId.indexOf(Owner));
            if(!aux.contains(data))throw new NoSuchElementException("Dato non presente");
            aux.remove(data);
            aux.trimToSize();

        }
        else
            System.out.println("Password o User sbagliati");
        return data;
    }

    // Crea una copia del  dato nella collezione
    // se vengono rispettati i controlli di identità
    public void copy(String Owner, String passw, E data)throws NullPointerException, NoSuchElementException{
        if (Owner==null||passw==null||data==null)throw new NullPointerException();
        if(checkCredenziali(Owner,passw)) {
            Vector aux = Vecdata.elementAt(VecId.indexOf(Owner));
            if(!aux.contains(data))throw new NoSuchElementException("Dato non presente");
            System.out.println("Copia del dato "+data+" aggiunta nella collezione di "+Owner);
            aux.addElement(data);
        }
        else
            System.out.println("Password o User sbagliati");
    }

    // Condivide il dato nella collezione con un altro utente
    // se vengono rispettati i controlli di identità
    public void share(String Owner, String passw, String Other, E data)throws NullPointerException, NoSuchElementException{
        if (Owner==null||passw==null||data==null)throw new NullPointerException();
        if(checkCredenziali(Owner,passw)) {
            Vector aux = Vecdata.elementAt(VecId.indexOf(Owner));
            if(!aux.contains(data))throw new NoSuchElementException("Dato non presente");
            aux = Vecdata.elementAt(VecId.indexOf(Other));
            aux.addElement(data);
            System.out.println(Owner+" ha condiviso il dato "+data+" con "+Other);
        }
        else
            System.out.println("Password o User sbagliati");

    }

}

