package com.creadis.views;

import com.creadis.views.calendar.CalendarGrid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Home @ Eco 2 Work @ Creadis")
@Route(value = "/", layout = MainLayout.class)
public class HomeView extends VerticalLayout {

    public HomeView() {
        VerticalLayout content = new VerticalLayout();
        content.setClassName("content");
        content.setWidthFull();
        content.setSizeFull();

        CalendarGrid calendar = new CalendarGrid();

        Paragraph p = new Paragraph("hello from paragraph");
        Button b = new Button("click me");

        content.add(calendar, p, b);
        add(content);
    }
}
