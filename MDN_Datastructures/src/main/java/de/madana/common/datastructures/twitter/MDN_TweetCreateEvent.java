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
 * The Class MDN_TweetCreateEvent.
 */
public final class MDN_TweetCreateEvent {
    
    /** The for user id. */
    public final String for_user_id;
    
    /** The tweet create events. */
    public final Tweet_create_event tweet_create_events[];

    /**
     * Instantiates a new MD N tweet create event.
     *
     * @param for_user_id the for user id
     * @param tweet_create_events the tweet create events
     */
    public MDN_TweetCreateEvent(String for_user_id, Tweet_create_event[] tweet_create_events){
        this.for_user_id = for_user_id;
        this.tweet_create_events = tweet_create_events;
    }

    /**
     * The Class Tweet_create_event.
     */
    public static final class Tweet_create_event {
        
        /** The created at. */
        public final String created_at;
        
        /** The id. */
        public final long id;
        
        /** The id str. */
        public final String id_str;
        
        /** The text. */
        public final String text;
        
        /** The source. */
        public final String source;
        
        /** The truncated. */
        public final boolean truncated;
        
        /** The user. */
        public final User user;
        
        /** The retweeted status. */
        public final Retweeted_status retweeted_status;
        
        /** The is quote status. */
        public final boolean is_quote_status;
        
        /** The quote count. */
        public final long quote_count;
        
        /** The reply count. */
        public final long reply_count;
        
        /** The retweet count. */
        public final long retweet_count;
        
        /** The favorite count. */
        public final long favorite_count;
        
        /** The entities. */
        public final Entities entities;
        
        /** The favorited. */
        public final boolean favorited;
        
        /** The retweeted. */
        public final boolean retweeted;
        
        /** The filter level. */
        public final String filter_level;
        
        /** The lang. */
        public final String lang;
        
        /** The timestamp ms. */
        public final String timestamp_ms;

        /**
         * Instantiates a new tweet create event.
         *
         * @param created_at the created at
         * @param id the id
         * @param id_str the id str
         * @param text the text
         * @param source the source
         * @param truncated the truncated
         * @param user the user
         * @param retweeted_status the retweeted status
         * @param is_quote_status the is quote status
         * @param quote_count the quote count
         * @param reply_count the reply count
         * @param retweet_count the retweet count
         * @param favorite_count the favorite count
         * @param entities the entities
         * @param favorited the favorited
         * @param retweeted the retweeted
         * @param filter_level the filter level
         * @param lang the lang
         * @param timestamp_ms the timestamp ms
         */
        public Tweet_create_event(String created_at, long id, String id_str, String text, String source, boolean truncated, User user, Retweeted_status retweeted_status, boolean is_quote_status, long quote_count, long reply_count, long retweet_count, long favorite_count, Entities entities, boolean favorited, boolean retweeted, String filter_level, String lang, String timestamp_ms){
            this.created_at = created_at;
            this.id = id;
            this.id_str = id_str;
            this.text = text;
            this.source = source;
            this.truncated = truncated;
            this.user = user;
            this.retweeted_status = retweeted_status;
            this.is_quote_status = is_quote_status;
            this.quote_count = quote_count;
            this.reply_count = reply_count;
            this.retweet_count = retweet_count;
            this.favorite_count = favorite_count;
            this.entities = entities;
            this.favorited = favorited;
            this.retweeted = retweeted;
            this.filter_level = filter_level;
            this.lang = lang;
            this.timestamp_ms = timestamp_ms;
        }

        /**
         * The Class User.
         */
        public static final class User {
            
            /** The id. */
            public final long id;
            
            /** The id str. */
            public final String id_str;
            
            /** The name. */
            public final String name;
            
            /** The screen name. */
            public final String screen_name;
            
            /** The location. */
            public final Location location;
            
            /** The url. */
            public final Url url;
            
            /** The description. */
            public final Description description;
            
            /** The translator type. */
            public final String translator_type;
            
            /** The protected. */
            public final boolean _protected;
            
            /** The verified. */
            public final boolean verified;
            
            /** The followers count. */
            public final long followers_count;
            
            /** The friends count. */
            public final long friends_count;
            
            /** The listed count. */
            public final long listed_count;
            
            /** The favourites count. */
            public final long favourites_count;
            
            /** The statuses count. */
            public final long statuses_count;
            
            /** The created at. */
            public final String created_at;
            
            /** The utc offset. */
            public final Utc_offset utc_offset;
            
            /** The time zone. */
            public final Time_zone time_zone;
            
            /** The geo enabled. */
            public final boolean geo_enabled;
            
            /** The lang. */
            public final String lang;
            
            /** The contributors enabled. */
            public final boolean contributors_enabled;
            
            /** The is translator. */
            public final boolean is_translator;
            
            /** The profile background color. */
            public final String profile_background_color;
            
            /** The profile background image url. */
            public final String profile_background_image_url;
            
            /** The profile background image url https. */
            public final String profile_background_image_url_https;
            
            /** The profile background tile. */
            public final boolean profile_background_tile;
            
            /** The profile link color. */
            public final String profile_link_color;
            
            /** The profile sidebar border color. */
            public final String profile_sidebar_border_color;
            
            /** The profile sidebar fill color. */
            public final String profile_sidebar_fill_color;
            
