package com.socialmedia.Social_Media_App.controller;

import com.socialmedia.Social_Media_App.exception.ResourceNotFoundException;
import com.socialmedia.Social_Media_App.model.Post;
import com.socialmedia.Social_Media_App.model.User;
import com.socialmedia.Social_Media_App.repository.PostRepository;
import com.socialmedia.Social_Media_App.repository.UserRepository;
import com.socialmedia.Social_Media_App.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) throws ResourceNotFoundException {
        User user = userRepository.findById(post.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Set the user to the post
        post.setUser(user);

        // Save the post
        Post savedPost = postRepository.save(post);

        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long postId, @RequestBody Post postDetails) {
        return ResponseEntity.ok(postService.updatePost(postId, postDetails));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

}
