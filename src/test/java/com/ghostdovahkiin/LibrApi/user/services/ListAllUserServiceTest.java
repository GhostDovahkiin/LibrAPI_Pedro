package com.ghostdovahkiin.LibrApi.user.services;

import com.ghostdovahkiin.LibrApi.user.User;
import com.ghostdovahkiin.LibrApi.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static com.ghostdovahkiin.LibrApi.user.services.builders.UserBuilder.createUser;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests execution for List All Users Service")
class ListAllUserServiceTest {

    @Mock
    private UserRepository userRepository;
    private ListAllUserServiceImpl listAllUserService;

    @BeforeEach
    void setUp() {
        this.listAllUserService = new ListAllUserServiceImpl(userRepository);
    }

    @Test
    @DisplayName("Should return all users")
    void shouldfindAllUsers() {
        when(userRepository.findAll()).thenReturn(
                Stream.of(createUser().name("Pedro 1").build(),
                          createUser().name("Pedro 2").build(),
                          createUser().name("Pedro 3").build()).collect(Collectors.toList())
        );

        List<User> usersFound = listAllUserService.findAll();

        assertAll("Users",
                () -> assertThat(usersFound.size(), is(3)),
                () -> assertThat(usersFound.get(0).getName(), is("Pedro 1")),
                () -> assertThat(usersFound.get(1).getName(), is("Pedro 2")),
                () -> assertThat(usersFound.get(2).getName(), is("Pedro 3"))
        );
    }
}