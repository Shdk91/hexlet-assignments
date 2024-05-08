package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")

public class PostsController {


    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public List<Post> showPostsById(@PathVariable int id) {
        var result = posts.stream().filter(p -> p.getUserId() == id).toList();
        return result;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("users/{userId}/posts")
    public Post create(@PathVariable Integer userId, @RequestBody Post post) {
        post.setUserId(userId);
        posts.add(post);
        return post;
    }
}
// END