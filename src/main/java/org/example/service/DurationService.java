package org.example.service;

import org.example.model.Duration;
import org.example.repository.DurationRepository;

import java.util.List;
import java.util.Optional;

public class DurationService implements IService<Duration, Long> {

    private final DurationRepository durationRepository;

    public DurationService() {
        this.durationRepository = DurationRepository.getInstance();
    }

    @Override
    public Duration create(Duration duration) {
        return durationRepository.create(duration);
    }

    public List<Duration> create(List<Duration> durations) {
        return durations.stream()
                .map(this::create)
                .toList();
    }

    @Override
    public List<Duration> findAll() {
        return durationRepository.findAll();
    }

    @Override
    public Optional<Duration> findById(Long id) {
        return durationRepository.findById(id);
    }

    public Optional<Duration> findByName(String name) {
        return durationRepository.findByName(name);
    }

    @Override
    public Duration update(Duration duration) {
        return durationRepository.update(duration);
    }

    @Override
    public void deleteById(Long id) {
        durationRepository.deleteById(id);
    }

}
