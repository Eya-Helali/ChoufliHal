package com.example.ChoufliHal.User;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping(path="/byUsername/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username)
    { return userService.getUserByUsername(username);}

    @GetMapping
    public List<User> getAllUsers()
    {return userService.getAllUsers();}

    @PostMapping("/add")
    public User addUser(@RequestBody User user )
    {return userService.addUser(user);}

    @PutMapping(path="/evaluate/byUserId/{evaluation}/{userId}")
    public int evaluate(@PathVariable int evaluation,@PathVariable Long userId)
    {  userService.evaluate(evaluation,userId);
        return(evaluation);
    }

    @PutMapping(path="{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User userUpdated)
    { return userService.updateUserByID(userId,userUpdated);}


    @DeleteMapping(path="{userId}")
    public void deleteUserById(@PathVariable Long userId)
    { userService.deleteUserById(userId);}

    @PutMapping(path="chooseRole/{userId}")
    public Optional<User> chooseRole(@PathVariable Long userId,@RequestParam UserRole userRole) throws Exception
    {return userService.chooseRole(userId,userRole);}





}
