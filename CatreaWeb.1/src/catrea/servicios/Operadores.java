package catrea.servicios;

import java.security.SecureRandom;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import catrea.accesodatos.AspirantesDAO;
import catrea.accesodatos.OperadoresDAO;
import catrea.accesodatos.PreinscripcionesDAO;
import catrea.bo.Operador;
import catrea.excepcion.BaseDeDatosException;
import catrea.excepcion.OperadorExistenteException;
import catrea.excepcion.ServicioException;

public class Operadores {
	
	private OperadoresDAO dao = null;
	private final static String CATREA_WEB_MAIL = "catreaweb@gmail.com";
	private final static String CATREA_WEB_HOST = "smtp.gmail.com";
	private final static String CATREA_WEB_PASSWORD = "catreaPass";

	public Operadores() {
         dao = new OperadoresDAO();
	}
	
	public void altaOperador(Operador operador) throws ServicioException, OperadorExistenteException {
		try {
			if(dao.recuperarOperador(operador.getDni()) == null) {
				dao.altaOperador(operador);				
			} else 
				throw new OperadorExistenteException("Un operador con ese DNI ya existe en la Base de Datos");
		} catch (BaseDeDatosException e) {
			throw new ServicioException(e.getMessage());
		}
	}
	
	public List<Operador> recuperarOperadores() throws ServicioException {
		try {
			return dao.recuperarOperadores();
		} catch (BaseDeDatosException e) {
			throw new ServicioException(e.getMessage());
		}
	}
	
	public void bajaOperador(String dni) throws ServicioException {
		try {
            OperadoresDAO daoOperadores = new OperadoresDAO();
            daoOperadores.darDeBajaOperador(dni);
	    } catch (BaseDeDatosException e) {
	        throw new ServicioException(e.getMessage()) ;
	    }
	}
	
	public void actualizarPassword(String dni, String nuevoPassword) throws ServicioException {
		actualizarPasswordBaseDatos(dni, nuevoPassword);		
	}
	
	public void recuperarPassword(String dni) throws ServicioException {
		try {
			String toMail = dao.recuperarMailOperador(dni);
			if(toMail != null) {
				String nuevoPassword = passGenerator();
				actualizarPasswordBaseDatos(dni, nuevoPassword);
				enviarMail(toMail, nuevoPassword);
			}
		} catch(BaseDeDatosException e) {
			throw new ServicioException("Error de conexion");
		} catch(MessagingException e) {
			throw new ServicioException("Error en el envio de mails");
		}		
	}
	
    private int actualizarPasswordBaseDatos(String dni, String nuevoPassword) throws ServicioException{
        try{
            return dao.actualizarPasswordOperador(dni, nuevoPassword);
        }catch(BaseDeDatosException e) {
            throw new ServicioException(e.getMessage()) ;
        }    
    }
    
    private String passGenerator() {
		int length = 8;
		
	    final char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	    final char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
	    final char[] numbers = "0123456789".toCharArray();
	    final char[] symbols = "^$?!@#%&".toCharArray();
	    final char[] allAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789^$?!@#%&".toCharArray();

	    Random random = new SecureRandom();

	    StringBuilder password = new StringBuilder(); 

	    for (int i = 0; i < length-4; i++) {
	        password.append(allAllowed[random.nextInt(allAllowed.length)]);
	    }

	    password.insert(random.nextInt(password.length()), lowercase[random.nextInt(lowercase.length)]);
	    password.insert(random.nextInt(password.length()), uppercase[random.nextInt(uppercase.length)]);
	    password.insert(random.nextInt(password.length()), numbers[random.nextInt(numbers.length)]);
	    password.insert(random.nextInt(password.length()), symbols[random.nextInt(symbols.length)]);

	    return password.toString();
	}

    private void enviarMail(String toMail, String password) throws AddressException, MessagingException {
        String from = CATREA_WEB_MAIL;

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", CATREA_WEB_HOST);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CATREA_WEB_MAIL, CATREA_WEB_PASSWORD);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
        message.setSubject("Catrea Web");
        message.setText("Su nueva contraseña es: " + password);
        System.out.println("Enviando...");
        Transport.send(message);
        System.out.println("Mail enviado exitosamente a: " + toMail);
    }
}
