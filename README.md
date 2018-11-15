# Progetto-1-PR2
questo è il 1° progetto anno 2018/2019 di PR2:
PROGRAMMAZIONE II  - A. A. 2018 – 19 
Primo Progetto 
Il progetto ha l’obiettivo di applicare i concetti e le tecniche di programmazione Object-Oriented esaminate 
durante il corso. Lo scopo del progetto è lo sviluppo di un componente software di supporto alla gestione di 
insiemi di dati.  
Si richiede di progettare, realizzare e documentare la collezione SecureDataContainer<E>. 
SecureDataContainer<E> è un contenitore di oggetti di tipo E. Intuitivamente la collezione si comporta come 
una specie Data Storage per la memorizzazione e condivisione di dati (rappresentati nella simulazione da 
oggetti di tipo E).  La collezione deve garantire un meccanismo di sicurezza dei dati fornendo un proprio 
meccanismo di gestione delle identità degli utenti. Inoltre, la collezione deve fornire un meccanismo di 
controllo degli accessi che permette al proprietario del dato di eseguire una restrizione selettiva 
dell'accesso ai suoi dati inseriti nella collezione. Alcuni utenti possono essere autorizzati dal proprietario 
ad accedere ai dati, mentre altri non possono accedervi senza autorizzazione.  

 

Di seguito si riporta la struttura della Java interface di riferimento per la collezione 
public interface SecureDataContainer<E>{ 
// Crea l’identità un nuovo utente della collezione 
public void createUser(String Id, String passw);\ 
// Rimuove l’utente dalla collezione 
public void RemoveUser(String Id, String passw); 
// Restituisce il numero degli elementi di un utente presenti nella  
// collezione 
public int getSize(String Owner, String passw); 
// Inserisce il valore del dato nella collezione 
// se vengono rispettati i controlli di identità 
 public boolean put(String Owner, String passw, E data); 
// Ottiene una copia del valore del dato nella collezione 
// se vengono rispettati i controlli di identità 
 public E get(String Owner, String passw, E data); 
// Rimuove il dato nella collezione 
// se vengono rispettati i controlli di identità 
 public E remove(String Owner, String passw, E data); 
// Crea una copia del  dato nella collezione 
// se vengono rispettati i controlli di identità 
 public void copy(String Owner, String passw, E data); 
// Condivide il dato nella collezione con un altro utente 
// se vengono rispettati i controlli di identità 


 2 

 public void share(String Owner, String passw, String Other, E data); 
 
// restituisce un iteratore (senza remove) che genera tutti i dati  
// dell’utente in ordine arbitrario 
// se vengono rispettati i controlli di identità 
public Iterator<E> getIterator(String Owner, String passw); 
 
// … altre operazione da definire a scelta 
} 
1. Si definisca la specifica completa come interfaccia Java del tipo di dato SecureDataContainer<E> , 
fornendo le motivazioni delle scelte effettuate. 
2. Si definisca l’implementazione del tipo di SecureDataContainer<E> fornendo almeno due 
implementazioni basate su differenti strutture di supporto. In entrambi i casi si devono comunque 
descrivere sia la funzione di astrazione sia l’invariante di rappresentazione. Si discutano le 
caratteristiche delle due implementazioni proposte. 
Parte 2 
Per valutare il comportamento dell’implementazioni proposte si realizzi una batteria di test in grado di 
operare, senza modifiche specifiche, su entrambe le implementazioni proposte. 
Opzionale: utilizzare un meccanismo di cifratura per i dati presenti all’interno della collezione. 
Modalità di consegna  
• Il progetto deve essere svolto e discusso col docente individualmente. Il confronto con colleghi 
mirante a valutare soluzioni alternative durante la fase di progetto è incoraggiato. 
• Il progetto deve essere costituito da 
o i file sorgente contenenti il codice sviluppato e la batteria di test, ove tutto il codice deve 
essere adeguatamente commentato; 
o una relazione di massimo due pagine, che descrive le principali scelte progettuali ed 
eventuali istruzioni per eseguire il codice. 
• La consegna va fatta inviando per email al Prof. Ferrari o alla Prof. ssa Levi con oggetto “[PR2A] 
Consegna Progetto Intermedio 1”  e“[PR2B] Consegna Progetto Intermedio 1”, rispettivamente . 
• Il progetto deve essere consegnato entro il 3 Dicembre 2018. 
Altre informazioni  
• Per quanto riguarda il progetto, i docenti risponderanno solo a eventuali domande riguardanti 
l’interpretazione del testo, e non commenteranno soluzioni parziali prima della consegna. 
