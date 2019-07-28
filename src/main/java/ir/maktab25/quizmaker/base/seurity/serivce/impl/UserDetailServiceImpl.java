package ir.maktab25.quizmaker.base.seurity.serivce.impl;

import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.base.seurity.repository.BaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    BaseUserRepository baseUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BaseUser baseUser = baseUserRepository.findByUserName(username);
        if (baseUser == null)
            throw new UsernameNotFoundException("there is no baseUser with " + username + " username");

        if (baseUser.getIsActive())
            return new User(baseUser.getUserName(), baseUser.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    getAuthorities(baseUser));

        return new User(baseUser.getUserName(), baseUser.getPassword(),
                false,
                true,
                true,
                true,
                getAuthorities(baseUser));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(BaseUser baseUser) {
        String[] userRoles = baseUser.getRoles().stream().map(Role -> Role.getRoleName().toString()).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }
}
