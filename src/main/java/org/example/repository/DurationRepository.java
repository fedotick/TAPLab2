package org.example.repository;

import org.example.model.Duration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DurationRepository implements IRepository<Duration, Long> {

    private final List<Duration> durations;

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
    public Duration create(Duration entity) {
        entity.setId(getCurrentId());
        durations.add(entity);
        return entity;
    }

    @Override
    public List<Duration> findAll() {
        return new ArrayList<>(durations);
    }

    @Override
    public Optional<Duration> findById(Long id) {
        return durations.stream()
                .filter(duration -> duration.getId().equals(id))
                .findFirst();
    }

    public Optional<Duration> findByName(String name) {
        return durations.stream()
                .filter(duration -> duration.getName().equals(name))
                .findFirst();
    }

    @Override
    public Duration update(Duration entity) {
        Optional<Duration> existingDuration = findById(entity.getId());

        existingDuration.ifPresent(duration -> {
            int index = durations.indexOf(duration);
            durations.set(index, entity);
        });

        return entity;
    }

    @Override
    public void deleteById(Long id) {
        durations.removeIf(duration -> duration.getId().equals(id));
    }

    private Long getCurrentId() {
        return durations.stream()
                .max(Comparator.comparing(Duration::getId))
                .map(duration -> duration.getId() + 1L)
                .orElse(1L);
    }

}
