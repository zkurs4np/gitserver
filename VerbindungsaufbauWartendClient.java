
/**
 * Der Zustand VerbindungsaufbauwartendClient gilt bevor die TCP-Verbindung hergestellt ist, 
 * der bestätigte Verbundungsaufbau aber auf die Bestätigung wartet.
 * <p>
 * Es können in diesem Zustand folgende Methoden ausgeführt werden: <p>
 * 
 * Client:
 * <ul>
 * <li> VerbindungsaufbauCONF
 * </ul>
 * <p>
 * Es gibt nur eine Instanz dieser Klasse, die mit dem Singelton-Pattern verwaltet wird.
 * 
 * @author LK
 * @version 2021-11-17
 */
public class VerbindungsaufbauWartendClient extends ChatAnwendungsschichtZustand
{
    private static VerbindungsaufbauWartendClient singelton;
    
    // Klassenmethode
    /**
     * Gibt das Singelton zurück. Ein Singelton wird beim ersten Aufruf erzeugt.
     * @return Singelton
     */
    public static  VerbindungsaufbauWartendClient getSingelton(){
        if (singelton == null){
            singelton = new VerbindungsaufbauWartendClient();
        }
        return singelton;
    }
    // Instanzvariablen     
    // keine

    /**
     * Konstruktor für Objekte der Klasse Unverbunden
     */
    private VerbindungsaufbauWartendClient()
    {
        super("VerbindungsaufbauWartendClient"); // Aufruf des Konstruktors der ChatAnwendungsschichtZustand-Klasse
                              // Der Aufruf der Konstruktormethode des Oberklasse muss in der ersten Zeile des Konstruktors stehen.
    }
    
    /**
     * VerbindungsaufbauCONF
     */
    public  synchronized void VerbindungsaufbauCONF(ChatAnwendungsschicht kontext,ICI ici,SDU sdu) throws Exception
    {
        kontext.nextState(ici,VerbundenClient.getSingelton());
        kontext.VerbindungsaufbauCONFDO(ici,sdu);
        System.out.println("Client: VerbindungsaufbauwartendCient -> VerbundenClient");
    }
}
