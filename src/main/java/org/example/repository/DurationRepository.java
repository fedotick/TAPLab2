package org.example.repository;

import org.example.model.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DurationRepository implements IRepository<Duration, Long> {

    private final List<Duration> durations;
    private Long currentId = 1L;

    private static DurationRepository instance;

    private DurationRepository() {
        durations = new ArrayList<>();
    }

    public static DurationRepository getInstance() {
        if (instance == null) {
            instance = new DurationRepository();
        }
        return instance;
    }

    @Override
    public Duration save(Duration entity) {
        if (entity.getId() == null) {
            entity.setId(currentId++);
        }
        Optional<Duration> existingDuration = findById(entity.getId());
        existingDuration.ifPresent(durations::remove);
        durations.add(entity);
        return entity;
    }

    @Override
    public Optional<Duration> findById(Long id) {
        return durations.stream()
                .filter(duration -> duration.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Duration> findAll() {
        return new ArrayList<>(durations);
    }

    @Override
    public void deleteById(Long id) {
        durations.removeIf(duration -> duration.getId().equals(id));
    }

}
