package com.creadis.views.calendar;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Calendar extends VerticalLayout {

    private int dayNumber = 1;

    public Calendar() {
        this.addClassNames("calendar", "p-0", "m-0");
        this.setWidthFull();

        addRow(true);
        addRow(false);
        addRow(false);
        addRow(false);
        addRow(false);
        addRow(false);
    }

    private void addRow(boolean isHeader) {
        HorizontalLayout row = new HorizontalLayout();
        row.addClassName("calendar-row");
        row.setWidthFull();

        if (isHeader) {
            String[] dayNames = {"Mon", "Tue", "Wed", "Thu", "Fri", " "};
            for (int i = 0; i < 6; i++) {
                row.add(createCell(dayNames[i]));
            }
        }
        else {
            for (int i = 0; i < 5; i++) {
                row.add(createCell("Day " + dayNumber++));
            }
            row.add(createCell("buttons"));
        }
        add(row);
    }

    private Paragraph createCell(String s) {
        Paragraph cell = new Paragraph(s);
        cell.setWidthFull();
        cell.addClassNames("calendar-cell", "m-0", "p-s");
        return cell;
    }
}