            /** The profile text color. */
            public final String profile_text_color;
            
            /** The profile use background image. */
            public final boolean profile_use_background_image;
            
            /** The profile image url. */
            public final String profile_image_url;
            
            /** The profile image url https. */
            public final String profile_image_url_https;
            
            /** The profile banner url. */
            public final String profile_banner_url;
            
            /** The default profile. */
            public final boolean default_profile;
            
            /** The default profile image. */
            public final boolean default_profile_image;
            
            /** The following. */
            public final Following following;
            
            /** The follow request sent. */
            public final Follow_request_sent follow_request_sent;
            
            /** The notifications. */
            public final Notifications notifications;
    
            /**
             * Instantiates a new user.
             *
             * @param id the id
             * @param id_str the id str
             * @param name the name
             * @param screen_name the screen name
             * @param location the location
             * @param url the url
             * @param description the description
             * @param translator_type the translator type
             * @param _protected the protected
             * @param verified the verified
             * @param followers_count the followers count
             * @param friends_count the friends count
             * @param listed_count the listed count
             * @param favourites_count the favourites count
             * @param statuses_count the statuses count
             * @param created_at the created at
             * @param utc_offset the utc offset
             * @param time_zone the time zone
             * @param geo_enabled the geo enabled
             * @param lang the lang
             * @param contributors_enabled the contributors enabled
             * @param is_translator the is translator
             * @param profile_background_color the profile background color
             * @param profile_background_image_url the profile background image url
             * @param profile_background_image_url_https the profile background image url https
             * @param profile_background_tile the profile background tile
             * @param profile_link_color the profile link color
             * @param profile_sidebar_border_color the profile sidebar border color
             * @param profile_sidebar_fill_color the profile sidebar fill color
             * @param profile_text_color the profile text color
             * @param profile_use_background_image the profile use background image
             * @param profile_image_url the profile image url
             * @param profile_image_url_https the profile image url https
             * @param profile_banner_url the profile banner url
             * @param default_profile the default profile
             * @param default_profile_image the default profile image
             * @param following the following
             * @param follow_request_sent the follow request sent
             * @param notifications the notifications
             */
            public User(long id, String id_str, String name, String screen_name, Location location, Url url, Description description, String translator_type, boolean _protected, boolean verified, long followers_count, long friends_count, long listed_count, long favourites_count, long statuses_count, String created_at, Utc_offset utc_offset, Time_zone time_zone, boolean geo_enabled, String lang, boolean contributors_enabled, boolean is_translator, String profile_background_color, String profile_background_image_url, String profile_background_image_url_https, boolean profile_background_tile, String profile_link_color, String profile_sidebar_border_color, String profile_sidebar_fill_color, String profile_text_color, boolean profile_use_background_image, String profile_image_url, String profile_image_url_https, String profile_banner_url, boolean default_profile, boolean default_profile_image, Following following, Follow_request_sent follow_request_sent, Notifications notifications){
                this.id = id;
                this.id_str = id_str;
                this.name = name;
                this.screen_name = screen_name;
                this.location = location;
                this.url = url;
                this.description = description;
                this.translator_type = translator_type;
                this._protected = _protected;
                this.verified = verified;
                this.followers_count = followers_count;
                this.friends_count = friends_count;
                this.listed_count = listed_count;
                this.favourites_count = favourites_count;
                this.statuses_count = statuses_count;
                this.created_at = created_at;
                this.utc_offset = utc_offset;
                this.time_zone = time_zone;
                this.geo_enabled = geo_enabled;
                this.lang = lang;
                this.contributors_enabled = contributors_enabled;
                this.is_translator = is_translator;
                this.profile_background_color = profile_background_color;
                this.profile_background_image_url = profile_background_image_url;
                this.profile_background_image_url_https = profile_background_image_url_https;
                this.profile_background_tile = profile_background_tile;
                this.profile_link_color = profile_link_color;
                this.profile_sidebar_border_color = profile_sidebar_border_color;
                this.profile_sidebar_fill_color = profile_sidebar_fill_color;
                this.profile_text_color = profile_text_color;
                this.profile_use_background_image = profile_use_background_image;
                this.profile_image_url = profile_image_url;
                this.profile_image_url_https = profile_image_url_https;
                this.profile_banner_url = profile_banner_url;
                this.default_profile = default_profile;
                this.default_profile_image = default_profile_image;
                this.following = following;
                this.follow_request_sent = follow_request_sent;
                this.notifications = notifications;
            }
    
            /**
             * The Class Location.
             */
            public static final class Location {
        
                /**
                 * Instantiates a new location.
                 */
                public Location(){
                }
            }
    
            /**
             * The Class Url.
             */
            public static final class Url {
        
                /**
                 * Instantiates a new url.
                 */
                public Url(){
                }
            }
    
            /**
             * The Class Description.
             */
            public static final class Description {
        
                /**
                 * Instantiates a new description.
                 */
                public Description(){
                }
            }
    
            /**
             * The Class Utc_offset.
             */
            public static final class Utc_offset {
        
                /**
                 * Instantiates a new utc offset.
                 */
                public Utc_offset(){
                }
            }
    
            /**
             * The Class Time_zone.
             */
            public static final class Time_zone {
        
                /**
                 * Instantiates a new time zone.
                 */
                public Time_zone(){
                }
            }
    
