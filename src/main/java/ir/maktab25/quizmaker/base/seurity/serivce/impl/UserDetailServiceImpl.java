package ir.maktab25.quizmaker.base.seurity.serivce.impl;

import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.repository.BaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    BaseUserRepository baseUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = baseUserRepository.findByUserName(username);
        if (user == null)
            throw new UsernameNotFoundException("there is no user with " + username + " username");

        if (user.getIsActive()) {
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    getAuthorities(user));
        } else {
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                    false,
                    true,
                    true,
                    true,
                    getAuthorities(user));
        }
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map(Role -> Role.getRoleName().toString()).toArray(String[]::new);
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        for (String s : userRoles)
            grantedAuthoritySet.add(new SimpleGrantedAuthority(s));
        return grantedAuthoritySet;
    }
}
