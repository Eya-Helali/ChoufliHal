package com.example.ChoufliHal.User;

//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

        private final UserRepository userRepository;



        public List<User> getAllUsers()
        { return userRepository.findAll();}

      public Optional<User> getUserByUsername(String username)
    {  return userRepository.findByUsername(username);}

        public User addUser(User user)
        { return userRepository.save(user);}

        public void deleteUserById(Long userId)
        { userRepository.deleteById(userId);}

        public User updateUserByID(Long userId, User userUpdated)
        { userUpdated.setUserId(userId);
            return userRepository.save(userUpdated);}



        public int evaluate(int evaluation, Long userId)
        { return userRepository.evaluateUser(evaluation, userId);}



     public Optional<User> chooseRole(Long userId, UserRole userRole) throws Exception
        { Optional<User> user = userRepository.findById(userId);
            if (user.isPresent())
            {   userRepository.changeUserRole(userRole,user.get().getUserId());
                return user;}
    //       else throw new UserameNotFoundException("User not found");
            return user;
        }













}
