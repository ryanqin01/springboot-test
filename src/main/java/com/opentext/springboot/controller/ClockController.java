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

		Period period = Period.between(startDate, currentDate);
		Duration duration = Duration.between(startTime, currentTime);
		long seconds = duration.getSeconds();
		if (duration.isNegative()) {
			period = period.minusDays(1);
			seconds = seconds + 60 * 60 * 24;
		}

		long hour = seconds / 3600;
		long rest = seconds - hour * 3600;
		long minute = rest / 60;
		rest = seconds - hour * 3600 - minute * 60;

		return "Being together for: " + period.getYears() + " year, " + period.getMonths() + " months, "
				+ period.getDays() + " days, " + hour + " hours, " + minute + " minutes, " + rest + " seconds. ";
	}
}