            /**
             * The Class Following.
             */
            public static final class Following {
        
                /**
                 * Instantiates a new following.
                 */
                public Following(){
                }
            }
    
            /**
             * The Class Follow_request_sent.
             */
            public static final class Follow_request_sent {
        
                /**
                 * Instantiates a new follow request sent.
                 */
                public Follow_request_sent(){
                }
            }
    
            /**
             * The Class Notifications.
             */
            public static final class Notifications {
        
                /**
                 * Instantiates a new notifications.
                 */
                public Notifications(){
                }
            }
        }

        /**
         * The Class Retweeted_status.
         */
        public static final class Retweeted_status {
            
            /** The created at. */
            public final String created_at;
            
            /** The id. */
            public final long id;
            
            /** The id str. */
            public final String id_str;
            
            /** The text. */
            public final String text;
            
            /** The display text range. */
            public final int[] display_text_range;
            
            /** The source. */
            public final String source;
            
            /** The truncated. */
            public final boolean truncated;
            
            /** The in reply to status id. */
            public final In_reply_to_status_id in_reply_to_status_id;
            
            /** The in reply to status id str. */
            public final In_reply_to_status_id_str in_reply_to_status_id_str;
            
            /** The in reply to user id. */
            public final In_reply_to_user_id in_reply_to_user_id;
            
            /** The in reply to user id str. */
            public final In_reply_to_user_id_str in_reply_to_user_id_str;
            
            /** The in reply to screen name. */
            public final In_reply_to_screen_name in_reply_to_screen_name;
            
            /** The user. */
            public final User user;
            
            /** The geo. */
            public final Geo geo;
            
            /** The coordinates. */
            public final Coordinates coordinates;
            
            /** The place. */
            public final Place place;
            
            /** The contributors. */
            public final Contributors contributors;
            
            /** The is quote status. */
            public final boolean is_quote_status;
            
            /** The extended tweet. */
            public final Extended_tweet extended_tweet;
            
            /** The quote count. */
            public final long quote_count;
            
            /** The reply count. */
            public final long reply_count;
            
            /** The retweet count. */
            public final long retweet_count;
            
            /** The favorite count. */
            public final long favorite_count;
            
            /** The entities. */
            public final Entities entities;
            
            /** The favorited. */
            public final boolean favorited;
            
            /** The retweeted. */
            public final boolean retweeted;
            
            /** The possibly sensitive. */
            public final boolean possibly_sensitive;
            
            /** The filter level. */
            public final String filter_level;
            
            /** The lang. */
            public final String lang;
    
            /**
             * Instantiates a new retweeted status.
             *
             * @param created_at the created at
             * @param id the id
             * @param id_str the id str
             * @param text the text
             * @param display_text_range the display text range
             * @param source the source
             * @param truncated the truncated
             * @param in_reply_to_status_id the in reply to status id
             * @param in_reply_to_status_id_str the in reply to status id str
             * @param in_reply_to_user_id the in reply to user id
             * @param in_reply_to_user_id_str the in reply to user id str
             * @param in_reply_to_screen_name the in reply to screen name
             * @param user the user
             * @param geo the geo
             * @param coordinates the coordinates
             * @param place the place
             * @param contributors the contributors
             * @param is_quote_status the is quote status
             * @param extended_tweet the extended tweet
             * @param quote_count the quote count
             * @param reply_count the reply count
             * @param retweet_count the retweet count
             * @param favorite_count the favorite count
             * @param entities the entities
             * @param favorited the favorited
             * @param retweeted the retweeted
             * @param possibly_sensitive the possibly sensitive
             * @param filter_level the filter level
             * @param lang the lang
             */
            public Retweeted_status(String created_at, long id, String id_str, String text, int[] display_text_range, String source, boolean truncated, In_reply_to_status_id in_reply_to_status_id, In_reply_to_status_id_str in_reply_to_status_id_str, In_reply_to_user_id in_reply_to_user_id, In_reply_to_user_id_str in_reply_to_user_id_str, In_reply_to_screen_name in_reply_to_screen_name, User user, Geo geo, Coordinates coordinates, Place place, Contributors contributors, boolean is_quote_status, Extended_tweet extended_tweet, long quote_count, long reply_count, long retweet_count, long favorite_count, Entities entities, boolean favorited, boolean retweeted, boolean possibly_sensitive, String filter_level, String lang){
                this.created_at = created_at;
                this.id = id;
                this.id_str = id_str;
                this.text = text;
                this.display_text_range = display_text_range;
                this.source = source;
                this.truncated = truncated;
                this.in_reply_to_status_id = in_reply_to_status_id;
                this.in_reply_to_status_id_str = in_reply_to_status_id_str;
                this.in_reply_to_user_id = in_reply_to_user_id;
                this.in_reply_to_user_id_str = in_reply_to_user_id_str;
                this.in_reply_to_screen_name = in_reply_to_screen_name;
                this.user = user;
                this.geo = geo;
                this.coordinates = coordinates;
                this.place = place;
                this.contributors = contributors;
                this.is_quote_status = is_quote_status;
                this.extended_tweet = extended_tweet;
                this.quote_count = quote_count;
                this.reply_count = reply_count;
                this.retweet_count = retweet_count;
                this.favorite_count = favorite_count;
                this.entities = entities;
                this.favorited = favorited;
                this.retweeted = retweeted;
                this.possibly_sensitive = possibly_sensitive;
                this.filter_level = filter_level;
                this.lang = lang;
            }
    
