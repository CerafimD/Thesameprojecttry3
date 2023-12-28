package org.example.db.mapper;

import org.example.db.VacancyEntity;
import org.example.models.Experience;
import org.example.models.Vacancy;

import java.lang.invoke.VolatileCallSite;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Set;

public class vacancymapper {
    public static Vacancy map(VacancyEntity vac){
        var time = Instant.ofEpochMilli(vac.getPublishedAt().getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        return new Vacancy(vac.getName(), vac.getDescription(), Collections.emptySet(),
                Experience.NO_EXPERIENCE,vac.isPremium(), vac.getEmployerName(),
                vac.getSalary(), vac.getAreaName(), time);
    }
}
