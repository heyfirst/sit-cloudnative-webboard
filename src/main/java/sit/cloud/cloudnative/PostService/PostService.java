package sit.cloud.cloudnative.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService{

    @Autowired
    private PostRepository postRepository;

    public Post getPostByID(long userId) {
        Optional<Post> post = postRepository.findById(userId);
        return post.get();
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Post createPost(Post newPost){
        return postRepository.save(newPost);
    }
}
