package com.creadis.views.calendar;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class CalendarGrid extends VerticalLayout {
//    private Date date2 = new Date();
//    private Date date = new Date();
//    private Date firstMonthDay = new Date(date.getYear(), date.getMonth(), 1);
//    private Calendar calendar = Calendar.getInstance();
//    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//    private SimpleDateFormat dateMonth = new SimpleDateFormat("M");
//    private SimpleDateFormat dateDay = new SimpleDateFormat("u");
//    private SimpleDateFormat headerDateFormat = new SimpleDateFormat("yyyy MMM");
    private int dayNumber = 1;

    public CalendarGrid() {
        this.addClassNames("calendar", "p-0", "m-0");
        this.setWidthFull();

//        add(new Span(dateFormat.format(date)));
//        add(new Span(dateFormat.format(firstMonthDay)));
//        add(new Span(dateDay.format(date)));
//        add(new Span(dateDay2.format(date)));
//        add(new Span(String.valueOf(calendar)));
//        add(new Span(String.valueOf(calendar.YEAR)));
//        add(new Span(String.valueOf(calendar.MONTH)));
//        add(new Span(String.valueOf(calendar.DAY_OF_MONTH)));
//        add(new Span(String.valueOf(calendar.getTime())));
//        add(new Span());
//        add(new Span(calendar));


//        calendar.setTime(date);
//        Integer year = calendar.get(Calendar.YEAR);
//        Integer month = calendar.get(Calendar.MONTH);
//        add(new H2(headerDateFormat.format(date)));
//        add(new H2(String.valueOf(year + " - " + month)));


        LocalDate localDate = LocalDate.now();
        add(new H2(localDate.getYear() + " - " + localDate.getMonth()));
//        add(new Span("Today is " + localDate.getYear()));
//        add(new Span("Today is " + localDate.getMonth()));
//        add(new Span("Today is " + localDate.getDayOfMonth()));
//        add(new Span("Today is " + localDate.getDayOfWeek()));


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
