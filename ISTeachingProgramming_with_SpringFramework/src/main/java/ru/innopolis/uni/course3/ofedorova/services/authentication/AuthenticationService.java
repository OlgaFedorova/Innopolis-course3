package ru.innopolis.uni.course3.ofedorova.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import ru.innopolis.uni.course3.ofedorova.models.Role;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.services.users.MainServiceForUsers;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует сервис аутентификации пользователей.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 13.01.2016
 */
@Service("authenticationProvider")
public class AuthenticationService implements AuthenticationProvider {

    /**
     * Объект-сервис для работы с данными пользователя.
     */
    private final MainServiceForUsers mainService;

    /**
     * Создает новый объект.
     *
     * @param mainService значение поля "mainService".
     */
    @Autowired
    public AuthenticationService(MainServiceForUsers mainService) {
        this.mainService = mainService;
    }

    /**
     * Метод осуществляет процесс аутентификации.
     *
     * @param authentication the authentication request object.
     * @return a fully authenticated object including credentials. May return
     * <code>null</code> if the <code>AuthenticationProvider</code> is unable to support
     * authentication of the passed <code>Authentication</code> object.
     * @throws AuthenticationException if authentication fails.
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication result = null;
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        final User user = this.mainService.validateLogin(login, password);
        if (user != null) {
            List<Role> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new Role("USER"));
            user.setAuthorities(grantedAuthorities);
            result = new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);
        }
        return result;
    }

    /**
     * Returns <code>true</code> if this <Code>AuthenticationProvider</code> supports the
     * indicated <Code>Authentication</code> object.
     * <p>
     * Returning <code>true</code> does not guarantee an
     * <code>AuthenticationProvider</code> will be able to authenticate the presented
     * instance of the <code>Authentication</code> class. It simply indicates it can
     * support closer evaluation of it. An <code>AuthenticationProvider</code> can still
     * return <code>null</code> from the {@link #authenticate(Authentication)} method to
     * indicate another <code>AuthenticationProvider</code> should be tried.
     * </p>
     * <p>
     * Selection of an <code>AuthenticationProvider</code> capable of performing
     * authentication is conducted at runtime the <code>ProviderManager</code>.
     * </p>
     *
     * @param authentication
     * @return <code>true</code> if the implementation can more closely evaluate the
     * <code>Authentication</code> class presented
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
