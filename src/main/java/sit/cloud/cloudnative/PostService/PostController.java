package sit.cloud.cloudnative.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(
            value="/posts",
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Post>> getUserList() {
        List<Post> users = postService.getAllPost();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(
            value="/posts/{post_id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Post> getUserList(@PathVariable("post_id") long userId) {
        Post post = postService.getPostByID(userId);
        return new ResponseEntity(post, HttpStatus.OK);
    }

    @RequestMapping(
            value="/posts/",
            method = RequestMethod.POST
    )public ResponseEntity<Post> createUser(@Valid @RequestBody Post newPost) {
        Post user = postService.createPost(newPost);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }
}
