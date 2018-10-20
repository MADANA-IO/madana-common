/*******************************************************************************
 * Copyright (C) 2018 MADANA
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @organization:MADANA
 * @author:Jean-Fabian Wenisch
 * @contact:dev@madana.io
 ******************************************************************************/
package de.madana.common.datastructures.twitter;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_TwitterFollowEvent.
 */
public   class MDN_TwitterFollowEvent {
    
    /** The for user id. */
    public   String for_user_id;
    
    /** The follow events. */
    public   Follow_event follow_events[];

    /**
     * Instantiates a new MD N twitter follow event.
     *
     * @param for_user_id the for user id
     * @param follow_events the follow events
     */
    public MDN_TwitterFollowEvent(String for_user_id, Follow_event[] follow_events){
        this.for_user_id = for_user_id;
        this.follow_events = follow_events;
    }

    /**
     * Instantiates a new MD N twitter follow event.
     */
    public MDN_TwitterFollowEvent() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The Class Follow_event.
	 */
	public static   class Follow_event {
        
        /** The type. */
        public   String type;
        
        /**
         * Gets the type.
         *
         * @return the type
         */
        public String getType() {
			return type;
		}

		/**
		 * Sets the type.
		 *
		 * @param type the new type
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * Gets the created timestamp.
		 *
		 * @return the created timestamp
		 */
		public String getCreated_timestamp() {
			return created_timestamp;
		}

		/**
		 * Sets the created timestamp.
		 *
		 * @param created_timestamp the new created timestamp
		 */
		public void setCreated_timestamp(String created_timestamp) {
			this.created_timestamp = created_timestamp;
		}

		/**
		 * Gets the target.
		 *
		 * @return the target
		 */
		public Target getTarget() {
			return target;
		}

		/**
		 * Sets the target.
		 *
		 * @param target the new target
		 */
		public void setTarget(Target target) {
			this.target = target;
		}

		/**
		 * Gets the source.
		 *
		 * @return the source
		 */
		public Source getSource() {
			return source;
		}

		/**
		 * Sets the source.
		 *
		 * @param source the new source
		 */
		public void setSource(Source source) {
			this.source = source;
		}

		/** The created timestamp. */
		public   String created_timestamp;
        
        /** The target. */
        public   Target target;
        
        /** The source. */
        public   Source source;

        /**
         * Instantiates a new follow event.
         *
         * @param type the type
         * @param created_timestamp the created timestamp
         * @param target the target
         * @param source the source
         */
        public Follow_event(String type, String created_timestamp, Target target, Source source){
            this.type = type;
            this.created_timestamp = created_timestamp;
            this.target = target;
            this.source = source;
        }

        /**
         * The Class Target.
         */
        public static   class Target {
            
            /** The id. */
            public   String id;
            
            /** The default profile image. */
            public   boolean default_profile_image;
            
            /** The profile background image url. */
            public   String profile_background_image_url;
            
            /** The friends count. */
            public   long friends_count;
            
            /** The favourites count. */
            public   long favourites_count;
            
            /**
             * Gets the id.
             *
             * @return the id
             */
            public String getId() {
				return id;
			}

			/**
			 * Sets the id.
			 *
			 * @param id the new id
			 */
			public void setId(String id) {
				this.id = id;
			}

			/**
			 * Checks if is default profile image.
			 *
			 * @return true, if is default profile image
			 */
			public boolean isDefault_profile_image() {
				return default_profile_image;
			}

			/**
			 * Sets the default profile image.
			 *
			 * @param default_profile_image the new default profile image
			 */
			public void setDefault_profile_image(boolean default_profile_image) {
				this.default_profile_image = default_profile_image;
			}

			/**
			 * Gets the profile background image url.
			 *
			 * @return the profile background image url
			 */
			public String getProfile_background_image_url() {
				return profile_background_image_url;
			}

			/**
			 * Sets the profile background image url.
			 *
			 * @param profile_background_image_url the new profile background image url
			 */
			public void setProfile_background_image_url(String profile_background_image_url) {
				this.profile_background_image_url = profile_background_image_url;
			}

			/**
			 * Gets the friends count.
			 *
			 * @return the friends count
			 */
			public long getFriends_count() {
				return friends_count;
			}

			/**
			 * Sets the friends count.
			 *
			 * @param friends_count the new friends count
			 */
			public void setFriends_count(long friends_count) {
				this.friends_count = friends_count;
			}

