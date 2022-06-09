package gui;


import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Kamp;

import java.util.concurrent.Callable;

public class StartWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Administration af tutorer og arrangementer");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }
    public void init() {
        Controller.init();
    }

    private ListView<Kamp> lvwKampe = new ListView<>();
    private TextField txfSpillested, txfSpilleDato, txfSpilleTid;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setHgap(20);
        pane.setVgap(20);
        pane.setPadding(new Insets(20));

        Label lblKampe = new Label("Kampe");
        pane.add(lblKampe,0,0);


        lvwKampe.setPrefWidth(200);
        lvwKampe.setPrefHeight(130);
        lvwKampe.getItems().setAll(Controller.getKampe());
        lvwKampe.setOnMouseClicked(event -> this.updateControls());

        ChangeListener<Kamp> listener = (ov, oldKamp, newKamp) -> this.selectedKampChanged();
        lvwKampe.getSelectionModel().selectedItemProperty().addListener(listener);

        pane.add(lvwKampe,0,1);

        VBox vBox1 = new VBox();
        vBox1.setSpacing(15);

        VBox vBox2 = new VBox();
        vBox2.setSpacing(5);
        Label lblSpillested = new Label("Spillested");
        vBox1.getChildren().add(lblSpillested);
        txfSpillested = new TextField();
        vBox2.getChildren().add(txfSpillested);

        Label lblSpilleDato = new Label("Spilledato");
        vBox1.getChildren().add(lblSpilleDato);
        txfSpilleDato = new TextField();
        vBox2.getChildren().add(txfSpilleDato);

        Label lblSpilletid = new Label("Spilletid");
        vBox1.getChildren().add(lblSpilletid);
        txfSpilleTid = new TextField();
        vBox2.getChildren().add(txfSpilleTid);

        HBox hBox = new HBox();
        Button btnOpret = new Button("Opret");
        btnOpret.setOnAction(event -> this.btnOpretKamp());
        hBox.getChildren().add(btnOpret);

        Button btnOpdater = new Button("opdater");
        btnOpdater.setOnAction(event -> this.btnOpdaterKamp());
        hBox.getChildren().add(btnOpdater);

        Button btnLavFil = new Button("Lav fil");
        btnLavFil.setOnAction(event -> this.skrivTilFil());

        vBox2.getChildren().add(hBox);
        vBox2.getChildren().add(btnLavFil);
        pane.add(vBox1,1,1);
        pane.add(vBox2,2,1);

    }

    private void selectedKampChanged() {
        updateControls();
    }

    private void updateControls() {
        Kamp kamp = lvwKampe.getSelectionModel().getSelectedItem();
        if(kamp != null){
            txfSpillested.setText(kamp.getSted());
            txfSpilleTid.setText(String.valueOf(kamp.getTid()));
            txfSpilleDato.setText(String.valueOf(kamp.getDato()));

        }else{
            txfSpilleDato.clear();
            txfSpilleTid.clear();
            txfSpillested.clear();
        }
    }

    private void skrivTilFil() {
    }

    private void btnOpdaterKamp() {
    }

    private void btnOpretKamp() {
    }


}