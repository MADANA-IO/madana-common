package de.madana.common.datastructures.twitter;

public   class MDN_TwitterFollowEvent {
    public   String for_user_id;
    public   Follow_event follow_events[];

    public MDN_TwitterFollowEvent(String for_user_id, Follow_event[] follow_events){
        this.for_user_id = for_user_id;
        this.follow_events = follow_events;
    }

    public MDN_TwitterFollowEvent() {
		// TODO Auto-generated constructor stub
	}

	public static   class Follow_event {
        public   String type;
        public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getCreated_timestamp() {
			return created_timestamp;
		}

		public void setCreated_timestamp(String created_timestamp) {
			this.created_timestamp = created_timestamp;
		}

		public Target getTarget() {
			return target;
		}

		public void setTarget(Target target) {
			this.target = target;
		}

		public Source getSource() {
			return source;
		}

		public void setSource(Source source) {
			this.source = source;
		}

		public   String created_timestamp;
        public   Target target;
        public   Source source;

        public Follow_event(String type, String created_timestamp, Target target, Source source){
            this.type = type;
            this.created_timestamp = created_timestamp;
            this.target = target;
            this.source = source;
        }

        public static   class Target {
            public   String id;
            public   boolean default_profile_image;
            public   String profile_background_image_url;
            public   long friends_count;
            public   long favourites_count;
            public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public boolean isDefault_profile_image() {
				return default_profile_image;
			}

			public void setDefault_profile_image(boolean default_profile_image) {
				this.default_profile_image = default_profile_image;
			}

			public String getProfile_background_image_url() {
				return profile_background_image_url;
			}

			public void setProfile_background_image_url(String profile_background_image_url) {
				this.profile_background_image_url = profile_background_image_url;
			}

			public long getFriends_count() {
				return friends_count;
			}

			public void setFriends_count(long friends_count) {
				this.friends_count = friends_count;
			}

			public long getFavourites_count() {
				return favourites_count;
			}

			public void setFavourites_count(long favourites_count) {
				this.favourites_count = favourites_count;
			}

			public long getProfile_link_color() {
				return profile_link_color;
			}

			public void setProfile_link_color(long profile_link_color) {
				this.profile_link_color = profile_link_color;
			}

			public String getProfile_background_image_url_https() {
				return profile_background_image_url_https;
			}

			public void setProfile_background_image_url_https(String profile_background_image_url_https) {
				this.profile_background_image_url_https = profile_background_image_url_https;
			}

			public long getUtc_offset() {
				return utc_offset;
			}

			public void setUtc_offset(long utc_offset) {
				this.utc_offset = utc_offset;
			}

			public String getScreen_name() {
				return screen_name;
			}

			public void setScreen_name(String screen_name) {
				this.screen_name = screen_name;
			}

			public boolean isIs_translator() {
				return is_translator;
			}

			public void setIs_translator(boolean is_translator) {
				this.is_translator = is_translator;
			}

			public long getFollowers_count() {
				return followers_count;
			}

