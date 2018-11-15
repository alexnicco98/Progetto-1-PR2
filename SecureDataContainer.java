package progetto;

import java.util.Vector;

public class SecureDataContainer<E> implements InterfSecureDataContainer {

    private Vector<Vector<E>> Vecdata;// vettore di vettori contenenti i dati e corrispondendi ad un id
    private Vector<String> VecId;     //sono salvate nella collezione vector
    private Vector<String> Vecpassw;  //sono salvate nella collezione vector, dove ogni passw
                                   //corrisponde ad un Id (hanno lo stesso indice)
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

    // Crea l’identità un nuovo utente della collezione
    public void createUser(String Id, String passw)throws NullPointerException {
        if (Id==null||passw==null)throw new NullPointerException();
        VecId.addElement(Id);
        Vecpassw.addElement(passw);
        Vecdata.ensureCapacity(VecId.capacity());
    }

    // Rimuove l’utente dalla collezione
    public void RemoveUser(String Id, String passw)throws  NullPointerException{
        if (Id==null||passw==null)throw new NullPointerException();
        VecId.removeElement(Id);
        Vecdata.removeElementAt(Vecpassw.indexOf(passw));
        Vecpassw.removeElement(passw);
    }


}


