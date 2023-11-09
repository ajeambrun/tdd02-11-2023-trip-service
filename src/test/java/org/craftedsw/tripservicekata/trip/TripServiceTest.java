package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TripServiceTest {
    @Test
    public void shouldDoSomething() throws Exception {
        // Given
        User user = new User();
        TripService tripService = new TripService(new UserServiceForTest());

        // When
        List<Trip> tripsOfGivenUser = tripService.getTripsByUser(user);

        // Then
        assertThat(tripsOfGivenUser).isEqualTo("Not an exception");
    }
}

class UserServiceForTest implements UserServiceInterface {
    @Override
    public User getLoggedUser() {
        return new User();
    }
}