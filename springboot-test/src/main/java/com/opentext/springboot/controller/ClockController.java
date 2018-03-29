package com.opentext.springboot.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClockController {

	public static final LocalDate startDate = LocalDate.of(2016, 5, 7);
	public static final LocalTime startTime = LocalTime.of(14, 0, 0);

	@RequestMapping("/clock")
	public String showClock() throws InterruptedException {

		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();

		while (true) {
			Thread.sleep(1000);
			Period period = Period.between(startDate, currentDate);
			Duration duration = Duration.between(startTime, currentTime);
			long seconds = duration.getSeconds();
			int days = period.getDays();
			if (duration.isNegative()) {
				seconds = seconds + 60 * 60 * 24;
				days = period.getDays() - 1;
			}
			long hour = seconds / 3600;
			long rest = seconds - hour * 3600;
			long minute = rest / 60;
			rest = seconds - hour * 3600 - minute * 60;

			return "Being together for: " + period.getYears() + " year, " + period.getMonths() + " months, " + days
					+ " days, " + hour + " hours, " + minute + " minutes, " + rest + " seconds. ";

		}
	}
}