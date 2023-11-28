package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping(path = "/posts")
public class PostsController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post : posts) {
            var postDTO = new PostDTO();
            postDTO.setId(post.getId());
            postDTO.setTitle(post.getTitle());
            postDTO.setBody(post.getBody());
            var comments = commentRepository.findByPostId(post.getId());
            List<CommentDTO> commentDTOS = new ArrayList<>();
            for (var comment : comments) {
                CommentDTO commentDTO = new CommentDTO();
                commentDTO.setId(comment.getId());
                commentDTO.setBody(comment.getBody());
                commentDTOS.add(commentDTO);
            }
            postDTO.setComments(commentDTOS);
            postDTOS.add(postDTO);
        }
        return postDTOS;
    }

    @GetMapping(path = "{id}")
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setBody(post.getBody());
        var comments = commentRepository.findByPostId(post.getId());
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (var comment : comments) {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setId(comment.getId());
            commentDTO.setBody(comment.getBody());
            commentDTOS.add(commentDTO);
        }
        postDTO.setComments(commentDTOS);
        return postDTO;
    }
}
// END
