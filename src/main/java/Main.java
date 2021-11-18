import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){

        for (int i = 0; i<15; i++){
            Jugador J = new Jugador();
            J.setName("Jugador " +i);
            J.start();
        }
    }
}
class Jugador extends Thread{
    public void run(){
        System.out.println(getName()+" esta listo");
        try {
            mapa.addParticipante(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class mapa{
    private static final Semaphore semaphore = new Semaphore(10, false);

    public static void addParticipante(Jugador jugador) throws InterruptedException {
        semaphore.acquire();
        System.out.println(jugador.getName()+" ha entrado a la sala de espera");

    }
}