            /**
             * The Class In_reply_to_status_id.
             */
            public static final class In_reply_to_status_id {
        
                /**
                 * Instantiates a new in reply to status id.
                 */
                public In_reply_to_status_id(){
                }
            }
    
            /**
             * The Class In_reply_to_status_id_str.
             */
            public static final class In_reply_to_status_id_str {
        
                /**
                 * Instantiates a new in reply to status id str.
                 */
                public In_reply_to_status_id_str(){
                }
            }
    
            /**
             * The Class In_reply_to_user_id.
             */
            public static final class In_reply_to_user_id {
        
                /**
                 * Instantiates a new in reply to user id.
                 */
                public In_reply_to_user_id(){
                }
            }
    
            /**
             * The Class In_reply_to_user_id_str.
             */
            public static final class In_reply_to_user_id_str {
        
                /**
                 * Instantiates a new in reply to user id str.
                 */
                public In_reply_to_user_id_str(){
                }
            }
    
            /**
             * The Class In_reply_to_screen_name.
             */
            public static final class In_reply_to_screen_name {
        
                /**
                 * Instantiates a new in reply to screen name.
                 */
                public In_reply_to_screen_name(){
                }
            }
    
            /**
             * The Class User.
             */
            public static final class User {
                
                /** The id. */
                public final long id;
                
                /** The id str. */
                public final String id_str;
                
                /** The name. */
                public final String name;
                
                /** The screen name. */
                public final String screen_name;
                
                /** The location. */
                public final String location;
                
                /** The url. */
                public final String url;
                
                /** The description. */
                public final String description;
                
                /** The translator type. */
                public final String translator_type;
                
                /** The protected. */
                public final boolean _protected;
                
                /** The verified. */
                public final boolean verified;
                
                /** The followers count. */
                public final long followers_count;
                
                /** The friends count. */
                public final long friends_count;
                
                /** The listed count. */
                public final long listed_count;
                
                /** The favourites count. */
                public final long favourites_count;
                
                /** The statuses count. */
                public final long statuses_count;
                
                /** The created at. */
                public final String created_at;
                
                /** The utc offset. */
                public final Utc_offset utc_offset;
                
                /** The time zone. */
                public final Time_zone time_zone;
                
                /** The geo enabled. */
                public final boolean geo_enabled;
                
                /** The lang. */
                public final String lang;
                
                /** The contributors enabled. */
                public final boolean contributors_enabled;
                
                /** The is translator. */
                public final boolean is_translator;
                
                /** The profile background color. */
                public final String profile_background_color;
                
                /** The profile background image url. */
                public final String profile_background_image_url;
                
                /** The profile background image url https. */
                public final String profile_background_image_url_https;
                
                /** The profile background tile. */
                public final boolean profile_background_tile;
                
                /** The profile link color. */
                public final String profile_link_color;
                
                /** The profile sidebar border color. */
                public final String profile_sidebar_border_color;
                
                /** The profile sidebar fill color. */
                public final String profile_sidebar_fill_color;
                
                /** The profile text color. */
                public final String profile_text_color;
                
                /** The profile use background image. */
                public final boolean profile_use_background_image;
                
                /** The profile image url. */
                public final String profile_image_url;
                
                /** The profile image url https. */
                public final String profile_image_url_https;
                
                /** The profile banner url. */
                public final String profile_banner_url;
                
                /** The default profile. */
                public final boolean default_profile;
                
                /** The default profile image. */
                public final boolean default_profile_image;
                
                /** The following. */
                public final Following following;
                
                /** The follow request sent. */
                public final Follow_request_sent follow_request_sent;
                
                /** The notifications. */
                public final Notifications notifications;
        
