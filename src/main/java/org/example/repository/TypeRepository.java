package org.example.repository;

import org.example.model.Type;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TypeRepository implements IRepository<Type, Long> {

    private final List<Type> types;

    private static TypeRepository instance;

    private TypeRepository() {
        types = new ArrayList<>();
    }

    public static TypeRepository getInstance() {
        if (instance == null) {
            instance = new TypeRepository();
        }
        return instance;
    }

    @Override
    public Type create(Type entity) {
        entity.setId(getCurrentId());
        types.add(entity);
        return entity;
    }

    @Override
    public List<Type> findAll() {
        return new ArrayList<>(types);
    }

    @Override
    public Optional<Type> findById(Long id) {
        return types.stream()
                .filter(type -> type.getId().equals(id))
                .findFirst();
    }

    public Optional<Type> findByName(String name) {
        return types.stream()
                .filter(type -> type.getName().equals(name))
                .findFirst();
    }

    @Override
    public Type update(Type entity) {
        Optional<Type> existingType = findById(entity.getId());

        existingType.ifPresent(type -> {
            int index = types.indexOf(type);
            types.set(index, entity);
        });

        return entity;
    }

    @Override
    public void deleteById(Long id) {
        types.removeIf(type -> type.getId().equals(id));
    }

    private Long getCurrentId() {
        return types.stream()
                .max(Comparator.comparing(Type::getId))
                .map(type -> type.getId() + 1L)
                .orElse(1L);
    }

}
