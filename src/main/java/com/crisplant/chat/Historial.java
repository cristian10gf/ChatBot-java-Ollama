package com.crisplant.chat;

/**
 * The Historial class manages a chat history and the current chat session.
 * It provides methods to add, delete, and display chats and messages.
 */
public class Historial {

    /**
     * A 2D array to store the chat history. Each row represents a chat session,
     * and each column represents a message in that session.
     */
    public static String[][] historial = new String[100][30];

    /**
     * An array to store the current chat session.
     */
    public static String[] chatActual = new String[30];

    /**
     * Adds the current chat session to the chat history.
     * The current chat session is added to the first empty row in the history.
     */
    public static void addChat() {
        for (int i = 0; i < historial.length; i++) {
            if (historial[i][0] == null) {
                historial[i] = chatActual;
                break;
            }
        }
    }

    /**
     * Deletes a chat session from the chat history at the specified index.
     * The chat history is then reorganized to remove any gaps.
     *
     * @param index the index of the chat session to delete
     */
    public static void deleteChat(int index) {
        historial[index] = null;
        
        // reorganizar el historial
        for (int i = index; i < historial.length - 1; i++) {
            if (historial[i + 1][0] != null) {
                historial[i] = historial[i + 1];
                historial[i + 1] = null;
            } else {
                break;
            }
        }
    }

    /**
     * Displays all chat sessions in the chat history.
     * Each chat session and its messages are printed to the console.
     */
    public static void showChat() {
        for (int i = 0; i < historial.length; i++) {
            if (historial[i][0] != null) {
                System.out.println("Chat " + i + ":");
                for (int j = 0; j < historial[i].length; j++) {
                    if (historial[i][j] != null) {
                        System.out.println(historial[i][j]);
                    }
                }
            }
        }
    }

    /**
     * Adds a message and its response to the current chat session.
     * The message and response are added to the first available positions in the current chat session.
     *
     * @param promt the message to add
     * @param respuesta the response to the message
     */
    public static void addMensaje(String promt, String respuesta) {
        for (int i = 0; i < chatActual.length; i++) {
            if (chatActual[i] == null) {
                chatActual[i] = promt;
                chatActual[i + 1] = respuesta;
                break;
            }
        }
    }

    /**
     * Displays the current chat session.
     * Each message in the current chat session is printed to the console.
     */
    public static void showChatActual() {
        for (int i = 0; i < chatActual.length; i++) {
            if (chatActual[i] != null) {
                System.out.println(chatActual[i]);
            }
        }
    }

    /**
     * Deletes all messages in the current chat session.
     * The current chat session is reset to an empty state.
     */
    public static void deleteChatActual() {
        chatActual = new String[30];
    }

    /**
     * Sets the current chat session to a chat session from the chat history.
     * The chat session at the specified index in the history becomes the current chat session.
     *
     * @param index the index of the chat session to set as the current chat session
     */
    public static void setChatActual(int index) {
        chatActual = historial[index];
    }

    /**
     * Creates a new chat session.
     * This method initializes a new chat by calling the addChat method
     * and setting up a new chat array with a fixed size of 30.
     */
    public static void crearNuevoChat() {
        addChat();
        chatActual = new String[30];
    }
}