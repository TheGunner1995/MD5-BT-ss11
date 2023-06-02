package rikkei.academy.repository.blog;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import rikkei.academy.model.Blog;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    @Query("SELECT b from Blog as b where b.Name like %:name%")
    Iterable<Blog> searchByName(@Param("name") String name);
}