			public void setFollowers_count(long followers_count) {
				this.followers_count = followers_count;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getLang() {
				return lang;
			}

			public void setLang(String lang) {
				this.lang = lang;
			}

			public boolean isProfile_use_background_image() {
				return profile_use_background_image;
			}

			public void setProfile_use_background_image(boolean profile_use_background_image) {
				this.profile_use_background_image = profile_use_background_image;
			}

			public String getCreated_at() {
				return created_at;
			}

			public void setCreated_at(String created_at) {
				this.created_at = created_at;
			}

			public long getProfile_text_color() {
				return profile_text_color;
			}

			public void setProfile_text_color(long profile_text_color) {
				this.profile_text_color = profile_text_color;
			}

			public boolean isNotifications() {
				return notifications;
			}

			public void setNotifications(boolean notifications) {
				this.notifications = notifications;
			}

			public boolean is_protected() {
				return _protected;
			}

			public void set_protected(boolean _protected) {
				this._protected = _protected;
			}

			public long getStatuses_count() {
				return statuses_count;
			}

			public void setStatuses_count(long statuses_count) {
				this.statuses_count = statuses_count;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public boolean isContributors_enabled() {
				return contributors_enabled;
			}

			public void setContributors_enabled(boolean contributors_enabled) {
				this.contributors_enabled = contributors_enabled;
			}

			public boolean isDefault_profile() {
				return default_profile;
			}

			public void setDefault_profile(boolean default_profile) {
				this.default_profile = default_profile;
			}

			public long getProfile_sidebar_border_color() {
				return profile_sidebar_border_color;
			}

			public void setProfile_sidebar_border_color(long profile_sidebar_border_color) {
				this.profile_sidebar_border_color = profile_sidebar_border_color;
			}

			public String getTime_zone() {
				return time_zone;
			}

			public void setTime_zone(String time_zone) {
				this.time_zone = time_zone;
			}

			public boolean isGeo_enabled() {
				return geo_enabled;
			}

			public void setGeo_enabled(boolean geo_enabled) {
				this.geo_enabled = geo_enabled;
			}

			public boolean isVerified() {
				return verified;
			}

			public void setVerified(boolean verified) {
				this.verified = verified;
			}

			public String getProfile_image_url() {
				return profile_image_url;
			}

			public void setProfile_image_url(String profile_image_url) {
				this.profile_image_url = profile_image_url;
			}

			public boolean isFollowing() {
				return following;
			}

			public void setFollowing(boolean following) {
				this.following = following;
			}

			public String getProfile_image_url_https() {
				return profile_image_url_https;
			}

			public void setProfile_image_url_https(String profile_image_url_https) {
				this.profile_image_url_https = profile_image_url_https;
			}

			public boolean isProfile_background_tile() {
				return profile_background_tile;
			}

			public void setProfile_background_tile(boolean profile_background_tile) {
				this.profile_background_tile = profile_background_tile;
			}

			public long getListed_count() {
				return listed_count;
			}

			public void setListed_count(long listed_count) {
				this.listed_count = listed_count;
			}

			public long getProfile_sidebar_fill_color() {
				return profile_sidebar_fill_color;
			}

			public void setProfile_sidebar_fill_color(long profile_sidebar_fill_color) {
				this.profile_sidebar_fill_color = profile_sidebar_fill_color;
			}

			public String getLocation() {
				return location;
			}

			public void setLocation(String location) {
				this.location = location;
			}

			public boolean isFollow_request_sent() {
				return follow_request_sent;
			}

			public void setFollow_request_sent(boolean follow_request_sent) {
				this.follow_request_sent = follow_request_sent;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public long getProfile_background_color() {
				return profile_background_color;
			}

			public void setProfile_background_color(long profile_background_color) {
				this.profile_background_color = profile_background_color;
			}

			public   long profile_link_color;
            public   String profile_background_image_url_https;
            public   long utc_offset;
            public   String screen_name;
            public   boolean is_translator;
            public   long followers_count;
            public   String name;
            public   String lang;
            public   boolean profile_use_background_image;
            public   String created_at;
            public   long profile_text_color;
            public   boolean notifications;
            public   boolean _protected;
            public   long statuses_count;
            public   String url;
            public   boolean contributors_enabled;
            public   boolean default_profile;
            public   long profile_sidebar_border_color;
            public   String time_zone;
            public   boolean geo_enabled;
            public   boolean verified;
            public   String profile_image_url;
            public   boolean following;
            public   String profile_image_url_https;
            public   boolean profile_background_tile;
            public   long listed_count;
            public   long profile_sidebar_fill_color;
            public   String location;
            public   boolean follow_request_sent;
            public   String description;
            public   long profile_background_color;
    
            public Target(String id, boolean default_profile_image, String profile_background_image_url, long friends_count, long favourites_count, long profile_link_color, String profile_background_image_url_https, long utc_offset, String screen_name, boolean is_translator, long followers_count, String name, String lang, boolean profile_use_background_image, String created_at, long profile_text_color, boolean notifications, boolean _protected, long statuses_count, String url, boolean contributors_enabled, boolean default_profile, long profile_sidebar_border_color, String time_zone, boolean geo_enabled, boolean verified, String profile_image_url, boolean following, String profile_image_url_https, boolean profile_background_tile, long listed_count, long profile_sidebar_fill_color, String location, boolean follow_request_sent, String description, long profile_background_color){
                this.id = id;
                this.default_profile_image = default_profile_image;
                this.profile_background_image_url = profile_background_image_url;
                this.friends_count = friends_count;
                this.favourites_count = favourites_count;
                this.profile_link_color = profile_link_color;
                this.profile_background_image_url_https = profile_background_image_url_https;
                this.utc_offset = utc_offset;
                this.screen_name = screen_name;
                this.is_translator = is_translator;
                this.followers_count = followers_count;
                this.name = name;
                this.lang = lang;
                this.profile_use_background_image = profile_use_background_image;
                this.created_at = created_at;
                this.profile_text_color = profile_text_color;
                this.notifications = notifications;
                this._protected = _protected;
                this.statuses_count = statuses_count;
                this.url = url;
                this.contributors_enabled = contributors_enabled;
                this.default_profile = default_profile;
                this.profile_sidebar_border_color = profile_sidebar_border_color;
                this.time_zone = time_zone;
                this.geo_enabled = geo_enabled;
                this.verified = verified;
                this.profile_image_url = profile_image_url;
                this.following = following;
                this.profile_image_url_https = profile_image_url_https;
                this.profile_background_tile = profile_background_tile;
                this.listed_count = listed_count;
                this.profile_sidebar_fill_color = profile_sidebar_fill_color;
                this.location = location;
                this.follow_request_sent = follow_request_sent;
                this.description = description;
                this.profile_background_color = profile_background_color;
            }
        }

        public static   class Source {
            public   String id;
            public   boolean default_profile_image;
            public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public boolean isDefault_profile_image() {
				return default_profile_image;
			}

			public void setDefault_profile_image(boolean default_profile_image) {
				this.default_profile_image = default_profile_image;
			}

			public String getProfile_background_image_url() {
				return profile_background_image_url;
			}

			public void setProfile_background_image_url(String profile_background_image_url) {
				this.profile_background_image_url = profile_background_image_url;
			}

			public long getFriends_count() {
				return friends_count;
			}

			public void setFriends_count(long friends_count) {
				this.friends_count = friends_count;
			}

			public long getFavourites_count() {
				return favourites_count;
			}

			public void setFavourites_count(long favourites_count) {
				this.favourites_count = favourites_count;
			}

			public long getProfile_link_color() {
				return profile_link_color;
			}

			public void setProfile_link_color(long profile_link_color) {
				this.profile_link_color = profile_link_color;
			}

			public String getProfile_background_image_url_https() {
				return profile_background_image_url_https;
			}

			public void setProfile_background_image_url_https(String profile_background_image_url_https) {
				this.profile_background_image_url_https = profile_background_image_url_https;
			}

			public long getUtc_offset() {
				return utc_offset;
			}

			public void setUtc_offset(long utc_offset) {
				this.utc_offset = utc_offset;
			}

			public String getScreen_name() {
				return screen_name;
			}

			public void setScreen_name(String screen_name) {
				this.screen_name = screen_name;
			}

			public boolean isIs_translator() {
				return is_translator;
			}

			public void setIs_translator(boolean is_translator) {
				this.is_translator = is_translator;
			}

			public long getFollowers_count() {
				return followers_count;
			}

			public void setFollowers_count(long followers_count) {
				this.followers_count = followers_count;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getLang() {
				return lang;
			}

			public void setLang(String lang) {
				this.lang = lang;
			}

			public boolean isProfile_use_background_image() {
				return profile_use_background_image;
			}

			public void setProfile_use_background_image(boolean profile_use_background_image) {
				this.profile_use_background_image = profile_use_background_image;
			}

			public String getCreated_at() {
				return created_at;
			}

			public void setCreated_at(String created_at) {
				this.created_at = created_at;
			}

			public long getProfile_text_color() {
				return profile_text_color;
			}

			public void setProfile_text_color(long profile_text_color) {
				this.profile_text_color = profile_text_color;
			}

			public boolean isNotifications() {
				return notifications;
			}

			public void setNotifications(boolean notifications) {
				this.notifications = notifications;
			}

			public boolean is_protected() {
				return _protected;
			}

			public void set_protected(boolean _protected) {
				this._protected = _protected;
			}

			public long getStatuses_count() {
				return statuses_count;
			}

			public void setStatuses_count(long statuses_count) {
				this.statuses_count = statuses_count;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public boolean isContributors_enabled() {
				return contributors_enabled;
			}

			public void setContributors_enabled(boolean contributors_enabled) {
				this.contributors_enabled = contributors_enabled;
			}

			public boolean isDefault_profile() {
				return default_profile;
			}

			public void setDefault_profile(boolean default_profile) {
				this.default_profile = default_profile;
			}

			public long getProfile_sidebar_border_color() {
				return profile_sidebar_border_color;
			}

			public void setProfile_sidebar_border_color(long profile_sidebar_border_color) {
				this.profile_sidebar_border_color = profile_sidebar_border_color;
			}

			public String getTime_zone() {
				return time_zone;
			}

			public void setTime_zone(String time_zone) {
				this.time_zone = time_zone;
			}

			public boolean isGeo_enabled() {
				return geo_enabled;
			}

			public void setGeo_enabled(boolean geo_enabled) {
				this.geo_enabled = geo_enabled;
			}

			public boolean isVerified() {
				return verified;
			}

			public void setVerified(boolean verified) {
				this.verified = verified;
			}

			public String getProfile_image_url() {
				return profile_image_url;
			}

			public void setProfile_image_url(String profile_image_url) {
				this.profile_image_url = profile_image_url;
			}

			public boolean isFollowing() {
				return following;
			}

			public void setFollowing(boolean following) {
				this.following = following;
			}

			public String getProfile_image_url_https() {
				return profile_image_url_https;
			}

			public void setProfile_image_url_https(String profile_image_url_https) {
				this.profile_image_url_https = profile_image_url_https;
			}

			public boolean isProfile_background_tile() {
				return profile_background_tile;
			}

			public void setProfile_background_tile(boolean profile_background_tile) {
				this.profile_background_tile = profile_background_tile;
			}

			public long getListed_count() {
				return listed_count;
			}

			public void setListed_count(long listed_count) {
				this.listed_count = listed_count;
			}

			public long getProfile_sidebar_fill_color() {
				return profile_sidebar_fill_color;
			}

			public void setProfile_sidebar_fill_color(long profile_sidebar_fill_color) {
				this.profile_sidebar_fill_color = profile_sidebar_fill_color;
			}

			public String getLocation() {
				return location;
			}

			public void setLocation(String location) {
				this.location = location;
			}

			public boolean isFollow_request_sent() {
				return follow_request_sent;
			}

			public void setFollow_request_sent(boolean follow_request_sent) {
				this.follow_request_sent = follow_request_sent;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public long getProfile_background_color() {
				return profile_background_color;
			}

			public void setProfile_background_color(long profile_background_color) {
				this.profile_background_color = profile_background_color;
			}

			public   String profile_background_image_url;
            public   long friends_count;
            public   long favourites_count;
            public   long profile_link_color;
            public   String profile_background_image_url_https;
            public   long utc_offset;
            public   String screen_name;
            public   boolean is_translator;
            public   long followers_count;
            public   String name;
            public   String lang;
            public   boolean profile_use_background_image;
            public   String created_at;
            public   long profile_text_color;
            public   boolean notifications;
            public   boolean _protected;
            public   long statuses_count;
            public   String url;
            public   boolean contributors_enabled;
            public   boolean default_profile;
            public   long profile_sidebar_border_color;
            public   String time_zone;
            public   boolean geo_enabled;
            public   boolean verified;
            public   String profile_image_url;
            public   boolean following;
            public   String profile_image_url_https;
            public   boolean profile_background_tile;
            public   long listed_count;
            public   long profile_sidebar_fill_color;
            public   String location;
            public   boolean follow_request_sent;
            public   String description;
            public   long profile_background_color;
    
            public Source(String id, boolean default_profile_image, String profile_background_image_url, long friends_count, long favourites_count, long profile_link_color, String profile_background_image_url_https, long utc_offset, String screen_name, boolean is_translator, long followers_count, String name, String lang, boolean profile_use_background_image, String created_at, long profile_text_color, boolean notifications, boolean _protected, long statuses_count, String url, boolean contributors_enabled, boolean default_profile, long profile_sidebar_border_color, String time_zone, boolean geo_enabled, boolean verified, String profile_image_url, boolean following, String profile_image_url_https, boolean profile_background_tile, long listed_count, long profile_sidebar_fill_color, String location, boolean follow_request_sent, String description, long profile_background_color){
                this.id = id;
                this.default_profile_image = default_profile_image;
                this.profile_background_image_url = profile_background_image_url;
                this.friends_count = friends_count;
                this.favourites_count = favourites_count;
                this.profile_link_color = profile_link_color;
                this.profile_background_image_url_https = profile_background_image_url_https;
                this.utc_offset = utc_offset;
                this.screen_name = screen_name;
                this.is_translator = is_translator;
                this.followers_count = followers_count;
                this.name = name;
                this.lang = lang;
                this.profile_use_background_image = profile_use_background_image;
                this.created_at = created_at;
                this.profile_text_color = profile_text_color;
                this.notifications = notifications;
                this._protected = _protected;
                this.statuses_count = statuses_count;
                this.url = url;
                this.contributors_enabled = contributors_enabled;
                this.default_profile = default_profile;
                this.profile_sidebar_border_color = profile_sidebar_border_color;
                this.time_zone = time_zone;
                this.geo_enabled = geo_enabled;
                this.verified = verified;
                this.profile_image_url = profile_image_url;
                this.following = following;
                this.profile_image_url_https = profile_image_url_https;
                this.profile_background_tile = profile_background_tile;
                this.listed_count = listed_count;
                this.profile_sidebar_fill_color = profile_sidebar_fill_color;
                this.location = location;
                this.follow_request_sent = follow_request_sent;
                this.description = description;
                this.profile_background_color = profile_background_color;
            }
        }
    }
}