			/**
			 * Gets the favourites count.
			 *
			 * @return the favourites count
			 */
			public long getFavourites_count() {
				return favourites_count;
			}

			/**
			 * Sets the favourites count.
			 *
			 * @param favourites_count the new favourites count
			 */
			public void setFavourites_count(long favourites_count) {
				this.favourites_count = favourites_count;
			}

			/**
			 * Gets the profile link color.
			 *
			 * @return the profile link color
			 */
			public long getProfile_link_color() {
				return profile_link_color;
			}

			/**
			 * Sets the profile link color.
			 *
			 * @param profile_link_color the new profile link color
			 */
			public void setProfile_link_color(long profile_link_color) {
				this.profile_link_color = profile_link_color;
			}

			/**
			 * Gets the profile background image url https.
			 *
			 * @return the profile background image url https
			 */
			public String getProfile_background_image_url_https() {
				return profile_background_image_url_https;
			}

			/**
			 * Sets the profile background image url https.
			 *
			 * @param profile_background_image_url_https the new profile background image url https
			 */
			public void setProfile_background_image_url_https(String profile_background_image_url_https) {
				this.profile_background_image_url_https = profile_background_image_url_https;
			}

			/**
			 * Gets the utc offset.
			 *
			 * @return the utc offset
			 */
			public long getUtc_offset() {
				return utc_offset;
			}

			/**
			 * Sets the utc offset.
			 *
			 * @param utc_offset the new utc offset
			 */
			public void setUtc_offset(long utc_offset) {
				this.utc_offset = utc_offset;
			}

			/**
			 * Gets the screen name.
			 *
			 * @return the screen name
			 */
			public String getScreen_name() {
				return screen_name;
			}

			/**
			 * Sets the screen name.
			 *
			 * @param screen_name the new screen name
			 */
			public void setScreen_name(String screen_name) {
				this.screen_name = screen_name;
			}

			/**
			 * Checks if is checks if is translator.
			 *
			 * @return true, if is checks if is translator
			 */
			public boolean isIs_translator() {
				return is_translator;
			}

			/**
			 * Sets the checks if is translator.
			 *
			 * @param is_translator the new checks if is translator
			 */
			public void setIs_translator(boolean is_translator) {
				this.is_translator = is_translator;
			}

			/**
			 * Gets the followers count.
			 *
			 * @return the followers count
			 */
			public long getFollowers_count() {
				return followers_count;
			}

			/**
			 * Sets the followers count.
			 *
			 * @param followers_count the new followers count
			 */
			public void setFollowers_count(long followers_count) {
				this.followers_count = followers_count;
			}

			/**
			 * Gets the name.
			 *
			 * @return the name
			 */
			public String getName() {
				return name;
			}

			/**
			 * Sets the name.
			 *
			 * @param name the new name
			 */
			public void setName(String name) {
				this.name = name;
			}

			/**
			 * Gets the lang.
			 *
			 * @return the lang
			 */
			public String getLang() {
				return lang;
			}

			/**
			 * Sets the lang.
			 *
			 * @param lang the new lang
			 */
			public void setLang(String lang) {
				this.lang = lang;
			}

			/**
			 * Checks if is profile use background image.
			 *
			 * @return true, if is profile use background image
			 */
			public boolean isProfile_use_background_image() {
				return profile_use_background_image;
			}

			/**
			 * Sets the profile use background image.
			 *
			 * @param profile_use_background_image the new profile use background image
			 */
			public void setProfile_use_background_image(boolean profile_use_background_image) {
				this.profile_use_background_image = profile_use_background_image;
			}

			/**
			 * Gets the created at.
			 *
			 * @return the created at
			 */
			public String getCreated_at() {
				return created_at;
			}

			/**
			 * Sets the created at.
			 *
			 * @param created_at the new created at
			 */
			public void setCreated_at(String created_at) {
				this.created_at = created_at;
			}

			/**
			 * Gets the profile text color.
			 *
			 * @return the profile text color
			 */
			public long getProfile_text_color() {
				return profile_text_color;
			}

			/**
			 * Sets the profile text color.
			 *
			 * @param profile_text_color the new profile text color
			 */
			public void setProfile_text_color(long profile_text_color) {
				this.profile_text_color = profile_text_color;
			}

			/**
			 * Checks if is notifications.
			 *
			 * @return true, if is notifications
			 */
			public boolean isNotifications() {
				return notifications;
			}

			/**
			 * Sets the notifications.
			 *
			 * @param notifications the new notifications
			 */
			public void setNotifications(boolean notifications) {
				this.notifications = notifications;
			}

