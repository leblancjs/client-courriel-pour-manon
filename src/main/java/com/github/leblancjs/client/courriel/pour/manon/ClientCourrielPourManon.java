package com.github.leblancjs.client.courriel.pour.manon;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ClientCourrielPourManon extends Application {
    private static final long DELAI_AVANT_REPONSE_EN_MS = 5000;

    @Override
    public void start(Stage primaryStage) {
        ClientCourriel client = new ClientCourriel(DELAI_AVANT_REPONSE_EN_MS);

        ObservableList<Courriel> courrielsAffichees = FXCollections.observableArrayList();

        TableView<Courriel> lesCourriels = creerTableau();
        lesCourriels.setItems(courrielsAffichees);
        VBox.setVgrow(lesCourriels, Priority.ALWAYS);

        Button lePiton = new Button("Télécharger les courriels");
        lePiton.setOnAction(evenement -> CompletableFuture.supplyAsync(client::obtenirCourriels)
                .thenAcceptAsync(courrielsAffichees::setAll, Platform::runLater));

        primaryStage.setScene(new Scene(new VBox(lesCourriels, lePiton)));
        primaryStage.setTitle("Client courriel pour Manon");
        primaryStage.show();
    }

    private TableView<Courriel> creerTableau() {
        TableColumn<Courriel, String> colonneExpediteur = new TableColumn<>("Expéditeur");
        colonneExpediteur.setCellValueFactory(caracteristiquesDesDonnees -> new SimpleObjectProperty<>(caracteristiquesDesDonnees.getValue().getExpediteur()));

        TableColumn<Courriel, String> colonneSujet = new TableColumn<>("Sujet");
        colonneSujet.setCellValueFactory(caracteristiquesDesDonnees -> new SimpleObjectProperty<>(caracteristiquesDesDonnees.getValue().getSujet()));

        TableColumn<Courriel, String> colonneMessage = new TableColumn<>("Message");
        colonneMessage.setCellValueFactory(caracteristiquesDesDonnees -> new SimpleObjectProperty<>(caracteristiquesDesDonnees.getValue().getMessage()));

        TableView<Courriel> lesCourriels = new TableView<>();
        List.of(colonneExpediteur, colonneSujet, colonneMessage).forEach(colonne -> lesCourriels.getColumns().add(colonne));

        return lesCourriels;
    }
}
