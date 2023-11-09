package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TripServiceTest {
    @Test
    public void when_user_without_trip_then_return_empty_trips_list() throws Exception {
        // Given
        User user = new User();
        User userConnected = new User();
        TripService tripService = new TripService(new UserServiceForTest(userConnected));

        // When
        List<Trip> tripsOfGivenUser = tripService.getTripsByUser(user);

        // Then
        assertThat(tripsOfGivenUser).isEmpty();
    }
    @Test
    public void when_user_without_trip_then_return_list() throws Exception {
        // Given
        User userParameter = new User();
        User userConnected = new User();
        userParameter.addFriend(userConnected);

        TripService tripService = new TripService(new UserServiceForTest(userConnected));

        // When
        List<Trip> tripsOfGivenUser = tripService.getTripsByUser(userParameter);

        // Then
        assertThat(tripsOfGivenUser).isEmpty();
    }


}

class UserServiceForTest implements UserServiceInterface {

    private User user;

    public UserServiceForTest(User user) {
        this.user = user;
    }

    @Override
    public User getLoggedUser() {
        return user;
    }

    public User getFriends(){
        return new User();
    }
}