			/**
			 * Checks if is protected.
			 *
			 * @return true, if is protected
			 */
			public boolean is_protected() {
				return _protected;
			}

			/**
			 * Sets the protected.
			 *
			 * @param _protected the new protected
			 */
			public void set_protected(boolean _protected) {
				this._protected = _protected;
			}

			/**
			 * Gets the statuses count.
			 *
			 * @return the statuses count
			 */
			public long getStatuses_count() {
				return statuses_count;
			}

			/**
			 * Sets the statuses count.
			 *
			 * @param statuses_count the new statuses count
			 */
			public void setStatuses_count(long statuses_count) {
				this.statuses_count = statuses_count;
			}

			/**
			 * Gets the url.
			 *
			 * @return the url
			 */
			public String getUrl() {
				return url;
			}

			/**
			 * Sets the url.
			 *
			 * @param url the new url
			 */
			public void setUrl(String url) {
				this.url = url;
			}

			/**
			 * Checks if is contributors enabled.
			 *
			 * @return true, if is contributors enabled
			 */
			public boolean isContributors_enabled() {
				return contributors_enabled;
			}

			/**
			 * Sets the contributors enabled.
			 *
			 * @param contributors_enabled the new contributors enabled
			 */
			public void setContributors_enabled(boolean contributors_enabled) {
				this.contributors_enabled = contributors_enabled;
			}

			/**
			 * Checks if is default profile.
			 *
			 * @return true, if is default profile
			 */
			public boolean isDefault_profile() {
				return default_profile;
			}

			/**
			 * Sets the default profile.
			 *
			 * @param default_profile the new default profile
			 */
			public void setDefault_profile(boolean default_profile) {
				this.default_profile = default_profile;
			}

			/**
			 * Gets the profile sidebar border color.
			 *
			 * @return the profile sidebar border color
			 */
			public long getProfile_sidebar_border_color() {
				return profile_sidebar_border_color;
			}

			/**
			 * Sets the profile sidebar border color.
			 *
			 * @param profile_sidebar_border_color the new profile sidebar border color
			 */
			public void setProfile_sidebar_border_color(long profile_sidebar_border_color) {
				this.profile_sidebar_border_color = profile_sidebar_border_color;
			}

			/**
			 * Gets the time zone.
			 *
			 * @return the time zone
			 */
			public String getTime_zone() {
				return time_zone;
			}

			/**
			 * Sets the time zone.
			 *
			 * @param time_zone the new time zone
			 */
			public void setTime_zone(String time_zone) {
				this.time_zone = time_zone;
			}

			/**
			 * Checks if is geo enabled.
			 *
			 * @return true, if is geo enabled
			 */
			public boolean isGeo_enabled() {
				return geo_enabled;
			}

			/**
			 * Sets the geo enabled.
			 *
			 * @param geo_enabled the new geo enabled
			 */
			public void setGeo_enabled(boolean geo_enabled) {
				this.geo_enabled = geo_enabled;
			}

			/**
			 * Checks if is verified.
			 *
			 * @return true, if is verified
			 */
			public boolean isVerified() {
				return verified;
			}

			/**
			 * Sets the verified.
			 *
			 * @param verified the new verified
			 */
			public void setVerified(boolean verified) {
				this.verified = verified;
			}

			/**
			 * Gets the profile image url.
			 *
			 * @return the profile image url
			 */
			public String getProfile_image_url() {
				return profile_image_url;
			}

			/**
			 * Sets the profile image url.
			 *
			 * @param profile_image_url the new profile image url
			 */
			public void setProfile_image_url(String profile_image_url) {
				this.profile_image_url = profile_image_url;
			}

			/**
			 * Checks if is following.
			 *
			 * @return true, if is following
			 */
			public boolean isFollowing() {
				return following;
			}

			/**
			 * Sets the following.
			 *
			 * @param following the new following
			 */
			public void setFollowing(boolean following) {
				this.following = following;
			}

			/**
			 * Gets the profile image url https.
			 *
			 * @return the profile image url https
			 */
			public String getProfile_image_url_https() {
				return profile_image_url_https;
			}

			/**
			 * Sets the profile image url https.
			 *
			 * @param profile_image_url_https the new profile image url https
			 */
			public void setProfile_image_url_https(String profile_image_url_https) {
				this.profile_image_url_https = profile_image_url_https;
			}

