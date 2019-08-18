package org.kostiskag.javaadvancedtraining.utils;

import java.util.*;


/**
 *
 */
public class DateLocaleCurrencyTesting extends Date {

    public DateLocaleCurrencyTesting() {
    }

    public DateLocaleCurrencyTesting(long date) {
        super(date);
    }

    public Date asDate() {
        return new Date(this.getTime());
    }

    /**
     *
     * @param time
     * @throws RuntimeException
     */
    @Override
    public void setTime(long time) {
        throw new RuntimeException("You are not allowed to set time!");
    }

    public DateLocaleCurrencyTesting setTime(Date date) {
        return new DateLocaleCurrencyTesting(date.getTime());
    }


    static class SafeDate {
        private final Date d;

        public SafeDate(Long milliseconds) {
            this.d = new Date(milliseconds);
        }

        public SafeDate() {
            this.d = new Date();
        }

        long getTime() {
            return d.getTime();
        }

        public Date asDate() {
            return new Date(this.getTime());
        }

        @Override
        public String toString() {
            return d.toString();
        }
    }


    public static void main(String[] args) {
        Date d = new Date();

        System.out.println(d);
        System.out.println(d.getTime());

        long aMinute = 1000 * 60;
        long aDay = aMinute * 60 * 24;
        long aYear = aDay * 361L;

        long oneYearAhead = aYear + 5*aDay;
        System.out.println(oneYearAhead);

        d.setTime(d.getTime() + oneYearAhead);

        System.out.println(d);


        DateLocaleCurrencyTesting safe = new DateLocaleCurrencyTesting();
        System.out.println("safe " + safe);
        //safe.setTime(15L); //you are not allowed however the method still exists!
        safe.setTime(new Date(15L)); //as we may notice the object is fully immutable
        System.out.println("safe " + safe);
        //or we could use a wrapper!!!
        SafeDate safe2 = new SafeDate();
        //now in cases where it is needed to supply a Date type of object we may use
        safe2.asDate(); // which will return a new Date and therefore defending our object from mutation!

        //Calendar
        Calendar c = new GregorianCalendar();
        c.setTime(safe2.asDate());

        System.out.println(c.getTimeZone());


        //Locale
        Locale en = Locale.ENGLISH;
        System.out.println("locale " + en);
        System.out.println(en);
        System.out.println(en.getCountry());
        System.out.println(en.getDisplayCountry());
        System.out.println(en.getLanguage());
        System.out.println(en.getDisplayLanguage());
        System.out.println(en.getDisplayName());

        Locale ch = Locale.CHINA;
        System.out.println("china! "+ch.getDisplayName());
        System.out.println(ch.getDisplayCountry());
        System.out.println(ch.getDisplayName());

        Locale gr = Locale.getDefault(); //Locale.getDefault()
        System.out.println(gr.getDisplayName());
        System.out.println(gr.getDisplayCountry());
        System.out.println(gr.getDisplayLanguage());

        for (Locale loc : Locale.getAvailableLocales()) {
            System.out.println("\n");
            System.out.println(loc.getDisplayName());
            System.out.println(loc.getDisplayCountry());
            System.out.println(loc.getDisplayLanguage());
        }

        Currency cur = Currency.getInstance(Locale.getDefault());  // Currency.getInstance(Locale.getDefault())
        System.out.println("Currency!" + cur);
        System.out.println(cur.getCurrencyCode());
        System.out.println(cur.getDefaultFractionDigits());
        System.out.println(cur.getDisplayName());

        Set<Currency> curSet = Currency.getAvailableCurrencies(); // Currency.getAvailableCurrencies()

        curSet.forEach(e -> {
            System.out.println(e);
            System.out.println(e.getCurrencyCode());
            System.out.println(e.getDefaultFractionDigits());
            System.out.println(e.getDisplayName());
            System.out.println("-----");
        });

        //SimpleTimeZone ti = ;
        System.out.println(Arrays.toString(SimpleTimeZone.getAvailableIDs()));
        TimeZone time = c.getTimeZone();
        System.out.println(time);
        System.out.println(time.getID());
        System.out.println(time.getDisplayName());
        System.out.println(time.getDSTSavings());
    }
}
