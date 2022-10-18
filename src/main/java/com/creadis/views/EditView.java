package com.creadis.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Edit @ Eco 2 Work @ Creadis")
@Route(value = "/edit", layout = MainLayout.class)
public class EditView extends VerticalLayout {

    public EditView() {

        Paragraph p = new Paragraph("Here you will be able to edit data.");
        add(p);
    }
}
