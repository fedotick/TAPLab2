package org.example.service;

import org.example.model.Type;
import org.example.repository.TypeRepository;

import java.util.List;
import java.util.Optional;

public class TypeService implements IService<Type, Long> {

    private final TypeRepository typeRepository;

    public TypeService() {
        this.typeRepository = TypeRepository.getInstance();
    }

    @Override
    public Type create(Type type) {
        return typeRepository.create(type);
    }

    public List<Type> create(List<Type> types) {
        return types.stream()
                .map(this::create)
                .toList();
    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }

    public Optional<Type> findByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public Type update(Type type) {
        return typeRepository.update(type);
    }

    @Override
    public void deleteById(Long id) {
        typeRepository.deleteById(id);
    }

}
