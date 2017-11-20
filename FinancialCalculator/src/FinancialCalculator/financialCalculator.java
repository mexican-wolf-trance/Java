package FinancialCalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import java.lang.Math;
import java.text.DecimalFormat;
;

public class financialCalculator extends Application
{
	@Override
	public void	start(Stage	primaryStage) 
	{
			FlowPane pane1 =	new	FlowPane();
			pane1.setHgap(1);
			TextField money =	new	TextField();
			Label l1 = new Label("Money used in investment: ");
			
			FlowPane pane2 = new FlowPane();
			pane2.setHgap(37);
			TextField air	= new TextField();
			Label l3 = new Label("Annual interest rate: ");
			
			FlowPane pane3 = new FlowPane();
			pane3.setHgap(112); 
			TextField years = new	TextField();
			Label l2 = new Label("Years: ");
			
			FlowPane pane4 = new FlowPane();
			pane4.setHgap(42);
			TextField ffw = new TextField();
			ffw.setEditable(false);
			Label l4 = new Label("Final finacial worth: ");
			
			money.setPrefColumnCount(10);
			years.setPrefColumnCount(10);
			ffw.setPrefColumnCount(10);
			air.setPrefColumnCount(10);
			
			money.setAlignment(Pos.CENTER_RIGHT);
			years.setAlignment(Pos.CENTER_RIGHT);
			ffw.setAlignment(Pos.CENTER_RIGHT);
			air.setAlignment(Pos.CENTER_RIGHT);
			
			pane1.getChildren().addAll(l1, money);
			pane2.getChildren().addAll(l3 , air);
			pane3.getChildren().addAll(l2 , years);
			pane4.getChildren().addAll(l4, ffw);
			
			VBox vBox = new	VBox();
			Button calculate =	new	Button("Calculate");
			Button clear = new Button("Clear");
			calculate.setTranslateX(209);
			clear.setTranslateX(230);
			vBox.setSpacing(5);
			vBox.setPadding(new Insets(50, 0, 50, 40));
			vBox.getChildren().addAll(pane1, pane3, pane2, pane4, calculate, clear);
	
			BorderPane borderPane =	new	BorderPane();
			borderPane.setCenter(vBox);
				
			Scene scene	= new Scene(borderPane, 350, 250);
			primaryStage.setTitle("Financial Calculator                     ");
			primaryStage.setScene(scene); 
			primaryStage.show(); 
			
			calculate.setOnAction(e-> 
			{
				DecimalFormat df = new DecimalFormat("#.00");
				ffw.setText("$" + df.format(Double.parseDouble(money.getText()) * 
						Math.pow((1 + (Double.parseDouble(air.getText()) / 1200)) , 
								(Double.parseDouble(years.getText()) * 12))) + "");
			});
			clear.setOnAction(e ->
			{
				money.clear(); years.clear(); air.clear(); ffw.clear();
			});
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
