package com.newsletter.repository;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.newsletter.entity.Newsletter;

@Validated
public interface NewsletterRepository {

	@NotNull
	List<Newsletter> getNewsLettersForPeriodOrderedByDescendingPublishingDateLimitedByMaxRecordCount(
		@NotNull LocalDate fromDate, @NotNull LocalDate toDate, @Min(1) @Max(10) int maxRecords	);

}
