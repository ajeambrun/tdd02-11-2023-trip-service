package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.List;

public class TripByUser implements TripByUserInterface {
     @Override
     public List<Trip> findTripsByUSer(User user) {
        return TripDAO.findTripsByUser(user);
    }
}