			/**
			 * Checks if is profile background tile.
			 *
			 * @return true, if is profile background tile
			 */
			public boolean isProfile_background_tile() {
				return profile_background_tile;
			}

			/**
			 * Sets the profile background tile.
			 *
			 * @param profile_background_tile the new profile background tile
			 */
			public void setProfile_background_tile(boolean profile_background_tile) {
				this.profile_background_tile = profile_background_tile;
			}

			/**
			 * Gets the listed count.
			 *
			 * @return the listed count
			 */
			public long getListed_count() {
				return listed_count;
			}

			/**
			 * Sets the listed count.
			 *
			 * @param listed_count the new listed count
			 */
			public void setListed_count(long listed_count) {
				this.listed_count = listed_count;
			}

			/**
			 * Gets the profile sidebar fill color.
			 *
			 * @return the profile sidebar fill color
			 */
			public long getProfile_sidebar_fill_color() {
				return profile_sidebar_fill_color;
			}

			/**
			 * Sets the profile sidebar fill color.
			 *
			 * @param profile_sidebar_fill_color the new profile sidebar fill color
			 */
			public void setProfile_sidebar_fill_color(long profile_sidebar_fill_color) {
				this.profile_sidebar_fill_color = profile_sidebar_fill_color;
			}

			/**
			 * Gets the location.
			 *
			 * @return the location
			 */
			public String getLocation() {
				return location;
			}

			/**
			 * Sets the location.
			 *
			 * @param location the new location
			 */
			public void setLocation(String location) {
				this.location = location;
			}

			/**
			 * Checks if is follow request sent.
			 *
			 * @return true, if is follow request sent
			 */
			public boolean isFollow_request_sent() {
				return follow_request_sent;
			}

			/**
			 * Sets the follow request sent.
			 *
			 * @param follow_request_sent the new follow request sent
			 */
			public void setFollow_request_sent(boolean follow_request_sent) {
				this.follow_request_sent = follow_request_sent;
			}

			/**
			 * Gets the description.
			 *
			 * @return the description
			 */
			public String getDescription() {
				return description;
			}

			/**
			 * Sets the description.
			 *
			 * @param description the new description
			 */
			public void setDescription(String description) {
				this.description = description;
			}

			/**
			 * Gets the profile background color.
			 *
			 * @return the profile background color
			 */
			public long getProfile_background_color() {
				return profile_background_color;
			}

			/**
			 * Sets the profile background color.
			 *
			 * @param profile_background_color the new profile background color
			 */
			public void setProfile_background_color(long profile_background_color) {
				this.profile_background_color = profile_background_color;
			}

			/** The profile link color. */
			public   long profile_link_color;
            
            /** The profile background image url https. */
            public   String profile_background_image_url_https;
            
            /** The utc offset. */
            public   long utc_offset;
            
            /** The screen name. */
            public   String screen_name;
            
            /** The is translator. */
            public   boolean is_translator;
            
            /** The followers count. */
            public   long followers_count;
            
            /** The name. */
            public   String name;
            
            /** The lang. */
            public   String lang;
            
            /** The profile use background image. */
            public   boolean profile_use_background_image;
            
            /** The created at. */
            public   String created_at;
            
            /** The profile text color. */
            public   long profile_text_color;
            
            /** The notifications. */
            public   boolean notifications;
            
            /** The protected. */
            public   boolean _protected;
            
            /** The statuses count. */
            public   long statuses_count;
            
            /** The url. */
            public   String url;
            
            /** The contributors enabled. */
            public   boolean contributors_enabled;
            
            /** The default profile. */
            public   boolean default_profile;
            
            /** The profile sidebar border color. */
            public   long profile_sidebar_border_color;
            
            /** The time zone. */
            public   String time_zone;
            
            /** The geo enabled. */
            public   boolean geo_enabled;
            
            /** The verified. */
            public   boolean verified;
            
            /** The profile image url. */
            public   String profile_image_url;
            
            /** The following. */
            public   boolean following;
            
            /** The profile image url https. */
            public   String profile_image_url_https;
            
            /** The profile background tile. */
            public   boolean profile_background_tile;
            
            /** The listed count. */
            public   long listed_count;
            
            /** The profile sidebar fill color. */
            public   long profile_sidebar_fill_color;
            
            /** The location. */
            public   String location;
            
            /** The follow request sent. */
            public   boolean follow_request_sent;
            
            /** The description. */
            public   String description;
            
            /** The profile background color. */
            public   long profile_background_color;
    