                /**
                 * Instantiates a new user.
                 *
                 * @param id the id
                 * @param id_str the id str
                 * @param name the name
                 * @param screen_name the screen name
                 * @param location the location
                 * @param url the url
                 * @param description the description
                 * @param translator_type the translator type
                 * @param _protected the protected
                 * @param verified the verified
                 * @param followers_count the followers count
                 * @param friends_count the friends count
                 * @param listed_count the listed count
                 * @param favourites_count the favourites count
                 * @param statuses_count the statuses count
                 * @param created_at the created at
                 * @param utc_offset the utc offset
                 * @param time_zone the time zone
                 * @param geo_enabled the geo enabled
                 * @param lang the lang
                 * @param contributors_enabled the contributors enabled
                 * @param is_translator the is translator
                 * @param profile_background_color the profile background color
                 * @param profile_background_image_url the profile background image url
                 * @param profile_background_image_url_https the profile background image url https
                 * @param profile_background_tile the profile background tile
                 * @param profile_link_color the profile link color
                 * @param profile_sidebar_border_color the profile sidebar border color
                 * @param profile_sidebar_fill_color the profile sidebar fill color
                 * @param profile_text_color the profile text color
                 * @param profile_use_background_image the profile use background image
                 * @param profile_image_url the profile image url
                 * @param profile_image_url_https the profile image url https
                 * @param profile_banner_url the profile banner url
                 * @param default_profile the default profile
                 * @param default_profile_image the default profile image
                 * @param following the following
                 * @param follow_request_sent the follow request sent
                 * @param notifications the notifications
                 */
                public User(long id, String id_str, String name, String screen_name, String location, String url, String description, String translator_type, boolean _protected, boolean verified, long followers_count, long friends_count, long listed_count, long favourites_count, long statuses_count, String created_at, Utc_offset utc_offset, Time_zone time_zone, boolean geo_enabled, String lang, boolean contributors_enabled, boolean is_translator, String profile_background_color, String profile_background_image_url, String profile_background_image_url_https, boolean profile_background_tile, String profile_link_color, String profile_sidebar_border_color, String profile_sidebar_fill_color, String profile_text_color, boolean profile_use_background_image, String profile_image_url, String profile_image_url_https, String profile_banner_url, boolean default_profile, boolean default_profile_image, Following following, Follow_request_sent follow_request_sent, Notifications notifications){
                    this.id = id;
                    this.id_str = id_str;
                    this.name = name;
                    this.screen_name = screen_name;
                    this.location = location;
                    this.url = url;
                    this.description = description;
                    this.translator_type = translator_type;
                    this._protected = _protected;
                    this.verified = verified;
                    this.followers_count = followers_count;
                    this.friends_count = friends_count;
                    this.listed_count = listed_count;
                    this.favourites_count = favourites_count;
                    this.statuses_count = statuses_count;
                    this.created_at = created_at;
                    this.utc_offset = utc_offset;
                    this.time_zone = time_zone;
                    this.geo_enabled = geo_enabled;
                    this.lang = lang;
                    this.contributors_enabled = contributors_enabled;
                    this.is_translator = is_translator;
                    this.profile_background_color = profile_background_color;
                    this.profile_background_image_url = profile_background_image_url;
                    this.profile_background_image_url_https = profile_background_image_url_https;
                    this.profile_background_tile = profile_background_tile;
                    this.profile_link_color = profile_link_color;
                    this.profile_sidebar_border_color = profile_sidebar_border_color;
                    this.profile_sidebar_fill_color = profile_sidebar_fill_color;
                    this.profile_text_color = profile_text_color;
                    this.profile_use_background_image = profile_use_background_image;
                    this.profile_image_url = profile_image_url;
                    this.profile_image_url_https = profile_image_url_https;
                    this.profile_banner_url = profile_banner_url;
                    this.default_profile = default_profile;
                    this.default_profile_image = default_profile_image;
                    this.following = following;
                    this.follow_request_sent = follow_request_sent;
                    this.notifications = notifications;
                }
        
                /**
                 * The Class Utc_offset.
                 */
                public static final class Utc_offset {
            
                    /**
                     * Instantiates a new utc offset.
                     */
                    public Utc_offset(){
                    }
                }
        
                /**
                 * The Class Time_zone.
                 */
                public static final class Time_zone {
            
                    /**
                     * Instantiates a new time zone.
                     */
                    public Time_zone(){
                    }
                }
        
                /**
                 * The Class Following.
                 */
                public static final class Following {
            
                    /**
                     * Instantiates a new following.
                     */
                    public Following(){
                    }
                }
        
                /**
                 * The Class Follow_request_sent.
                 */
                public static final class Follow_request_sent {
            
                    /**
                     * Instantiates a new follow request sent.
                     */
                    public Follow_request_sent(){
                    }
                }
        
                /**
                 * The Class Notifications.
                 */
                public static final class Notifications {
            
                    /**
                     * Instantiates a new notifications.
                     */
                    public Notifications(){
                    }
                }
            }
    
            /**
             * The Class Geo.
             */
            public static final class Geo {
        
                /**
                 * Instantiates a new geo.
                 */
                public Geo(){
                }
            }
    
            /**
             * The Class Coordinates.
             */
            public static final class Coordinates {
        
                /**
                 * Instantiates a new coordinates.
                 */
                public Coordinates(){
                }
            }
    
            /**
             * The Class Place.
             */
            public static final class Place {
        
                /**
                 * Instantiates a new place.
                 */
                public Place(){
                }
            }
    
            /**
             * The Class Contributors.
             */
            public static final class Contributors {
        
                /**
                 * Instantiates a new contributors.
                 */
                public Contributors(){
                }
            }
    
            /**
             * The Class Extended_tweet.
             */
            public static final class Extended_tweet {
                
                /** The full text. */
                public final String full_text;
                
                /** The display text range. */
                public final int[] display_text_range;
                
                /** The entities. */
                public final Entities entities;
                
                /** The extended entities. */
                public final Extended_entities extended_entities;
        
                /**
                 * Instantiates a new extended tweet.
                 *
                 * @param full_text the full text
                 * @param display_text_range the display text range
                 * @param entities the entities
                 * @param extended_entities the extended entities
                 */
                public Extended_tweet(String full_text, int[] display_text_range, Entities entities, Extended_entities extended_entities){
                    this.full_text = full_text;
                    this.display_text_range = display_text_range;
                    this.entities = entities;
                    this.extended_entities = extended_entities;
                }
        
                /**
                 * The Class Entities.
                 */
                public static final class Entities {
                    
                    /** The hashtags. */
                    public final Hashtag hashtags[];
                    
                    /** The urls. */
                    public final Url urls[];
                    
