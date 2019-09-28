package com.rest.springrestapi.bootstrap;

import com.rest.springrestapi.domain.Post;
import com.rest.springrestapi.domain.User;
import com.rest.springrestapi.repository.PostRepository;
import com.rest.springrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Bootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Autowired
    public Bootstrap(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        User user=new User();
        user.setName("Can yard");
        user.setPassword("1213123");
        user.setType("investor");
        user.setEmail("icanyard@gmail.com");

        User user2=new User();
        user2.setName("Yusufali Cezik");
        user2.setPassword("123");
        user2.setType("developer");
        user2.setEmail("deneme@gmail.com");

        User user3=new User();
        user3.setName("Hasan Cerit");
        user3.setPassword("123");
        user3.setType("developer");
        user3.setEmail("hasan@gmail.com");

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);

        Post post=new Post();
        post.setPostContent("Startup fikrimiz için yatırımcı aramaktayız");
        post.setPostType("yatırımcı arama");
        post.setUser(user);

        Post post2=new Post();
        post2.setPostContent("Startup fikrimiz için geliştirici aramaktayız");
        post2.setPostType("geliştirici arama");
        post2.setUser(user);

        Post post3=new Post();
        post3.setPostContent("Startup Projelerinde çalışmak üzere iş arıyorum");
        post3.setPostType("iş arama");
        post3.setUser(user2);

        postRepository.save(post);
        postRepository.save(post2);
        postRepository.save(post3);



    }
}