            /**
             * Instantiates a new target.
             *
             * @param id the id
             * @param default_profile_image the default profile image
             * @param profile_background_image_url the profile background image url
             * @param friends_count the friends count
             * @param favourites_count the favourites count
             * @param profile_link_color the profile link color
             * @param profile_background_image_url_https the profile background image url https
             * @param utc_offset the utc offset
             * @param screen_name the screen name
             * @param is_translator the is translator
             * @param followers_count the followers count
             * @param name the name
             * @param lang the lang
             * @param profile_use_background_image the profile use background image
             * @param created_at the created at
             * @param profile_text_color the profile text color
             * @param notifications the notifications
             * @param _protected the protected
             * @param statuses_count the statuses count
             * @param url the url
             * @param contributors_enabled the contributors enabled
             * @param default_profile the default profile
             * @param profile_sidebar_border_color the profile sidebar border color
             * @param time_zone the time zone
             * @param geo_enabled the geo enabled
             * @param verified the verified
             * @param profile_image_url the profile image url
             * @param following the following
             * @param profile_image_url_https the profile image url https
             * @param profile_background_tile the profile background tile
             * @param listed_count the listed count
             * @param profile_sidebar_fill_color the profile sidebar fill color
             * @param location the location
             * @param follow_request_sent the follow request sent
             * @param description the description
             * @param profile_background_color the profile background color
             */
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

        /**
         * The Class Source.
         */
        public static   class Source {
            
            /** The id. */
            public   String id;
            
            /** The default profile image. */
            public   boolean default_profile_image;
            
            /**
             * Gets the id.
             *
             * @return the id
             */
            public String getId() {
				return id;
			}

			/**
			 * Sets the id.
			 *
			 * @param id the new id
			 */
			public void setId(String id) {
				this.id = id;
			}

			/**
			 * Checks if is default profile image.
			 *
			 * @return true, if is default profile image
			 */
			public boolean isDefault_profile_image() {
				return default_profile_image;
			}

			/**
			 * Sets the default profile image.
			 *
			 * @param default_profile_image the new default profile image
			 */
			public void setDefault_profile_image(boolean default_profile_image) {
				this.default_profile_image = default_profile_image;
			}

			/**
			 * Gets the profile background image url.
			 *
			 * @return the profile background image url
			 */
			public String getProfile_background_image_url() {
				return profile_background_image_url;
			}

			/**
			 * Sets the profile background image url.
			 *
			 * @param profile_background_image_url the new profile background image url
			 */
			public void setProfile_background_image_url(String profile_background_image_url) {
				this.profile_background_image_url = profile_background_image_url;
			}

			/**
			 * Gets the friends count.
			 *
			 * @return the friends count
			 */
			public long getFriends_count() {
				return friends_count;
			}

			/**
			 * Sets the friends count.
			 *
			 * @param friends_count the new friends count
			 */
			public void setFriends_count(long friends_count) {
				this.friends_count = friends_count;
			}

			/**
			 * Gets the favourites count.
			 *
			 * @return the favourites count
			 */
			public long getFavourites_count() {
				return favourites_count;
			}

			/**
			 * Sets the favourites count.
			 *
			 * @param favourites_count the new favourites count
			 */
			public void setFavourites_count(long favourites_count) {
				this.favourites_count = favourites_count;
			}

			/**
			 * Gets the profile link color.
			 *
			 * @return the profile link color
			 */
			public long getProfile_link_color() {
				return profile_link_color;
			}

			/**
			 * Sets the profile link color.
			 *
			 * @param profile_link_color the new profile link color
			 */
			public void setProfile_link_color(long profile_link_color) {
				this.profile_link_color = profile_link_color;
			}

			/**
			 * Gets the profile background image url https.
			 *
			 * @return the profile background image url https
			 */
			public String getProfile_background_image_url_https() {
				return profile_background_image_url_https;
			}

			/**
			 * Sets the profile background image url https.
			 *
			 * @param profile_background_image_url_https the new profile background image url https
			 */
			public void setProfile_background_image_url_https(String profile_background_image_url_https) {
				this.profile_background_image_url_https = profile_background_image_url_https;
			}

			/**
			 * Gets the utc offset.
			 *
			 * @return the utc offset
			 */
			public long getUtc_offset() {
				return utc_offset;
			}

			/**
			 * Sets the utc offset.
			 *
			 * @param utc_offset the new utc offset
			 */
			public void setUtc_offset(long utc_offset) {
				this.utc_offset = utc_offset;
			}

