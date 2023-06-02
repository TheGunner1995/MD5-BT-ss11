package rikkei.academy.service.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.Catalog;
import rikkei.academy.repository.catalog.ICatalogRepository;

import java.util.Optional;
@Service

public class CatalogService implements ICatalogService{
    @Autowired
    private ICatalogRepository catalogRepository;
    @Override
    public Iterable<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Optional<Catalog> findById(Long id) {
        return catalogRepository.findById(id);
    }

    @Override
    public Catalog save(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public void delete(Long id) {
        catalogRepository.deleteById(id);
    }
}
