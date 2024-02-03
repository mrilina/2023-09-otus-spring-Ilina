package ru.otus.hw.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.otus.hw.repository.UserRepository;


import static java.lang.String.format;
import static ru.otus.hw.util.ErrorMessage.USER_NOT_FOUND;

/**
 * Сервис обработки сведений о пользователях.
 *
 * @author Irina Ilina
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * Репозиторий обработки сведений о пользователях.
     */
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(format(USER_NOT_FOUND, username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                AuthorityUtils.NO_AUTHORITIES);
    }
}
