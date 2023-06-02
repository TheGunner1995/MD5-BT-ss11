package rikkei.academy.service.blog;

import rikkei.academy.model.Blog;
import rikkei.academy.service.IGenericService;

public interface IBlogService extends IGenericService<Blog, Long> {
    Iterable<Blog> searchByName(String name);
}
