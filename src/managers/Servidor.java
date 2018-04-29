package managers;


/**
 *
 * @author Slaush
 */

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONObject;

import java.net.URISyntaxException;





/**
 * Created by Slaush on 22/05/2016.
 */

public class Servidor
{

    final static int ESPERA_ENTRE_CONEXIONES = 1000;
    final static int INTENTOS_CONEXION = 20;
    final static String PUERTO = "1234";

    static public String URL;
    static Socket socket;
    
    static public String roomActual;
    static public int jugadorn;

    public static String getURLServidor()
    {
        return URL;
    }
    
    public static void setRoom(String room)
    {
        roomActual = room;
    }
    
    public static void setJugador(int n)
    {
        jugadorn = n;
    }
    

    public static void anadirEventoRecibidoAlSocket(String nombreEvento, Emitter.Listener listener)
    {
        socket.on(nombreEvento, listener);
    }

    public static void enviarEvento(String nombreEvento, JSONObject objetoJSON)
    {
        socket.emit(nombreEvento, objetoJSON);
    }

    public static void start()
    {
        roomActual = "";
        jugadorn = -1;
        String numero = "100";
        String prueba = "http://192.168.0."+numero+":"+PUERTO;
        IO.Options opts = new IO.Options();
        opts.forceNew = true;
        opts.reconnection = true;

        for (int i=0;i<=INTENTOS_CONEXION ; i++)
        {

            if(i>10)
                numero = "1"+i;
            else
                numero = "10"+i;

            prueba = "http://192.168.0."+numero+":"+PUERTO;

            try
            {
                socket = IO.socket(prueba, opts);
                socket.connect();
                anadirEventosSocket();
                esperar(ESPERA_ENTRE_CONEXIONES);
                if(socket.connected())
                {
                    URL = prueba;
                    break;
                }
            }
            catch (URISyntaxException e)
            {

            }
        }
    }

    private static void anadirEventosSocket()
    {

        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener()
        {
            
            public void call(Object... args)
            {
                System.out.println("CONECTADO!");
            }
        });

        socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener()
        {
           
            public void call(Object... args) 
            {
            }
        });
        
        socket.on("unirse partida",onUnirseRoom);
    }

    private static void esperar(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException e)
        {

        }
    }
    
    public static void crearPartida(String nombre)
    {
        JSONObject obj = new JSONObject();
        obj.put("room", nombre);
        enviarEvento("crear partida",obj);
        roomActual = nombre;
        jugadorn = 1;
    }
    
    public static void unirsePartida(String room, String jugador)
    {
        JSONObject obj = new JSONObject();
        obj.put("room",room);
        obj.put("personaje",jugador);
        enviarEvento("unirse partida",obj);
    }
    
    private static final Runnable runnableConeccion = new Runnable() {

        
        public void run() 
        {
            String numero = "100";
            String prueba = "http://192.168.0."+numero+":"+PUERTO;
            IO.Options opts = new IO.Options();
            opts.forceNew = true;
            opts.reconnection = true;

        for (int i=0;i<=INTENTOS_CONEXION ; i++)
        {

            if(i>10)
                numero = "1"+i;
            else
                numero = "10"+i;

            prueba = "http://192.168.0."+numero+":"+PUERTO;

            try
            {
                socket = IO.socket(prueba, opts);
                socket.connect();
                anadirEventosSocket();
                esperar(ESPERA_ENTRE_CONEXIONES);
                if(socket.connected())
                {
                    URL = prueba;
                    break;
                }
            }
            catch (URISyntaxException e)
            {

            }

        }
        }
    };
    
    static private Emitter.Listener onUnirseRoom = new Emitter.Listener() 
    {

        
        public void call(Object... os) 
        {
            JSONObject obj = (JSONObject) os[0];
            jugadorn =  obj.getInt("jugador");
            roomActual = obj.getString("room");       
        }
    };
    
    static public boolean isConnected()
    {
        if(socket != null)
            return socket.connected();
        else
            return false;
    }
}
