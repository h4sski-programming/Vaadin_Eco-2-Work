package com.creadis.views.calendar;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarGrid extends VerticalLayout {
    private int dayNumber = 1;
    private final LocalDate localDate = LocalDate.now();
    private int firstMonthDayOfWeek = localDate.withDayOfMonth(1).getDayOfWeek().getValue();
    private int curentDay = 1;

    public CalendarGrid() {
        this.addClassNames("calendar", "p-0", "m-0");
        this.setWidthFull();

        add(new H2(localDate.getYear() + " - " + localDate.getMonth()));
        int dayOfWeek = localDate.getDayOfWeek().getValue();
        add(new H2(localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " = " + dayOfWeek));


        addRow(true, false);
        addRow(false, true);
        addRow(false, false);
        addRow(false, false);
        addRow(false, false);
        addRow(false, false);
    }

    private void addRow(boolean isHeader, boolean isFirstWeek) {
        HorizontalLayout row = new HorizontalLayout();
        row.addClassName("calendar-row");
        row.setWidthFull();

        if (isHeader && isFirstWeek) {
            return;
        }

        if (isHeader) {
            String[] dayNames = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", " "};
            for (String s : dayNames) {
                row.add(createCell(s));
            }
        } else if (isFirstWeek) {
            for (int i = 0; i <7; i++) {
                row.add(createCell(Integer.toString(firstMonthDayOfWeek - 7 + i)));
            }
            row.add(createCell("buttons"));
        } else {
            for (int i = 0; i < 7; i++) {
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
