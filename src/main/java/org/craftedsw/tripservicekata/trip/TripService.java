package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	private UserServiceInterface userService;
	private TripByUserInterface tripByUser;

	public TripService(UserServiceInterface userService, TripByUserInterface tripByUser) {
		this.userService = userService;
		this.tripByUser = tripByUser;
	}

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
        User loggedUser = userService.getLoggedUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = tripByUser.findTripsByUSer(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}


}

class UserService implements UserServiceInterface {
	@Override
	public User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}
}
