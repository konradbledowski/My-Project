package com.example.demo;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class GUI extends VerticalLayout {

    private AnimalFactClient animalFactClient;
    private DogImageClient dogImageClient;

    @Autowired
    public GUI(AnimalFactClient animalFactClient, DogImageClient dogImageClient){
        this.animalFactClient= animalFactClient;
        this.dogImageClient= dogImageClient;

        Grid<AnimalFact> grid = new Grid<>(AnimalFact.class);
        grid.setItems(animalFactClient.getAnimalFact());

        grid.addColumn(new ComponentRenderer<>(dog -> {
            Image image = new Image(dogImageClient.getDogImage(), "brak");
            image.setHeight("150px");
            return image;
        })).setHeader("Image");
        grid.setHeight("1000px");


        grid.removeColumnByKey("used");
        grid.removeColumnByKey("source");
        grid.removeColumnByKey("deleted");
        grid.removeColumnByKey("id");
        grid.removeColumnByKey("user");
        grid.removeColumnByKey("createdAt");
        grid.removeColumnByKey("updatedAt");
        grid.removeColumnByKey("v");
        grid.removeColumnByKey("additionalProperties");

        add(grid);
    }
}
