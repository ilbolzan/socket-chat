import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws Exception
    {
        String mensagemRecebida = "";
        String mendagemEnviada = "Obrigado!" + '\n';
        ServerSocket serverSocket = new ServerSocket(6789);
        
        Socket meuSocket = null;


        while(mensagemRecebida != "FIM") {
            // if(meuSocket == null || !meuSocket.isConnected())
            // {
                meuSocket = serverSocket.accept();
            // }
            mensagemRecebida = ReadMessage(meuSocket);
            WriteMessage(meuSocket, mensagemRecebida);
        }
        
        serverSocket.close();
    }

    /**
     * Writes the message to all other clients
     */
	private static void WriteMessage(Socket meuSocket, String message) throws IOException {
        DataOutputStream saida = new DataOutputStream(meuSocket.getOutputStream());
        saida.writeBytes(message);
	}

	private static String ReadMessage(Socket meuSocket) throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(meuSocket.getInputStream()));
		return entrada.readLine();
	}
}