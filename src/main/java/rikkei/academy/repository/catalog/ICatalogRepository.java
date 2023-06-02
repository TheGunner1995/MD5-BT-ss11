package rikkei.academy.repository.catalog;

import org.springframework.data.repository.PagingAndSortingRepository;
import rikkei.academy.model.Catalog;

public interface ICatalogRepository extends PagingAndSortingRepository<Catalog , Long> {
}
