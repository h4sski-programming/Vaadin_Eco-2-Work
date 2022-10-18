package com.creadis.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;


public class MainLayout extends AppLayout {

    public MainLayout(){

        createMenu();
    }


    private void createMenu() {
        RouterLink homeRoute = new RouterLink("Eco 2 Work", HomeView.class);
        homeRoute.addClassNames("text-xl");
        RouterLink editRoute = new RouterLink("Edit", EditView.class);

        HorizontalLayout menuRoutes = new HorizontalLayout(homeRoute, editRoute);
        menuRoutes.setWidthFull();
        menuRoutes.addClassNames("menu", "my-s", "mx-l", "text-l");
        menuRoutes.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.BASELINE);
        addToNavbar(menuRoutes);
    }

}
