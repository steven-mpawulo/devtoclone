package com.example.devtoclone.controllers;

import com.example.devtoclone.exception.NoUserFoundException;
import com.example.devtoclone.models.Follower;
import com.example.devtoclone.models.Skill;
import com.example.devtoclone.models.SocialUrl;
import com.example.devtoclone.models.User;
import com.example.devtoclone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NoUserFoundException(HttpStatus.NOT_FOUND, "user with provided id not found");
        }
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
       Optional<User> oldUser = userRepository.findById(userId);

       if (oldUser.isPresent()) {
           User actualUser = oldUser.get();
           actualUser.setFirstName(user.getFirstName());
           actualUser.setLastName(user.getLastName());
           actualUser.setEmail(user.getEmail());
           return userRepository.save(actualUser);
       } else {
           throw new NoUserFoundException(HttpStatus.NOT_FOUND, "no user found to update");
       }
    }

    @PutMapping("/users/{userId}/socialUrls")
    public User addUserSocialUrls(@PathVariable Long userId, @RequestBody Map<String, Object> jsonData) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<String> jsonSocialUrls = (List<String>) jsonData.get("content");
            User actualUser = user.get();
            List<SocialUrl> userSocialUrls = actualUser.getSocialUrls();
            for (String url: jsonSocialUrls) {
                SocialUrl socialUrl = new SocialUrl(actualUser, url);
                userSocialUrls.add(socialUrl);
            }
            return userRepository.save(actualUser);
        } else {
            throw new NoUserFoundException(HttpStatus.NOT_FOUND, "failed to add urls because user with provided url not found");
        }
    }

    @PutMapping("/users/{userId}/follow")
    public User addFollower(@PathVariable Long userId, @RequestBody Map<String, Object> jsonData) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
                int userToFollowIntId = (int) jsonData.get("userId");
                Long userToFollowId = (long) userToFollowIntId;
                Optional<User> userToFollow = userRepository.findById(userToFollowId);
                if (userToFollow.isPresent()) {
                    User actualUser = user.get();
                    User actualUserGoingToFollow = userToFollow.get();
                    List<Follower> userFollowers = actualUserGoingToFollow.getFollowers();
                    Follower follower = new Follower(actualUser);
                    if (userFollowers.contains(follower)) {
                        throw new ResponseStatusException(HttpStatus.FAILED_DEPENDENCY, "already following");
                    } else {
                        userFollowers.add(follower);
                        return userRepository.save(actualUser);
                    }

                } else {
                    throw new NoUserFoundException(HttpStatus.NOT_FOUND, "failed to follow since user with provided id does not exist");
                }

        } else {
            throw new NoUserFoundException(HttpStatus.NOT_FOUND, "failed to follow user because user with provided id not found");
        }
    }

    @PutMapping("/users/{userId}/skills")
    public User addSkills(@PathVariable Long userId, @RequestBody Map<String, Object> jsonData) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User actualUser = user.get();
            List<String> userProvidedSkills = (List<String>) jsonData.get("content");
            List<Skill> userSkills = actualUser.getSkills();

            for (String providedSkill : userProvidedSkills) {
                Skill skill = new Skill(actualUser, providedSkill);
                userSkills.add(skill);
            }
            return userRepository.save(actualUser);

        } else {
            throw new NoUserFoundException(HttpStatus.NOT_FOUND, "failed to add skills since no user with provided id found");
        }
    }

}