                    /** The user mentions. */
                    public final User_mention user_mentions[];
                    
                    /** The symbols. */
                    public final Symbol symbols[];
                    
                    /** The media. */
                    public final Media media[];
            
                    /**
                     * Instantiates a new entities.
                     *
                     * @param hashtags the hashtags
                     * @param urls the urls
                     * @param user_mentions the user mentions
                     * @param symbols the symbols
                     * @param media the media
                     */
                    public Entities(Hashtag[] hashtags, Url[] urls, User_mention[] user_mentions, Symbol[] symbols, Media[] media){
                        this.hashtags = hashtags;
                        this.urls = urls;
                        this.user_mentions = user_mentions;
                        this.symbols = symbols;
                        this.media = media;
                    }
            
                    /**
                     * The Class Hashtag.
                     */
                    public static final class Hashtag {
                        
                        /** The text. */
                        public final String text;
                        
                        /** The indices. */
                        public final int[] indices;
                
                        /**
                         * Instantiates a new hashtag.
                         *
                         * @param text the text
                         * @param indices the indices
                         */
                        public Hashtag(String text, int[] indices){
                            this.text = text;
                            this.indices = indices;
                        }
                    }
            
                    /**
                     * The Class Url.
                     */
                    public static final class Url {
                
                        /**
                         * Instantiates a new url.
                         */
                        public Url(){
                        }
                    }
            
                    /**
                     * The Class User_mention.
                     */
                    public static final class User_mention {
                        
                        /** The screen name. */
                        public final String screen_name;
                        
                        /** The name. */
                        public final String name;
                        
                        /** The id. */
                        public final long id;
                        
                        /** The id str. */
                        public final String id_str;
                        
                        /** The indices. */
                        public final int[] indices;
                
                        /**
                         * Instantiates a new user mention.
                         *
                         * @param screen_name the screen name
                         * @param name the name
                         * @param id the id
                         * @param id_str the id str
                         * @param indices the indices
                         */
                        public User_mention(String screen_name, String name, long id, String id_str, int[] indices){
                            this.screen_name = screen_name;
                            this.name = name;
                            this.id = id;
                            this.id_str = id_str;
                            this.indices = indices;
                        }
                    }
            
                    /**
                     * The Class Symbol.
                     */
                    public static final class Symbol {
                
                        /**
                         * Instantiates a new symbol.
                         */
                        public Symbol(){
                        }
                    }
            
                    /**
                     * The Class Media.
                     */
                    public static final class Media {
                        
                        /** The id. */
                        public final long id;
                        
                        /** The id str. */
                        public final String id_str;
                        
                        /** The indices. */
                        public final int[] indices;
                        
                        /** The media url. */
                        public final String media_url;
                        
                        /** The media url https. */
                        public final String media_url_https;
                        
                        /** The url. */
                        public final String url;
                        
                        /** The display url. */
                        public final String display_url;
                        
                        /** The expanded url. */
                        public final String expanded_url;
                        
                        /** The type. */
                        public final String type;
                        
                        /** The sizes. */
                        public final Sizes sizes;
                
                        /**
                         * Instantiates a new media.
                         *
                         * @param id the id
                         * @param id_str the id str
                         * @param indices the indices
                         * @param media_url the media url
                         * @param media_url_https the media url https
                         * @param url the url
                         * @param display_url the display url
                         * @param expanded_url the expanded url
                         * @param type the type
                         * @param sizes the sizes
                         */
                        public Media(long id, String id_str, int[] indices, String media_url, String media_url_https, String url, String display_url, String expanded_url, String type, Sizes sizes){
                            this.id = id;
                            this.id_str = id_str;
                            this.indices = indices;
                            this.media_url = media_url;
                            this.media_url_https = media_url_https;
                            this.url = url;
                            this.display_url = display_url;
                            this.expanded_url = expanded_url;
                            this.type = type;
                            this.sizes = sizes;
                        }
                
                        /**
                         * The Class Sizes.
                         */
                        public static final class Sizes {
                            
                            /** The medium. */
                            public final Medium medium;
                            
                            /** The thumb. */
                            public final Thumb thumb;
                            
                            /** The large. */
                            public final Large large;
                            
                            /** The small. */
                            public final Small small;
                    
                            /**
                             * Instantiates a new sizes.
                             *
                             * @param medium the medium
                             * @param thumb the thumb
                             * @param large the large
                             * @param small the small
                             */
                            public Sizes(Medium medium, Thumb thumb, Large large, Small small){
                                this.medium = medium;
                                this.thumb = thumb;
                                this.large = large;
                                this.small = small;
                            }
                    
                            /**
                             * The Class Medium.
                             */
                            public static final class Medium {
                                
                                /** The w. */
                                public final long w;
                                
                                /** The h. */
                                public final long h;
                                
                                /** The resize. */
                                public final String resize;
                        
