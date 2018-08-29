package de.madana.common.datastructures.twitter;

public final class MDN_TwitterFollowEvent {
    public final String for_user_id;
    public final Follow_event follow_events[];

    public MDN_TwitterFollowEvent(String for_user_id, Follow_event[] follow_events){
        this.for_user_id = for_user_id;
        this.follow_events = follow_events;
    }

    public static final class Follow_event {
        public final String type;
        public final String created_timestamp;
        public final Target target;
        public final Source source;

        public Follow_event(String type, String created_timestamp, Target target, Source source){
            this.type = type;
            this.created_timestamp = created_timestamp;
            this.target = target;
            this.source = source;
        }

        public static final class Target {
            public final String id;
            public final boolean default_profile_image;
            public final String profile_background_image_url;
            public final long friends_count;
            public final long favourites_count;
            public final long profile_link_color;
            public final String profile_background_image_url_https;
            public final long utc_offset;
            public final String screen_name;
            public final boolean is_translator;
            public final long followers_count;
            public final String name;
            public final String lang;
            public final boolean profile_use_background_image;
            public final String created_at;
            public final long profile_text_color;
            public final boolean notifications;
            public final boolean _protected;
            public final long statuses_count;
            public final String url;
            public final boolean contributors_enabled;
            public final boolean default_profile;
            public final long profile_sidebar_border_color;
            public final String time_zone;
            public final boolean geo_enabled;
            public final boolean verified;
            public final String profile_image_url;
            public final boolean following;
            public final String profile_image_url_https;
            public final boolean profile_background_tile;
            public final long listed_count;
            public final long profile_sidebar_fill_color;
            public final String location;
            public final boolean follow_request_sent;
            public final String description;
            public final long profile_background_color;
    
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

        public static final class Source {
            public final String id;
            public final boolean default_profile_image;
            public final String profile_background_image_url;
            public final long friends_count;
            public final long favourites_count;
            public final long profile_link_color;
            public final String profile_background_image_url_https;
            public final long utc_offset;
            public final String screen_name;
            public final boolean is_translator;
            public final long followers_count;
            public final String name;
            public final String lang;
            public final boolean profile_use_background_image;
            public final String created_at;
            public final long profile_text_color;
            public final boolean notifications;
            public final boolean _protected;
            public final long statuses_count;
            public final String url;
            public final boolean contributors_enabled;
            public final boolean default_profile;
            public final long profile_sidebar_border_color;
            public final String time_zone;
            public final boolean geo_enabled;
            public final boolean verified;
            public final String profile_image_url;
            public final boolean following;
            public final String profile_image_url_https;
            public final boolean profile_background_tile;
            public final long listed_count;
            public final long profile_sidebar_fill_color;
            public final String location;
            public final boolean follow_request_sent;
            public final String description;
            public final long profile_background_color;
    
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