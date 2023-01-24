package com.example.ChoufliHal.User;

import com.example.ChoufliHal.User.LoginAndRegistration.Registration;
import net.bytebuddy.utility.RandomString;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService  implements UserDetailsService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JavaMailSender javaMailSender;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    { return userRepository.findByUsername(username).orElseThrow(()  -> new UsernameNotFoundException("USER NOT FOUND"));}


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
          else throw new UsernameNotFoundException("User not found");

        }

    public void register(Registration user, String siteURL) throws MessagingException, UnsupportedEncodingException
    { String randomCode= RandomString.make(64);
        User newUser = new User(
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPhoneNumber(),
                user.getCin(),
                user.getAddress(),
                bCryptPasswordEncoder.encode(user.getPassword()),randomCode);
        addUser(newUser);
        sendVerificationEmail(user,siteURL);
    }


    public void sendVerificationEmail(Registration user, String siteURL  ) throws MessagingException, UnsupportedEncodingException {
        String subject ="Please verify your registration";
        String senderName="Choufli hal team ";
        String mailContent= "<p>Dear "+ user.getFirstName()+" "+user.getLastName()+ "</p>";
        mailContent+= "<p> Please click the link below to verify your registration : </p> ";
        String verifyURL= siteURL +"/verify?code="+userRepository.findByUsername(user.getUsername()).get().getVerificationCode();
        mailContent+="<h3> <a href=\""+verifyURL+"\">VERIFY</a></h3>";
        mailContent+="<p> Thank you <br> Choufli hal team</p>";

        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper helper =new MimeMessageHelper(message);
        helper.setFrom("chouflihalapp@gmail.com",senderName);
        helper.setTo(user.getUsername());
        helper.setSubject(subject);
        helper.setText(mailContent,true);
        javaMailSender.send(message);
    }


    public Boolean verify(String verificationCode)
    { Optional<User> user= userRepository.findByVerificationCode(verificationCode);
        if (!(user.isPresent()) || user.get().isEnabled() )
            return false;
        else {  userRepository.enable(user.get().getUserId());
            user.get().setLocked(false);
            return true;}
    }












}
