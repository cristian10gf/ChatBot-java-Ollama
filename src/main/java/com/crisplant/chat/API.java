package com.crisplant.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class API {
    /**
     * Sends a message to the API and retrieves the response.
     *
     * @param modelo The model to be used for generating the response.
     * @param promtText The prompt text to be sent to the API.
     * @return The response from the API as a String.
     * @throws ProtocolException If there is an error in the HTTP protocol.
     * @throws IOException If an I/O exception occurs.
     * @throws URISyntaxException If the URL is not formatted correctly.
     */
    public static String sendMessageAPI(String modelo, String promtText) throws ProtocolException, IOException, URISyntaxException {
       
        URL url = new URI("http://localhost:11434/api/generate").toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);
        
        String jsonInputString = "{ \"model\": \"" + modelo + "\", \"prompt\": \"" + promtText + "\", \"stream\": false}";

        // Write the JSON body to the request
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input,0, input.length);
        }

        System.out.println("Response Code: " + conn.getResponseCode());
        
        StringBuilder response;
        try ( BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) response.append(line);
        }

        return obtenerCampo(response.toString(), "response");
    }

    public static String sendMessageAPI(String promtText) throws ProtocolException, IOException, URISyntaxException {
        return sendMessageAPI("llama3.2", promtText);
    }

    private static String obtenerCampo(String json, String campo) {
        String clave = "\"" + campo + "\":";
        int inicio = json.indexOf(clave);
        if (inicio == -1) return null; // El campo no se encuentra

        inicio += clave.length(); // Mover el inicio al valor del campo
        int fin = inicio;
        boolean dentroDeComillas = false;

        while (fin < json.length()) {
            char actual = json.charAt(fin);
            if (actual == '\"') dentroDeComillas = !dentroDeComillas; // Cambiar el estado si encontramos una comilla

            // Si estamos fuera de comillas y encontramos una coma o un cierre de llave
            if (!dentroDeComillas && (actual == ',' || actual == '}')) break; // Salimos del bucle
            fin++;
        }

        String valor = json.substring(inicio, fin).trim();
        if (valor.startsWith("\"") && valor.endsWith("\"")) valor = valor.substring(1, valor.length() - 1); // Eliminar las comillas si es un string
        return valor;
    }
    
    /**
     * Verifica el estado de la API enviando un mensaje y midiendo el tiempo de respuesta.
     *
     * @param promtText El texto del mensaje que se enviará a la API.
     * @return Una cadena que indica el resultado de la verificación:
     *         - "Exitoso: " seguido de la respuesta de la API si la operación fue exitosa.
     *         - "Error: No se pudo obtener la respuesta" si la respuesta es nula.
     *         - "Error: Respuesta vacía" si la respuesta está vacía.
     *         - "Error: Tiempo de respuesta excedido" si el tiempo de respuesta supera los 5000 ms.
     *         - "Error de Protocolo: " seguido del mensaje de la excepción si ocurre un ProtocolException.
     *         - "Error de IO: " seguido del mensaje de la excepción si ocurre un IOException.
     *         - "Error de URI: " seguido del mensaje de la excepción si ocurre un URISyntaxException.
     *         - "Error desconocido: " seguido del mensaje de la excepción si ocurre cualquier otra excepción.
     */
    public static String verificarEstadoAPI(String promtText) {
        try {
            double inicio = System.currentTimeMillis();
            String respuesta = sendMessageAPI(promtText);
            double fin = System.currentTimeMillis();

            if (respuesta == null) return "Error: No se pudo obtener la respuesta";
            if (respuesta.isEmpty()) return "Error: Respuesta vacía";
            if (fin-inicio > 5000) return "Error: Tiempo de respuesta excedido";
            
            return "Exitoso: " + respuesta;
        } catch (ProtocolException e) {
            return "Error de Protocolo: " + e.getMessage();
        } catch (IOException e) {
            return "Error de IO: " + e.getMessage();
        } catch (URISyntaxException e) {
            return "Error de URI: " + e.getMessage();
        } catch (Exception e) {
            return "Error desconocido: " + e.getMessage();
        }
    }
}