			/**
			 * Gets the screen name.
			 *
			 * @return the screen name
			 */
			public String getScreen_name() {
				return screen_name;
			}

			/**
			 * Sets the screen name.
			 *
			 * @param screen_name the new screen name
			 */
			public void setScreen_name(String screen_name) {
				this.screen_name = screen_name;
			}

			/**
			 * Checks if is checks if is translator.
			 *
			 * @return true, if is checks if is translator
			 */
			public boolean isIs_translator() {
				return is_translator;
			}

			/**
			 * Sets the checks if is translator.
			 *
			 * @param is_translator the new checks if is translator
			 */
			public void setIs_translator(boolean is_translator) {
				this.is_translator = is_translator;
			}

			/**
			 * Gets the followers count.
			 *
			 * @return the followers count
			 */
			public long getFollowers_count() {
				return followers_count;
			}

			/**
			 * Sets the followers count.
			 *
			 * @param followers_count the new followers count
			 */
			public void setFollowers_count(long followers_count) {
				this.followers_count = followers_count;
			}

			/**
			 * Gets the name.
			 *
			 * @return the name
			 */
			public String getName() {
				return name;
			}

			/**
			 * Sets the name.
			 *
			 * @param name the new name
			 */
			public void setName(String name) {
				this.name = name;
			}

			/**
			 * Gets the lang.
			 *
			 * @return the lang
			 */
			public String getLang() {
				return lang;
			}

			/**
			 * Sets the lang.
			 *
			 * @param lang the new lang
			 */
			public void setLang(String lang) {
				this.lang = lang;
			}

			/**
			 * Checks if is profile use background image.
			 *
			 * @return true, if is profile use background image
			 */
			public boolean isProfile_use_background_image() {
				return profile_use_background_image;
			}

			/**
			 * Sets the profile use background image.
			 *
			 * @param profile_use_background_image the new profile use background image
			 */
			public void setProfile_use_background_image(boolean profile_use_background_image) {
				this.profile_use_background_image = profile_use_background_image;
			}

			/**
			 * Gets the created at.
			 *
			 * @return the created at
			 */
			public String getCreated_at() {
				return created_at;
			}

			/**
			 * Sets the created at.
			 *
			 * @param created_at the new created at
			 */
			public void setCreated_at(String created_at) {
				this.created_at = created_at;
			}

			/**
			 * Gets the profile text color.
			 *
			 * @return the profile text color
			 */
			public long getProfile_text_color() {
				return profile_text_color;
			}

			/**
			 * Sets the profile text color.
			 *
			 * @param profile_text_color the new profile text color
			 */
			public void setProfile_text_color(long profile_text_color) {
				this.profile_text_color = profile_text_color;
			}

			/**
			 * Checks if is notifications.
			 *
			 * @return true, if is notifications
			 */
			public boolean isNotifications() {
				return notifications;
			}

			/**
			 * Sets the notifications.
			 *
			 * @param notifications the new notifications
			 */
			public void setNotifications(boolean notifications) {
				this.notifications = notifications;
			}

			/**
			 * Checks if is protected.
			 *
			 * @return true, if is protected
			 */
			public boolean is_protected() {
				return _protected;
			}

			/**
			 * Sets the protected.
			 *
			 * @param _protected the new protected
			 */
			public void set_protected(boolean _protected) {
				this._protected = _protected;
			}

			/**
			 * Gets the statuses count.
			 *
			 * @return the statuses count
			 */
			public long getStatuses_count() {
				return statuses_count;
			}

			/**
			 * Sets the statuses count.
			 *
			 * @param statuses_count the new statuses count
			 */
			public void setStatuses_count(long statuses_count) {
				this.statuses_count = statuses_count;
			}

			/**
			 * Gets the url.
			 *
			 * @return the url
			 */
			public String getUrl() {
				return url;
			}

			/**
			 * Sets the url.
			 *
			 * @param url the new url
			 */
			public void setUrl(String url) {
				this.url = url;
			}

			/**
			 * Checks if is contributors enabled.
			 *
			 * @return true, if is contributors enabled
			 */
			public boolean isContributors_enabled() {
				return contributors_enabled;
			}

			/**
			 * Sets the contributors enabled.
			 *
			 * @param contributors_enabled the new contributors enabled
			 */
			public void setContributors_enabled(boolean contributors_enabled) {
				this.contributors_enabled = contributors_enabled;
			}

			/**
			 * Checks if is default profile.
			 *
			 * @return true, if is default profile
			 */
			public boolean isDefault_profile() {
				return default_profile;
			}

