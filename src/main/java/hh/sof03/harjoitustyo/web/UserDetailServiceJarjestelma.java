package hh.sof03.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.sof03.harjoitustyo.domain.User;
import hh.sof03.harjoitustyo.domain.UserRepository;

@Service
public class UserDetailServiceJarjestelma implements UserDetailsService {

    private final UserRepository detailsRepository;

    @Autowired
    public UserDetailServiceJarjestelma(UserRepository userRepository) {
        this.detailsRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User curruser = detailsRepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }

}
