package es.uniovi.asw.steps;

import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

public class AterrizajeSteps {
  
  @Cuando("^el cliente invoca /$")
  public void el_cliente_invoca() throws Throwable {
    System.out.println("Cliente invoca /");
  }

  @Entonces("^el cliente recibe (\\d+)$")
  public void el_cliente_recibe(int arg1) throws Throwable {
    System.out.println("Cliente recibe " + arg1);
  }

  @Entonces("^una cadena que contiene \"([^\"]*)\"$")
  public void una_cadena_que_contiene(String arg1) throws Throwable {
    System.out.println("Verificando que contiene " + arg1);
  }
}
