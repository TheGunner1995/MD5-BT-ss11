package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rikkei.academy.model.Blog;
import rikkei.academy.service.blog.IBlogService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public ResponseEntity<List<Blog>> listBlog(){
        List<Blog> list = (java.util.List<Blog>) blogService.findAll();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Blog> CreateBlog(@RequestBody Blog blog){
        Blog blog1 = blogService.save(blog);
        return new ResponseEntity<>(blog1,HttpStatus.CREATED);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<Blog> UpdateBlog(@PathVariable("id") Long id, @RequestBody Blog blog){
        Optional<Blog> blogOptional = blogService.findById(id);
        if (blogOptional.isPresent()){
            blogService.save(blog);
            return new ResponseEntity<>(blog,HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Blog> DeleteBlog(@PathVariable("id") Long id){
        Optional<Blog> blogOptional = blogService.findById(id);
        if (blogOptional.isPresent()){
            blogService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("search/{name}")
    public ResponseEntity<Iterable<Blog>> Search(@PathVariable("name") String name){
        List<Blog> blogList = (List<Blog>) blogService.searchByName(name);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }

    }
}
