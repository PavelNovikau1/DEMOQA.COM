package api_adapters;

import api_objects.User;
import io.restassured.response.ResponseBody;

public class UserAdapter extends BaseAdapter{

    private static final String USER_URI = "/User";

    public ResponseBody create(User user){
        return post(USER_URI, converter.toJson(user)).body();
    }
}