			/**
			 * Sets the default profile.
			 *
			 * @param default_profile the new default profile
			 */
			public void setDefault_profile(boolean default_profile) {
				this.default_profile = default_profile;
			}

			/**
			 * Gets the profile sidebar border color.
			 *
			 * @return the profile sidebar border color
			 */
			public long getProfile_sidebar_border_color() {
				return profile_sidebar_border_color;
			}

			/**
			 * Sets the profile sidebar border color.
			 *
			 * @param profile_sidebar_border_color the new profile sidebar border color
			 */
			public void setProfile_sidebar_border_color(long profile_sidebar_border_color) {
				this.profile_sidebar_border_color = profile_sidebar_border_color;
			}

			/**
			 * Gets the time zone.
			 *
			 * @return the time zone
			 */
			public String getTime_zone() {
				return time_zone;
			}

			/**
			 * Sets the time zone.
			 *
			 * @param time_zone the new time zone
			 */
			public void setTime_zone(String time_zone) {
				this.time_zone = time_zone;
			}

			/**
			 * Checks if is geo enabled.
			 *
			 * @return true, if is geo enabled
			 */
			public boolean isGeo_enabled() {
				return geo_enabled;
			}

			/**
			 * Sets the geo enabled.
			 *
			 * @param geo_enabled the new geo enabled
			 */
			public void setGeo_enabled(boolean geo_enabled) {
				this.geo_enabled = geo_enabled;
			}

			/**
			 * Checks if is verified.
			 *
			 * @return true, if is verified
			 */
			public boolean isVerified() {
				return verified;
			}

			/**
			 * Sets the verified.
			 *
			 * @param verified the new verified
			 */
			public void setVerified(boolean verified) {
				this.verified = verified;
			}

			/**
			 * Gets the profile image url.
			 *
			 * @return the profile image url
			 */
			public String getProfile_image_url() {
				return profile_image_url;
			}

			/**
			 * Sets the profile image url.
			 *
			 * @param profile_image_url the new profile image url
			 */
			public void setProfile_image_url(String profile_image_url) {
				this.profile_image_url = profile_image_url;
			}

			/**
			 * Checks if is following.
			 *
			 * @return true, if is following
			 */
			public boolean isFollowing() {
				return following;
			}

			/**
			 * Sets the following.
			 *
			 * @param following the new following
			 */
			public void setFollowing(boolean following) {
				this.following = following;
			}

			/**
			 * Gets the profile image url https.
			 *
			 * @return the profile image url https
			 */
			public String getProfile_image_url_https() {
				return profile_image_url_https;
			}

			/**
			 * Sets the profile image url https.
			 *
			 * @param profile_image_url_https the new profile image url https
			 */
			public void setProfile_image_url_https(String profile_image_url_https) {
				this.profile_image_url_https = profile_image_url_https;
			}

			/**
			 * Checks if is profile background tile.
			 *
			 * @return true, if is profile background tile
			 */
			public boolean isProfile_background_tile() {
				return profile_background_tile;
			}

			/**
			 * Sets the profile background tile.
			 *
			 * @param profile_background_tile the new profile background tile
			 */
			public void setProfile_background_tile(boolean profile_background_tile) {
				this.profile_background_tile = profile_background_tile;
			}

			/**
			 * Gets the listed count.
			 *
			 * @return the listed count
			 */
			public long getListed_count() {
				return listed_count;
			}

			/**
			 * Sets the listed count.
			 *
			 * @param listed_count the new listed count
			 */
			public void setListed_count(long listed_count) {
				this.listed_count = listed_count;
			}

			/**
			 * Gets the profile sidebar fill color.
			 *
			 * @return the profile sidebar fill color
			 */
			public long getProfile_sidebar_fill_color() {
				return profile_sidebar_fill_color;
			}

			/**
			 * Sets the profile sidebar fill color.
			 *
			 * @param profile_sidebar_fill_color the new profile sidebar fill color
			 */
			public void setProfile_sidebar_fill_color(long profile_sidebar_fill_color) {
				this.profile_sidebar_fill_color = profile_sidebar_fill_color;
			}

			/**
			 * Gets the location.
			 *
			 * @return the location
			 */
			public String getLocation() {
				return location;
			}

			/**
			 * Sets the location.
			 *
			 * @param location the new location
			 */
			public void setLocation(String location) {
				this.location = location;
			}

