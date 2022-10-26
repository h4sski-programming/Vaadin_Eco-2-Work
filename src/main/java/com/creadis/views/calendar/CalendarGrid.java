package com.creadis.views.calendar;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
    private LocalDate localDate = LocalDate.now();
    private int dayOfWeek = localDate.getDayOfWeek().getValue();
    private int curentDay = 1;

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


        add(new H2(localDate.getYear() + " - " + localDate.getMonth()));
        add(new H2(localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " = " + dayOfWeek));
//        add(new Span("Today is " + localDate.getYear()));
//        add(new Span("Today is " + localDate.getMonth()));
//        add(new Span("Today is " + localDate.getDayOfMonth()));
//        add(new Span("Today is " + localDate.getDayOfWeek()));


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
                row.add(Integer.toString(curentDay++));
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
