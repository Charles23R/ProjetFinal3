package sample;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import sample.Matrice;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MatriceView extends GridPane{

    private Matrice matriceVraie;

    public MatriceView(Matrice matrice) {
        try {


            this.matriceVraie = matrice;
            addColumn(matrice.getWidth());
            addRow(matrice.getHeight());

            for (int y = 0; y < matrice.getHeight(); y++) {
                for (int x = 0; x < matrice.getWidth(); x++) {
                    TextField tf = new TextField();
                    tf.setPrefHeight(100);
                    tf.setPrefWidth(100);
                    tf.setAlignment(Pos.CENTER);
                    tf.setEditable(true);

                    int yFinal = y;
                    int xFinal = x;
                    tf.textProperty().addListener((observable, oldValue, newValue) -> {
                        double[][] temporaire = matriceVraie.getMatriceTab();
                        try {
                            temporaire[yFinal][xFinal] = Double.valueOf(newValue);
                            matriceVraie.setMatriceTab(temporaire);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    });

                    if (String.valueOf(matrice.getMatriceTab()[y][x]).equals("")) {
                        tf.setText("0");
                    } else {
                        tf.setText(String.valueOf(matrice.getMatriceTab()[y][x]));
                    }

                    setRowIndex(tf, y);
                    setColumnIndex(tf, x);
                    getChildren().add(tf);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void changerVraieMatrice(Matrice matrice){
    }

    public Matrice getMatriceVraie() {
        return matriceVraie;
    }

    public void setMatriceVraie(Matrice matriceVraie) {
        this.matriceVraie = matriceVraie;
    }
}