			/**
			 * Checks if is follow request sent.
			 *
			 * @return true, if is follow request sent
			 */
			public boolean isFollow_request_sent() {
				return follow_request_sent;
			}

			/**
			 * Sets the follow request sent.
			 *
			 * @param follow_request_sent the new follow request sent
			 */
			public void setFollow_request_sent(boolean follow_request_sent) {
				this.follow_request_sent = follow_request_sent;
			}

			/**
			 * Gets the description.
			 *
			 * @return the description
			 */
			public String getDescription() {
				return description;
			}

			/**
			 * Sets the description.
			 *
			 * @param description the new description
			 */
			public void setDescription(String description) {
				this.description = description;
			}

			/**
			 * Gets the profile background color.
			 *
			 * @return the profile background color
			 */
			public long getProfile_background_color() {
				return profile_background_color;
			}

			/**
			 * Sets the profile background color.
			 *
			 * @param profile_background_color the new profile background color
			 */
			public void setProfile_background_color(long profile_background_color) {
				this.profile_background_color = profile_background_color;
			}

			/** The profile background image url. */
			public   String profile_background_image_url;
            
            /** The friends count. */
            public   long friends_count;
            
            /** The favourites count. */
            public   long favourites_count;
            
            /** The profile link color. */
            public   long profile_link_color;
            
            /** The profile background image url https. */
            public   String profile_background_image_url_https;
            
            /** The utc offset. */
            public   long utc_offset;
            
            /** The screen name. */
            public   String screen_name;
            
            /** The is translator. */
            public   boolean is_translator;
            
            /** The followers count. */
            public   long followers_count;
            
            /** The name. */
            public   String name;
            
            /** The lang. */
            public   String lang;
            
            /** The profile use background image. */
            public   boolean profile_use_background_image;
            
            /** The created at. */
            public   String created_at;
            
            /** The profile text color. */
            public   long profile_text_color;
            
            /** The notifications. */
            public   boolean notifications;
            
            /** The protected. */
            public   boolean _protected;
            
            /** The statuses count. */
            public   long statuses_count;
            
            /** The url. */
            public   String url;
            
            /** The contributors enabled. */
            public   boolean contributors_enabled;
            
            /** The default profile. */
            public   boolean default_profile;
            
            /** The profile sidebar border color. */
            public   long profile_sidebar_border_color;
            
            /** The time zone. */
            public   String time_zone;
            
            /** The geo enabled. */
            public   boolean geo_enabled;
            
            /** The verified. */
            public   boolean verified;
            
            /** The profile image url. */
            public   String profile_image_url;
            
            /** The following. */
            public   boolean following;
            
            /** The profile image url https. */
            public   String profile_image_url_https;
            
            /** The profile background tile. */
            public   boolean profile_background_tile;
            
            /** The listed count. */
            public   long listed_count;
            
            /** The profile sidebar fill color. */
            public   long profile_sidebar_fill_color;
            
            /** The location. */
            public   String location;
            
            /** The follow request sent. */
            public   boolean follow_request_sent;
            
            /** The description. */
            public   String description;
            
            /** The profile background color. */
            public   long profile_background_color;
    
            /**
             * Instantiates a new source.
             *
             * @param id the id
             * @param default_profile_image the default profile image
             * @param profile_background_image_url the profile background image url
             * @param friends_count the friends count
             * @param favourites_count the favourites count
             * @param profile_link_color the profile link color
             * @param profile_background_image_url_https the profile background image url https
             * @param utc_offset the utc offset
             * @param screen_name the screen name
             * @param is_translator the is translator
             * @param followers_count the followers count
             * @param name the name
             * @param lang the lang
             * @param profile_use_background_image the profile use background image
             * @param created_at the created at
             * @param profile_text_color the profile text color
             * @param notifications the notifications
             * @param _protected the protected
             * @param statuses_count the statuses count
             * @param url the url
             * @param contributors_enabled the contributors enabled
             * @param default_profile the default profile
             * @param profile_sidebar_border_color the profile sidebar border color
             * @param time_zone the time zone
             * @param geo_enabled the geo enabled
             * @param verified the verified
             * @param profile_image_url the profile image url
             * @param following the following
             * @param profile_image_url_https the profile image url https
             * @param profile_background_tile the profile background tile
             * @param listed_count the listed count
             * @param profile_sidebar_fill_color the profile sidebar fill color
             * @param location the location
             * @param follow_request_sent the follow request sent
             * @param description the description
             * @param profile_background_color the profile background color
             */
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
