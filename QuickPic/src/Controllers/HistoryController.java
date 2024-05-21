/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import java.util.Stack;

/**
 * FXML Controller class
 *
 * @author Alessandro_Cofone
 */
public class HistoryController implements Initializable {
    
    private Stack<Image> undoStack;
    private Stack<Image> redoStack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inizializzazione delle code undoStack e redoStack
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }
    // Metodo per aggiungere un'immagine allo stack undoStack.
    public void push(Image image) {
        undoStack.push(image);
        redoStack.clear(); // Quando aggiungi un nuovo stato, cancella la coda redoStack
    }
    // Metodo per annullare l'ultima azione e restituire l'immagine precedente.
    public Image undo() {
        if (!undoStack.isEmpty()) {
            Image currentState = undoStack.pop();
            redoStack.push(currentState);
            return undoStack.isEmpty() ? null : undoStack.peek(); // Restituisci il precedente stato se presente
        }
        return null;
    }
    //Metodo per ripristinare l'ultima azione annullata e restituire l'immagine successiva.
    public Image redo() {
        if (!redoStack.isEmpty()) {
            Image nextState = redoStack.pop();
            undoStack.push(nextState);
            return nextState;
        }
        return null;
    }
    
}
