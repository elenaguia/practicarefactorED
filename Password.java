package seguridad;

//Félix Carrasco Andrés
public class Password {

	//Constantes
	  
    /**
     * Longitud por defecto
     */
    private final static int LONG_DEF=8;
  
    //Atributos
  
    /**
     * Longitud de la contraseÃ±a
     */
    private int longitudcontrasenya;
    /**
     * caracteres de la contraseÃ±a
     */
    private String contrasenya;
  
    //Metodos publicos
  
    /**
     * Devuelve la longitud
     * @return longitud de la contraseÃ±a
     */
    public int getLongitud() {
        return longitudcontrasenya;
    }
  
    /**
     * Modifica la longitud de la contraseÃ±a
     * @param longitud a cambiar
     */
    public void setLongitud(int longitud) {
        this.longitudcontrasenya = longitud;
    }
  
    /**
     * Devuelve la contraseÃ±a
     * @return contraseÃ±a
     */
    public String getContrasena() {
        return contrasenya;
    }
  
    /**
     * Genera una contraseÃ±a al azar con la longitud que este definida
     * @return contraseÃ±a
     */
    public String generaPassword (){
        String password="";
        for (int i=0;i<longitudcontrasenya;i++){
            //Generamos un numero aleatorio, segun este elige si aÃ±adir una minuscula, mayuscula o numero
            int eleccion=((int)Math.floor(Math.random()*3+1));
  
            if (eleccion==1){
          this.generarMinuscula(password);
            }else{
                if(eleccion==2){
                	this.generarMayuscula(password);
                }else{
                   this.generarNumero(password);
                }
            }
        }
        return password;
    }
  
    /**
     * Comprueba la fortaleza de la contraseÃ±a
     * @return
     */
    public boolean esFuerte(){
        int cuentanumeros=0;
        int cuentaminusculas=0;
        int cuentamayusculas=0;
        //Vamos caracter a caracter y comprobamos que tipo de caracter es
        for (int i=0;i<contrasenya.length();i++){
                if (contrasenya.charAt(i)>=97 && contrasenya.charAt(i)<=122){
                    cuentaminusculas+=1;
                }else{
                    if (contrasenya.charAt(i)>=65 && contrasenya.charAt(i)<=90){
                        cuentamayusculas+=1;
                }else{
                    cuentanumeros+=1;
                    }
                }
            }
            //Si la constraseÃ±a tiene mas de 5 numeros, mas de 1 minuscula y mas de 2 mayusculas
            if (cuentanumeros>=5 && cuentaminusculas>=1 && cuentamayusculas>=2){
            return true;
        }else{
            return false;
        }
    }
  
    //Constructores
    /**
     * Crea una contraseÃ±a al azar
     */
    public Password (){
        this(LONG_DEF);
    }
  
    /**
     * La contrasena sera la pasada por parametro
     * @param longitud
     */
    public Password (int longitud){
        this.longitudcontrasenya=longitud;
        contrasenya=generaPassword();
    }
    public void generarMinuscula(String password) 
    {
        char minusculas=(char)((int)Math.floor(Math.random()*(123-97)+97));
        password+=minusculas;
    }
    public void generarMayuscula(String password) 
    {
    	char mayusculas=(char)((int)Math.floor(Math.random()*(91-65)+65));
        password+=mayusculas;
    }
    public void generarNumero(String password) 
    {
        char numeros=(char)((int)Math.floor(Math.random()*(58-48)+48));
        password+=numeros;
    }

}