                                /**
                                 * Instantiates a new medium.
                                 *
                                 * @param w the w
                                 * @param h the h
                                 * @param resize the resize
                                 */
                                public Medium(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            /**
                             * The Class Thumb.
                             */
                            public static final class Thumb {
                                
                                /** The w. */
                                public final long w;
                                
                                /** The h. */
                                public final long h;
                                
                                /** The resize. */
                                public final String resize;
                        
                                /**
                                 * Instantiates a new thumb.
                                 *
                                 * @param w the w
                                 * @param h the h
                                 * @param resize the resize
                                 */
                                public Thumb(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            /**
                             * The Class Large.
                             */
                            public static final class Large {
                                
                                /** The w. */
                                public final long w;
                                
                                /** The h. */
                                public final long h;
                                
                                /** The resize. */
                                public final String resize;
                        
                                /**
                                 * Instantiates a new large.
                                 *
                                 * @param w the w
                                 * @param h the h
                                 * @param resize the resize
                                 */
                                public Large(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            /**
                             * The Class Small.
                             */
                            public static final class Small {
                                
                                /** The w. */
                                public final long w;
                                
                                /** The h. */
                                public final long h;
                                
                                /** The resize. */
                                public final String resize;
                        
                                /**
                                 * Instantiates a new small.
                                 *
                                 * @param w the w
                                 * @param h the h
                                 * @param resize the resize
                                 */
                                public Small(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                        }
                    }
                }
        
                /**
                 * The Class Extended_entities.
                 */
                public static final class Extended_entities {
                    
                    /** The media. */
                    public final Media media[];
            
                    /**
                     * Instantiates a new extended entities.
                     *
                     * @param media the media
                     */
                    public Extended_entities(Media[] media){
                        this.media = media;
                    }
            
                    /**
                     * The Class Media.
                     */
                    public static final class Media {
                        
                        /** The id. */
                        public final long id;
                        
                        /** The id str. */
                        public final String id_str;
                        
                        /** The indices. */
                        public final int[] indices;
                        
                        /** The media url. */
                        public final String media_url;
                        
                        /** The media url https. */
                        public final String media_url_https;
                        
                        /** The url. */
                        public final String url;
                        
                        /** The display url. */
                        public final String display_url;
                        
                        /** The expanded url. */
                        public final String expanded_url;
                        
                        /** The type. */
                        public final String type;
                        
                        /** The sizes. */
                        public final Sizes sizes;
                
                        /**
                         * Instantiates a new media.
                         *
                         * @param id the id
                         * @param id_str the id str
                         * @param indices the indices
                         * @param media_url the media url
                         * @param media_url_https the media url https
                         * @param url the url
                         * @param display_url the display url
                         * @param expanded_url the expanded url
                         * @param type the type
                         * @param sizes the sizes
                         */
                        public Media(long id, String id_str, int[] indices, String media_url, String media_url_https, String url, String display_url, String expanded_url, String type, Sizes sizes){
                            this.id = id;
                            this.id_str = id_str;
                            this.indices = indices;
                            this.media_url = media_url;
                            this.media_url_https = media_url_https;
                            this.url = url;
                            this.display_url = display_url;
                            this.expanded_url = expanded_url;
                            this.type = type;
                            this.sizes = sizes;
                        }
                
                        /**
                         * The Class Sizes.
                         */
                        public static final class Sizes {
                            
                            /** The medium. */
                            public final Medium medium;
                            
                            /** The thumb. */
                            public final Thumb thumb;
                            
                            /** The large. */
                            public final Large large;
                            
                            /** The small. */
                            public final Small small;
                    
                            /**
                             * Instantiates a new sizes.
                             *
                             * @param medium the medium
                             * @param thumb the thumb
                             * @param large the large
                             * @param small the small
                             */
                            public Sizes(Medium medium, Thumb thumb, Large large, Small small){
                                this.medium = medium;
                                this.thumb = thumb;
                                this.large = large;
                                this.small = small;
                            }
                    
                            /**
                             * The Class Medium.
                             */
                            public static final class Medium {
                                
                                /** The w. */
                                public final long w;
                                
                                /** The h. */
                                public final long h;
                                
                                /** The resize. */
                                public final String resize;
                        
                                /**
                                 * Instantiates a new medium.
                                 *
                                 * @param w the w
                                 * @param h the h
                                 * @param resize the resize
                                 */
                                public Medium(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            /**
                             * The Class Thumb.
                             */
                            public static final class Thumb {
                                
                                /** The w. */
                                public final long w;
                                
                                /** The h. */
                                public final long h;
                                
                                /** The resize. */
                                public final String resize;
                        
                                /**
                                 * Instantiates a new thumb.
                                 *
                                 * @param w the w
                                 * @param h the h
                                 * @param resize the resize
                                 */
                                public Thumb(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            /**
                             * The Class Large.
                             */
                            public static final class Large {
                                
                                /** The w. */
                                public final long w;
                                
                                /** The h. */
                                public final long h;
                                
                                /** The resize. */
                                public final String resize;
                        
                                /**
                                 * Instantiates a new large.
                                 *
                                 * @param w the w
                                 * @param h the h
                                 * @param resize the resize
                                 */
                                public Large(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                    
                            /**
                             * The Class Small.
                             */
                            public static final class Small {
                                
                                /** The w. */
                                public final long w;
                                
                                /** The h. */
                                public final long h;
                                
                                /** The resize. */
                                public final String resize;
                        
                                /**
                                 * Instantiates a new small.
                                 *
                                 * @param w the w
                                 * @param h the h
                                 * @param resize the resize
                                 */
                                public Small(long w, long h, String resize){
                                    this.w = w;
                                    this.h = h;
                                    this.resize = resize;
                                }
                            }
                        }
                    }
                }
            }
    
            /**
             * The Class Entities.
             */
            public static final class Entities {
                
                /** The hashtags. */
                public final Hashtag hashtags[];
                
                /** The urls. */
                public final Url urls[];
                
                /** The user mentions. */
                public final User_mention user_mentions[];
                
                /** The symbols. */
                public final Symbol symbols[];
        
                /**
                 * Instantiates a new entities.
                 *
                 * @param hashtags the hashtags
                 * @param urls the urls
                 * @param user_mentions the user mentions
                 * @param symbols the symbols
                 */
                public Entities(Hashtag[] hashtags, Url[] urls, User_mention[] user_mentions, Symbol[] symbols){
                    this.hashtags = hashtags;
                    this.urls = urls;
                    this.user_mentions = user_mentions;
                    this.symbols = symbols;
                }
        
                /**
                 * The Class Hashtag.
                 */
                public static final class Hashtag {
                    
                    /** The text. */
                    public final String text;
                    
                    /** The indices. */
                    public final int[] indices;
            
                    /**
                     * Instantiates a new hashtag.
                     *
                     * @param text the text
                     * @param indices the indices
                     */
                    public Hashtag(String text, int[] indices){
                        this.text = text;
                        this.indices = indices;
                    }
                }
        
                /**
                 * The Class Url.
                 */
                public static final class Url {
                    
                    /** The url. */
                    public final String url;
                    
                    /** The expanded url. */
                    public final String expanded_url;
                    
                    /** The display url. */
                    public final String display_url;
                    
                    /** The indices. */
                    public final int[] indices;
            
                    /**
                     * Instantiates a new url.
                     *
                     * @param url the url
                     * @param expanded_url the expanded url
                     * @param display_url the display url
                     * @param indices the indices
                     */
                    public Url(String url, String expanded_url, String display_url, int[] indices){
                        this.url = url;
                        this.expanded_url = expanded_url;
                        this.display_url = display_url;
                        this.indices = indices;
                    }
                }
        
                /**
                 * The Class User_mention.
                 */
                public static final class User_mention {
                    
                    /** The screen name. */
                    public final String screen_name;
                    
                    /** The name. */
                    public final String name;
                    
                    /** The id. */
                    public final long id;
                    
                    /** The id str. */
                    public final String id_str;
                    
                    /** The indices. */
                    public final int[] indices;
            
                    /**
                     * Instantiates a new user mention.
                     *
                     * @param screen_name the screen name
                     * @param name the name
                     * @param id the id
                     * @param id_str the id str
                     * @param indices the indices
                     */
                    public User_mention(String screen_name, String name, long id, String id_str, int[] indices){
                        this.screen_name = screen_name;
                        this.name = name;
                        this.id = id;
                        this.id_str = id_str;
                        this.indices = indices;
                    }
                }
        
                /**
                 * The Class Symbol.
                 */
                public static final class Symbol {
            
                    /**
                     * Instantiates a new symbol.
                     */
                    public Symbol(){
                    }
                }
            }
        }

        /**
         * The Class Entities.
         */
        public static final class Entities {
            
            /** The hashtags. */
            public final Hashtag hashtags[];
            
            /** The urls. */
            public final Url urls[];
            
            /** The user mentions. */
            public final User_mention user_mentions[];
            
            /** The symbols. */
            public final Symbol symbols[];
    
            /**
             * Instantiates a new entities.
             *
             * @param hashtags the hashtags
             * @param urls the urls
             * @param user_mentions the user mentions
             * @param symbols the symbols
             */
            public Entities(Hashtag[] hashtags, Url[] urls, User_mention[] user_mentions, Symbol[] symbols){
                this.hashtags = hashtags;
                this.urls = urls;
                this.user_mentions = user_mentions;
                this.symbols = symbols;
            }
    
            /**
             * The Class Hashtag.
             */
            public static final class Hashtag {
                
                /** The text. */
                public final String text;
                
                /** The indices. */
                public final int[] indices;
        
                /**
                 * Instantiates a new hashtag.
                 *
                 * @param text the text
                 * @param indices the indices
                 */
                public Hashtag(String text, int[] indices){
                    this.text = text;
                    this.indices = indices;
                }
            }
    
            /**
             * The Class Url.
             */
            public static final class Url {
        
                /**
                 * Instantiates a new url.
                 */
                public Url(){
                }
            }
    
            /**
             * The Class User_mention.
             */
            public static final class User_mention {
                
                /** The screen name. */
                public final String screen_name;
                
                /** The name. */
                public final String name;
                
                /** The id. */
                public final long id;
                
                /** The id str. */
                public final String id_str;
                
                /** The indices. */
                public final int[] indices;
        
                /**
                 * Instantiates a new user mention.
                 *
                 * @param screen_name the screen name
                 * @param name the name
                 * @param id the id
                 * @param id_str the id str
                 * @param indices the indices
                 */
                public User_mention(String screen_name, String name, long id, String id_str, int[] indices){
                    this.screen_name = screen_name;
                    this.name = name;
                    this.id = id;
                    this.id_str = id_str;
                    this.indices = indices;
                }
            }
    
            /**
             * The Class Symbol.
             */
            public static final class Symbol {
        
                /**
                 * Instantiates a new symbol.
                 */
                public Symbol(){
                }
            }
        }
    }
}
