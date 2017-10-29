    public List<String> findDayEvents(){

        CalendarProvider provider = new CalendarProvider(this);
        List<Calendar> calendars = provider.getCalendars().getList();
        int calendarSize = calendars.size();

        Date current = new Date(System.currentTimeMillis());

        System.out.println(current.getDate() + "  aaaaaa   " + current.getMonth());

        int currentMonth = current.getMonth() + 1;
        int currentDay = current.getDate();

        String daysEvent = null;

        List<String> currentEvents = new ArrayList<>();


        for (int i = 0; i < calendarSize; i++) {
            List<Event> events = provider.getEvents(calendars.get(i).id).getList();
            for (int j = 0; j < events.size(); j++) {

                long startTime = events.get(j).dTStart;
                Date startDate = new Date(startTime);


                int eventMonth = startDate.getMonth() + 1;
                int eventDay = startDate.getDate();

                if ((eventDay == currentDay) && (eventMonth == currentMonth)) {
                    currentEvents.add(events.get(j).title);
                }

            }

        }
        return currentEvents;
    }